import Manager.DigitalHouseManager


fun main(args: Array<String>) {
    val manager = DigitalHouseManager()

    manager.registrarProfessorAdjunto(
        nome = "Heitor Ian",
        sobrenome = "da Conceição",
        codigoProfessor = 1,
        quantidadeDeHoras = 20
    )
    manager.registrarProfessorTitular(
        nome = "Milena Rafaela",
        sobrenome = "Fogaça",
        codigoProfessor = 2,
        especialidade = "Culinaria Estadunidense",
    )

    manager.registrarCurso(
        nome = "Full Stack",
        codigoCurso = 20001,
        quantidadeMaximaDeAlunos = 3
    )
    manager.registrarCurso(
        nome = "Android",
        codigoCurso = 20002,
        quantidadeMaximaDeAlunos = 2
    )

    manager.alocarProfessores(
        codigoCurso = 20001,
        codigoProfessorTitular = 2,
        codigoProfessorAdjunto = 1
    )
    manager.alocarProfessores(
        codigoCurso = 20002,
        codigoProfessorTitular = 2,
        codigoProfessorAdjunto = 1
    )

    manager.matricularAluno(
        nome = "Giovani",
        sobrenome = "Liskoski Zanini",
        codigoAluno = 1
    )
    manager.matricularAluno(
        nome = "Junior",
        sobrenome = "dos Santo",
        codigoAluno = 2
    )
    manager.matricularAluno(
        nome = "Kleber",
        sobrenome = "Moraes",
        codigoAluno = 3
    )

    manager.matricularAlunoEmCurso(
        codigoAluno = 1,
        codigoCurso = 20001,
    )
    manager.matricularAlunoEmCurso(
        codigoAluno = 2,
        codigoCurso = 20001,
    )
    manager.matricularAlunoEmCurso(
        codigoAluno = 3,
        codigoCurso = 20001,
    )

    manager.matricularAlunoEmCurso(
        codigoAluno = 1,
        codigoCurso = 20002,
    )
    manager.matricularAlunoEmCurso(
        codigoAluno = 2,
        codigoCurso = 20002,
    )
    manager.matricularAlunoEmCurso(
        codigoAluno = 3,
        codigoCurso = 20002,
    )

    println(manager.alunos)
    println(manager.professores)
    println(manager.matriculas)
    println(manager.cursos)
}