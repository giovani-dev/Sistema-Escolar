package Aluno
import Base.InformacaoDaEntidade
import Base.Pessoa

class Aluno: Pessoa {
    override var nome: String?
    override var codigo: Int?
    override var sobrenome: String?


    constructor(nome: String, sobrenome: String, codigo: Int) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.codigo = codigo
    }

    override fun create(): InformacaoDaEntidade {
        return this
    }
}