package Curso
import Base.DataToClass

class Curso: DataToClass {
    lateinit override var info: Any

    constructor(nome: String, codigo: Int) {
        this.info = InfoCurso(nome, codigo)
    }

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (other.info == this.info)
    }
}