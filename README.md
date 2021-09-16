# Backend-Java
 
## Descrição da API
Essa API foi desenvolvida para coletar informações de todo país, organizá-las e prover informações com base nelas.

## Funcionalidades e Relatórios
* **v1/api/hospital**

  Método Post para adicionar hospitais.

* **v1/api/hospital/{cnpj}**

  Método Patch para atualizar o percentual de ocupação de um hospital.

* **v1/api/hospital/porcentagemMaior90**

  Método Get para receber a porcentagem de hospitais em super lotação (ocupação maior que 90%).
  
* **v1/api/hospital/porcentagemMenor90**

  Método Get para receber a porcentagem de hospitais abaixo de super lotação.
  
* **v1/api/hospital/recursoshospitais**

  Método Get para receber uma média de cada tipo de recurso por hospital (ex: 10 médicos por hospital).
  
* **v1/api/intercambio**

  Método Post para realizar uma negociação de recursos entre hospitais cadastrados.
  
* **v1/api/intercambio/historico**

  Método Get para receber uma lista com todas as negociações que foram feitas.
  
  
  
Link para importar uma coleção com os métodos acima no Postman: https://www.getpostman.com/collections/1f817c68a50890d0015a
