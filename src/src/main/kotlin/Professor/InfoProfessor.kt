package Professor
import Base.InfoDataClass

data class InfoProfessor(
    override var codigo: Int,
    override var nome: String,
    var sobrenome: String,
    var tempo_casa: String
) : InfoDataClass
