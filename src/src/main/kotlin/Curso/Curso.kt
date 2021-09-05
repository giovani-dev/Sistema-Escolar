package Curso
import Base.InfoInterface
import Base.InfoDataClass


class Curso: InfoInterface {
    lateinit override var info: InfoDataClass

    constructor(nome: String, codigo: Int) {
        this.info = InfoCurso(nome, codigo)
    }

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (other.info.codigo == this.info.codigo)
    }
}