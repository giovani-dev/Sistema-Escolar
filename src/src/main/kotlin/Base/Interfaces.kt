package Base

interface InformacaoDaEntidade {
    var nome: String?
    var codigo: Int?

    override fun equals(other: Any?): Boolean
    fun create(): InformacaoDaEntidade
}