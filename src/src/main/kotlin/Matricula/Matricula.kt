package Matricula
import Base.InformacaoDaEntidade
import java.util.*

class Matricula(
    var aluno: InformacaoDaEntidade,
    var curso: InformacaoDaEntidade
) {
    private var data: Date = Date()
}