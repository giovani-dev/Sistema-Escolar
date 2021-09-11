package Base

abstract class Objeto : InfoInterface {
    abstract override var nome: String?
    abstract override var codigo: Int?

    override fun equals(other: Any?): Boolean {
        if(other is InfoInterface){
            return other.codigo == this.codigo
        } else {
            return other == this.codigo
        }
    }
}