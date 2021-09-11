package Curso
import Base.InfoInterface
import Base.Objeto


class Curso: Objeto {
    override var nome: String?
    override var codigo: Int?
    var professor_titular: InfoInterface?
    var professor_adjunto: InfoInterface?
    var qtde_maxima_de_alunos: Int?
    var alunos_matriculados: MutableList<InfoInterface>? = mutableListOf<InfoInterface>()


    constructor(
        nome: String?,
        codigo: Int?,
        professor_titular: InfoInterface?,
        professor_adjunto: InfoInterface?,
        qtde_maxima_de_alunos: Int,
    ) {
        this.nome = nome
        this.codigo = codigo
        this.professor_titular = professor_titular
        this.professor_adjunto = professor_adjunto
        this.qtde_maxima_de_alunos = qtde_maxima_de_alunos
    }

    fun adicionarUmAluno(umAluno: InfoInterface): Boolean {
        if(this.alunos_matriculados!!.size <= this.qtde_maxima_de_alunos!!) {
            this.alunos_matriculados!!.add(umAluno)
        } else {
            return false
        }
        return true
    }

    fun excluirAluno(umAluno: InfoInterface): Boolean {
        for(aluno_position in this.alunos_matriculados!!.indices) {
            if(this.alunos_matriculados!![aluno_position] == umAluno){
                this.alunos_matriculados!!.removeAt(aluno_position)
                return true
            }
        }
        return false
    }
}