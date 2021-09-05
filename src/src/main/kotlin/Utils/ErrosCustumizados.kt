package Utils

class DadosInvalidos(
    message: String = "Dados Invalidos, tente novamente!"
) : Exception(message)

class ErroInesperado(
    message: String = "Ocorreu um erro inesperado, consulte o administrador de sistemas!"
) : Exception(message)