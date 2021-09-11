package Manager
import Aluno.Aluno
import Matricula.Matricula
import Curso.Curso
import Utils.ImpossivelDeletar
import Utils.excluirObjectInList
import Utils.validateObjectCode
import Utils.procurarObjectInList
import Utils.substituirObjectInList
import Professor.Professor

class DigitalHouseManager {
    var alunos: MutableList<Aluno> = mutableListOf<Aluno>()
    var professores: MutableList<Professor> = mutableListOf<Professor>()
    var matriculas: MutableList<Matricula> = mutableListOf<Matricula>()
    var cursos: MutableList<Curso> = mutableListOf<Curso>()

    fun registrarCurso(
        nome: String,
        codigoCurso: Int,
        quantidadeMaximaDeAlunos: Int
    ): DigitalHouseManager {
        this.cursos.add(
            validateObjectCode<Curso>(
                obj = Curso(
                    nome = nome,
                    codigo = codigoCurso,
                    professor_titular = null,
                    professor_adjunto = null,
                    qtde_maxima_de_alunos = quantidadeMaximaDeAlunos
                ),
                dataList = this.cursos
            )
        )
        return this
    }

    fun excluirCurso(codigoCurso: Int): Boolean {
        try {
            this.cursos = excluirObjectInList<Curso>(
                codigo = codigoCurso,
                dataList = this.cursos
            )
            return true
        } catch (error: ImpossivelDeletar) {
            return false
        }
    }

    fun excluirProfessor(codigoCurso: Int): Boolean {
        try {
            this.professores = excluirObjectInList<Professor>(
                codigo = codigoCurso,
                dataList = this.professores
            )
            return true
        } catch (error: ImpossivelDeletar) {
            return false
        }
    }

    fun registrarProfessorAdjunto(
        nome: String,
        sobrenome: String,
        codigoProfessor: Int,
        quantidadeDeHoras: Int
    ) {
        this.professores.add(
            validateObjectCode<Professor>(
                obj = Professor(
                    codigo = codigoProfessor,
                    nome = nome,
                    sobrenome = sobrenome,
                    tempo_casa = 0,
                    is_titular = false,
                    is_adjunto = true,
                    especialidade = null,
                    horas_monitoria = quantidadeDeHoras,
                ),
                dataList = this.professores
            )
        )
    }

    fun registrarProfessorTitular(
        nome: String,
        sobrenome: String,
        codigoProfessor: Int,
        especialidade: String
    ) {
        this.professores.add(
            validateObjectCode<Professor>(
                obj = Professor(
                    codigo = codigoProfessor,
                    nome = nome,
                    sobrenome = sobrenome,
                    tempo_casa = 0,
                    is_titular = true,
                    is_adjunto = false,
                    especialidade = especialidade,
                    horas_monitoria = 0,
                ),
                dataList = this.professores
            )
        )
    }

    fun matricularAluno(
        nome: String,
        sobrenome: String,
        codigoAluno: Int
    ) {
        this.alunos.add(
            validateObjectCode<Aluno>(
                obj = Aluno(
                    nome = nome,
                    sobrenome = sobrenome,
                    codigo = codigoAluno
                ),
                dataList = this.alunos
            )
        )
    }

    fun matricularAlunoEmCurso(
        codigoAluno: Int,
        codigoCurso: Int
    ) {
        val aluno: Aluno = procurarObjectInList<Aluno>(
            codigo = codigoAluno,
            dataList = this.alunos
        )
        val curso: Curso = procurarObjectInList<Curso>(
            codigo = codigoCurso,
            dataList = this.cursos
        )
        if(curso.adicionarUmAluno(umAluno = aluno)){
            this.matriculas.add(
                validateObjectCode<Matricula>(
                    obj = Matricula(
                        aluno = aluno,
                        curso = curso
                    ),
                    dataList = this.matriculas
                )
            )
            this.cursos = substituirObjectInList<Curso>(
                obj = curso,
                codigo = codigoCurso,
                dataList = this.cursos
            )
        } else {
            println("""
                Nao foi Possivel matricular o aluno ${aluno.nome} ${aluno.sobrenome}
                Razao: Limite Maximo de alunos em matriculados curso atingido
                Limite maximo de alunos: ${curso.qtde_maxima_de_alunos}
            """.trimIndent())
        }
        this.matriculas.add(
            Matricula(
                aluno = aluno,
                curso = curso
            )
        )
    }

    fun alocarProfessores(
        codigoCurso: Int,
        codigoProfessorTitular: Int,
        codigoProfessorAdjunto: Int
    ) {
        val curso = procurarObjectInList<Curso>(
            codigo = codigoCurso,
            dataList = this.cursos
        )
        val professor_adjunto: Professor = procurarObjectInList<Professor>(
            codigo = codigoProfessorAdjunto,
            dataList = this.professores
        )
        val professor_titular: Professor = procurarObjectInList<Professor>(
            codigo = codigoProfessorTitular,
            dataList = this.professores
        )
        curso.professor_adjunto = professor_adjunto
        curso.professor_titular = professor_titular
        this.cursos = substituirObjectInList<Curso>(
            obj = curso,
            codigo = codigoCurso,
            dataList = this.cursos
        )
    }
}