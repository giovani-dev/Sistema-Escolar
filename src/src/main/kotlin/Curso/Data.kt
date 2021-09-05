package Curso
import Base.InfoDataClass
import Professor.InfoProfessor
import Aluno.InfoAluno

data class InfoCurso(
    override var nome: String,
    override var codigo: Int,
    var professor_titular: InfoProfessor,
    var professor_adjunto: InfoProfessor,
    var qtde_maxima_de_alunos: Int,
    var alunos_matriculados: List<InfoAluno>
): InfoDataClass