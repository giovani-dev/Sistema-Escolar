package Base


interface InfoDataClass {
    var nome: String
    var codigo: Int
}

interface InfoInterface {
    var info: InfoDataClass

    override fun equals(other: Any?): Boolean
}