package Manager
import Base.InfoInterface
import Matricula.Matricula

class DigitalHouseManager {
    lateinit var alunos: MutableList<InfoInterface>
    lateinit var professores: MutableList<InfoInterface>
    lateinit var cursos: MutableList<InfoInterface>
    lateinit var matriculas: MutableList<Matricula>
}