package Aluno
import Base.InfoInterface
import Base.InfoDataClass

class Aluno: InfoInterface {
    lateinit override var info: InfoDataClass

    constructor(nome: String, sobrenome: String, codigo: Int) {
        this.info = InfoAluno(nome, sobrenome, codigo)
    }

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (other.info == this.info)
    }
}