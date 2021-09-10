package Base

abstract class Objeto : InfoInterface {
    abstract override var nome: String?
    abstract override var codigo: Int?

    abstract override fun create(): InfoInterface
    override fun equals(other: Any?): Boolean = (other is InfoInterface) && (other.codigo == this.codigo)
}