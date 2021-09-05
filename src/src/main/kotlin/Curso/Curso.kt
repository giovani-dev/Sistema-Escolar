package Curso
import Aluno.InfoAluno
import Base.InfoInterface
import Base.InfoDataClass
import Professor.InfoProfessor


class Curso: InfoInterface {
    override var info: InfoDataClass
    override lateinit var data: InfoDataClass

    constructor(
        nome: String,
        codigo: Int,
        professor_titular: InfoProfessor,
        professor_adjunto: InfoProfessor,
        qtde_maxima_de_alunos: Int,
        alunos_matriculados: List<InfoAluno>
    ) {
        this.info = InfoCurso(
            nome = nome,
            codigo = codigo,
            professor_titular = professor_titular,
            professor_adjunto = professor_adjunto,
            qtde_maxima_de_alunos = qtde_maxima_de_alunos,
            alunos_matriculados = alunos_matriculados
        )
    }

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (other.info.codigo == this.info.codigo)
    }

    override fun create(): InfoInterface {
        this.data = this.info
        return this
    }

}