package Base


interface InfoDataClass {
    var nome: String
    var codigo: Int
}

interface InfoInterface {
    var info: InfoDataClass
    var data: InfoDataClass

    override fun equals(other: Any?): Boolean
    fun create(): InfoInterface
}