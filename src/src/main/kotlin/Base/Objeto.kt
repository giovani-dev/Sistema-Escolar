package Base

abstract class Objeto : InformacaoDaEntidade {
    abstract override var nome: String?
    abstract override var codigo: Int?

    abstract override fun create(): InformacaoDaEntidade
    override fun equals(other: Any?): Boolean = (other is InformacaoDaEntidade) && (other.codigo == this.codigo)
}