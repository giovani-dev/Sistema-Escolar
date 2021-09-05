package Professor
import Base.InfoDataClass
import Base.InfoInterface
import Utils.DadosInvalidos
import Utils.ErroInesperado

class Professor : InfoInterface {
    override var info: InfoDataClass
    override lateinit var data: InfoDataClass

    constructor(
        nome: String,
        sobrenome: String,
        tempo_casa: String,
        codigo: Int,
        especialidade: String?,
        horas_monitoria: Int?,
        is_adjunto: Boolean,
        is_titular: Boolean
    ) {
        this.info = InfoProfessor(
            nome = nome,
            sobrenome = sobrenome,
            tempo_casa = tempo_casa,
            codigo = codigo,
            especialidade = especialidade,
            horas_monitoria = horas_monitoria,
            is_adjunto = is_adjunto,
            is_titular = is_titular
        )
    }

    override fun equals(other: Any?): Boolean {
        return (other is Professor) && (other.info.codigo == this.info.codigo)
    }

    private fun is_titular(info: InfoDataClass?): Boolean {
        return (
            info is InfoProfessor &&
                info.is_titular &&
                !info.is_adjunto &&
                info.especialidade != null &&
                info.horas_monitoria == null
        )
    }

    private fun is_adjunto(info: InfoDataClass?): Boolean {
        return (
            info is InfoProfessor &&
                !info.is_titular &&
                info.is_adjunto &&
                info.especialidade == null &&
                info.horas_monitoria != null
        )
    }

    override fun create(): InfoInterface {
        val check_titular: Boolean = this.is_titular(this.info)
        val check_adjunto: Boolean = this.is_adjunto(this.info)
        if(check_titular && !check_adjunto){
            this.data = this.info
        } else if(!check_titular && check_adjunto) {
            this.data = this.info
        } else if(!check_titular && !check_adjunto) {
            throw DadosInvalidos()
        } else {
            throw ErroInesperado()
        }
        return this
    }
}