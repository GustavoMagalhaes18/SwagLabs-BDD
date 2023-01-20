# language: pt

  @Acesso
  Funcionalidade: Acessar o site SwagLabs
    Cenario: Fluxo Principal, Fluxo Alternativo e Fluxo de Bloqueio

      Esquema do Cenario:
        Dado que o usuario esta na tela inicial do SwagLabs
        Quando ele preenche com dados validos os campos <username> e <password>
        E clica no botao LOGIN
        Entao o usuario deve ter acesso ao site da SwagLabs

        Exemplos:
        | username                                        | password                            |
        | "standard_user"                                 | "secret_sauce"                      |
        | "locked_out_user"                               | "secret_sauce"                      |
        | "problem_user"                                  | "secret_sauce"                      |
        | "performance_glitch_user"                       | "secret_sauce"                      |