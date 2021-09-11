package Professor
import Base.InfoInterface
import Utils.DadosInvalidos
import Utils.ErroInesperado
import Base.Pessoa

class Professor : Pessoa {
    override var codigo: Int?
    override var nome: String?
    override var sobrenome: String?
    var tempo_casa: Int
    var is_titular: Boolean
    var is_adjunto: Boolean
    var especialidade: String?
    var horas_monitoria: Int

    constructor(
        codigo: Int,
        nome: String,
        sobrenome: String,
        tempo_casa: Int,
        is_titular: Boolean,
        is_adjunto: Boolean,
        especialidade: String?,
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
        this.validate()
    }

    private fun validate_is_titular(): Boolean {
        return (
            this.is_titular &&
            !this.is_adjunto &&
            this.especialidade != null &&
            this.horas_monitoria == null ||
            this.horas_monitoria == 0
        )
    }

    private fun validate_is_adjunto(): Boolean {
        return (
            !this.is_titular &&
            this.is_adjunto &&
            this.especialidade == null &&
            this.horas_monitoria > 0
        )
    }

    private fun validate() {
        if(!this.validate_is_titular() && !this.validate_is_adjunto()) {
            throw DadosInvalidos()
        }
//        else {
//            throw ErroInesperado()
//        }
    }
}