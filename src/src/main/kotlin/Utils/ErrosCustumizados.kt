package Utils

class DadosInvalidos(
    message: String = "Dados Invalidos, tente novamente!"
) : Exception(message)

class ErroInesperado(
    message: String = "Ocorreu um erro inesperado, consulte o administrador de sistemas!"
) : Exception(message)

class PropriedadeDuplicada(
    message: String = "Voce esta realizando uma operacao com dados duplicados!"
) : Exception(message)

class ImpossivelDeletar(
    message: String = "Objeto Impossivel de deletar!"
) : Exception(message)

class ImpossivelProcurar(
    message: String = "Objeto Impossivel de procurar!"
) : Exception(message)