package Curso
import Base.InfoDataClass

data class InfoCurso(
    override var nome: String,
    override var codigo: Int
): InfoDataClass