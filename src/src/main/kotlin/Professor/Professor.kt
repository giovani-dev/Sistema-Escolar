package Professor
import Base.InfoInterface
import Utils.DadosInvalidos
import Utils.ErroInesperado
import Base.Pessoa

class Professor : Pessoa {
    override var codigo: Int?
    override var nome: String?
    override var sobrenome: String?
    var tempo_casa: String
    var is_titular: Boolean
    var is_adjunto: Boolean
    var especialidade: String
    var horas_monitoria: Int

    constructor(
        codigo: Int,
        nome: String,
        sobrenome: String,
        tempo_casa: String,
        is_titular: Boolean,
        is_adjunto: Boolean,
        especialidade: String,
        horas_monitoria: Int
    ) {
        this.codigo = codigo
        this.nome = nome
        this.sobrenome = sobrenome
        this.tempo_casa = tempo_casa
        this.is_titular = is_titular
        this.is_adjunto = is_adjunto
        this.especialidade = especialidade
        this.horas_monitoria = horas_monitoria
    }

    private fun validate_is_titular(): Boolean {
        return (
            this.is_titular &&
            !this.is_adjunto &&
            this.especialidade != null &&
            this.horas_monitoria == null
        )
    }

    private fun validate_is_adjunto(): Boolean {
        return (
            !this.is_titular &&
            this.is_adjunto &&
            this.especialidade == null &&
            this.horas_monitoria != null
        )
    }

    override fun create(): InfoInterface {
        val check_is_titular: Boolean = this.validate_is_titular()
        val check_is_adjunto: Boolean = this.validate_is_adjunto()
        if(check_is_titular && !check_is_adjunto || !check_is_titular && check_is_adjunto){
            return this
        } else if(!check_is_titular && !check_is_adjunto) {
            throw DadosInvalidos()
        } else {
            throw ErroInesperado()
        }
        return this
    }
}