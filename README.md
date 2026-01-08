CONTROLE DE PATRIMÔNIO – NERDS

API REST desenvolvida em Java com Spring Boot para o módulo de Controle de Patrimônio do NERDS.
O sistema permite o gerenciamento de equipamentos, garantindo que não existam dois equipamentos
com o mesmo número de série.

--------------------------------------------------
TECNOLOGIAS UTILIZADAS
--------------------------------------------------
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven

--------------------------------------------------
ESTRUTURA DO PROJETO
--------------------------------------------------
br.com.nerds.patrimonio
├── controller
│   └── EquipamentoController.java
├── service
│   └── EquipamentoService.java
├── repository
│   └── EquipamentoRepository.java
├── model
│   └── Equipamento.java
├── exception
│   └── EquipamentoNaoEncontradoException.java
│   └── NumeroSerieDuplicadoException.java
│   └── ApiExceptionHandler.java
└── PatrimonioApplication.java

--------------------------------------------------
MODELO DE DADOS – EQUIPAMENTO
--------------------------------------------------
Campos:
- numeroSerie (String) → Identificador único (chave primária)
- nome (String)
- tipo (String)

Observação:
O número de série não pode ser alterado após o cadastro.

--------------------------------------------------
ENDPOINTS DISPONÍVEIS
--------------------------------------------------

1) PARA CADASTRAR EQUIPAMENTO
POST /equipamentos

Body (JSON):
{
  "numeroSerie": "NERDS-001",
  "nome": "Roteador",
  "tipo": "Wi-Fi"
}

--------------------------------------------------

2) PARA MOSTRAR TODOS OS EQUIPAMENTOS
GET /equipamentos

--------------------------------------------------

3) PARA BUSCAR POR NÚMERO DE SÉRIE
GET /equipamentos/numero-de-serie/{numeroSerie}

Exemplo:
GET /equipamentos/numero-de-serie/NERDS-001

--------------------------------------------------

4) ATUALIZAR EQUIPAMENTO (POR NÚMERO DE SÉRIE)
PUT /equipamentos/numero-de-serie/{numeroSerie}

Body (JSON):
{
  "nome": "Roteador Principal",
  "tipo": "Wi-Fi 6"
}

Observação:
O campo numeroSerie não é alterável.

--------------------------------------------------

5) PARA EXCLUIR EQUIPAMENTO (POR NÚMERO DE SÉRIE)
DELETE /equipamentos/numero-de-serie/{numeroSerie}

Resposta:
{
  "mensagem": "Equipamento com número de série NERDS-001 removido com sucesso"
}

--------------------------------------------------
REGRAS DE NEGÓCIO
--------------------------------------------------
- Não é permitido cadastrar dois equipamentos com o mesmo número de série.
- Caso um equipamento não seja encontrado, a API retorna um erro.
- O número de série é o identificador principal do equipamento.

--------------------------------------------------
COMO EXECUTAR O PROJETO
--------------------------------------------------
Pré-requisitos:
- Java 17 ou superior
- Maven

Passos:
1) Clonar o repositório
2) Acessar a pasta do projeto
3) executar em uma IDE com suporte a Java (VSCODE foi a IDE utilizada por mim) 

Em http://localhost:8080

--------------------------------------------------
TESTES
--------------------------------------------------
Os endpoints testados no Postman.
