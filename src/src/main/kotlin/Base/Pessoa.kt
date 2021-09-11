package Base

abstract class Pessoa : InfoInterface {
    abstract override var nome: String?
    abstract override var codigo: Int?
    abstract var sobrenome: String?

    override fun equals(other: Any?): Boolean {
        if(other is InfoInterface){
            return other.codigo == this.codigo
        } else {
            return other == this.codigo
        }
    }
}