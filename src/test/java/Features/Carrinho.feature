# language: pt

  @Carrinho
  Funcionalidade: Carrinho do Site SwagLabs
    Cenario: Fluxo Valido

      Esquema do Cenario:
        Dado que o usuario tem acesso ao site da SwagLabs e adiciona um <produto> ao carrinho
        Quando ele clica no bota Carrinho para ser redirecionado a tela de CheckOut
        E clica no botao FINISH apos preencher os campos FirstName, LastName e ZipPostalCode com dados validos
        Entao a compra do usuario deve ser efetuada com sucesso

        Exemplos:
        | produto                                            |
        | "add-to-cart-sauce-labs-backpack"                  |