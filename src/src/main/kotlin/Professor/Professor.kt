package Professor
import Base.InfoDataClass
import Base.InfoInterface
import Curso.Curso

class Professor : InfoInterface {
    override lateinit var info: InfoDataClass

    constructor(
        nome: String,
        sobrenome: String,
        tempo_casa: String,
        codigo: Int
    ) {
        this.info = InfoProfessor(
            nome = nome,
            sobrenome = sobrenome,
            tempo_casa = tempo_casa,
            codigo = codigo
        )
    }

    override fun equals(other: Any?): Boolean {
        return (other is Professor) && (other.info.codigo == this.info.codigo)
    }
}