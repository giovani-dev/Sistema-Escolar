package Aluno

class Aluno {
    lateinit var info: InfoAluno

    constructor(nome: String, sobrenome: String, codigo: Int) {
        this.info = InfoAluno(nome, sobrenome, codigo)
    }

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (other.info == this.info)
    }
}