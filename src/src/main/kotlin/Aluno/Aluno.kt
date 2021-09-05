package Aluno
import Base.DataToClass

class Aluno: DataToClass {
    lateinit override var info: Any

    constructor(nome: String, sobrenome: String, codigo: Int) {
        this.info = InfoAluno(nome, sobrenome, codigo)
    }

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (other.info == this.info)
    }
}