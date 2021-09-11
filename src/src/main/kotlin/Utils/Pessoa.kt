package Utils

inline fun <T>excluirObjectInList(
    codigo: Int,
    dataList: MutableList<T>
): MutableList<T> {
    for(aluno_position in dataList!!.indices) {
        if(dataList!![aluno_position] == codigo){
            dataList!!.removeAt(aluno_position)
            return dataList
        }
    }
    throw ImpossivelDeletar()
}

inline fun <T>procurarObjectInList(
    codigo: Int,
    dataList: MutableList<T>
): T {
    for(pessoa in dataList!!.indices) {
        if(dataList!![pessoa] == codigo){
            return dataList!![pessoa]
        }
    }
    throw ImpossivelProcurar()
}

inline fun <T>validateObjectCode(
    obj: T,
    dataList: MutableList<T>
): T {
    for(curso in dataList){
        if(obj == curso) {
            throw PropriedadeDuplicada()
        }
    }
    return obj
}

inline fun <T>substituirObjectInList(
    obj: T,
    codigo: Int,
    dataList: MutableList<T>
): MutableList<T> {
    val new_dataList = excluirObjectInList(
        codigo = codigo,
        dataList = dataList,
    )
    new_dataList.add(
        validateObjectCode<T>(
            obj = obj,
            dataList = new_dataList
        )
    )
    return new_dataList
}