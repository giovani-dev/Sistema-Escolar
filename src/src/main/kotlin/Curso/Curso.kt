package Curso
import Base.InformacaoDaEntidade
import Base.Objeto


abstract class Curso: Objeto {
    override var nome: String?
    override var codigo: Int?
    var professor_titular: InformacaoDaEntidade?
    var professor_adjunto: InformacaoDaEntidade?
    var qtde_maxima_de_alunos: Int?
    var alunos_matriculados: List<InformacaoDaEntidade>?


    constructor(
        nome: String?,
        codigo: Int?,
        professor_titular: InformacaoDaEntidade?,
        professor_adjunto: InformacaoDaEntidade?,
        qtde_maxima_de_alunos: Int?,
        alunos_matriculados: List<InformacaoDaEntidade>?
    ) {
        this.nome = nome
        this.codigo = codigo
        this.professor_titular = professor_titular
        this.professor_adjunto = professor_adjunto
        this.qtde_maxima_de_alunos = qtde_maxima_de_alunos
        this.alunos_matriculados = alunos_matriculados
    }

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (other.codigo == this.codigo)
    }

    abstract override fun create(): InformacaoDaEntidade
}