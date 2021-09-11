package Aluno
import Base.InfoInterface
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

    override fun equals(other: Any?): Boolean {
        if(other is InfoInterface){
            return other.codigo == this.codigo
        } else {
            return other == this.codigo
        }
    }
}