package Matricula
import Base.InfoInterface
import java.util.*

class Matricula(
    var aluno: InfoInterface,
    var curso: InfoInterface
) {
    private var data: Date = Date()
}