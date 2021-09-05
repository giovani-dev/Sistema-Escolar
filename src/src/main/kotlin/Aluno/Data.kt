package Aluno
import Base.InfoDataClass

data class InfoAluno(
    override var nome: String,
    var sobrenome: String,
    override var codigo: Int
    ): InfoDataClass