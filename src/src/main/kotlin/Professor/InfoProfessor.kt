package Professor
import Base.InfoDataClass

data class InfoProfessor(
    override var codigo: Int,
    override var nome: String,
    var sobrenome: String,
    var tempo_casa: String,
    var is_titular: Boolean,
    var is_adjunto: Boolean,
    var especialidade: String?,
    var horas_monitoria: Int?
) : InfoDataClass
