@petStore
Feature: PetStore API
  Background:
    Given la url "https://petstore.swagger.io/v2/store/order"
  @crearOrden
  Scenario Outline: Creacion de Orden
    When creo la orden con id "<id>", petId "<petId>", quantity "<quantity>", shipdate "<shipdate>", status "<status>", complete "<complete>"
    Then valido que el codigo de respuesta sea "200"
    And valido que la orden tenga el id "<id>"
    And valido que la orden tenga el petId "<petId>"
    And valido que la orden tenga la cantidad "<quantity>"
    And valido que la orden tenga el status "<status>"
    And valido que la orden tenga complete "<complete>"
    Examples:
      | id | petId | quantity | shipdate                 | status | complete |
      | 2  | 1     | 1        | 2024-12-17T11:00:00.0000 | placed | false    |
      | 4  | 2     | 2        | 2024-12-17T12:00:00.0000 | placed | true     |
      | 6  | 3     | 3        | 2024-12-17T13:00:00.0000 | placed | false    |
      | 8  | 4     | 4        | 2024-12-17T14:00:00.0000 | placed | true     |
      | 10 | 5     | 0        | 2024-12-17T15:00:00.0000 | placed | false    |
      | 12 | 6     | 1        | 2024-12-17T16:00:00.0000 | placed | true     |
      | 14 | 7     | 2        | 2024-12-17T17:00:00.0000 | placed | false    |
      | 16 | 8     | 3        | 2024-12-17T18:00:00.0000 | placed | true     |
      | 18 | 9     | 4        | 2024-12-17T19:00:00.0000 | placed | false    |
      | 20 | 10    | 0        | 2024-12-17T20:00:00.0000 | placed | true     |
      | 22 | 11    | 1        | 2024-12-17T21:00:00.0000 | placed | false    |
      | 24 | 12    | 2        | 2024-12-17T22:00:00.0000 | placed | true     |
      | 26 | 13    | 3        | 2024-12-17T23:00:00.0000 | placed | false    |
      | 28 | 14    | 4        | 2024-12-18T10:00:00.0000 | placed | true     |
      | 30 | 15    | 0        | 2024-12-18T11:00:00.0000 | placed | false    |
      | 32 | 16    | 1        | 2024-12-18T12:00:00.0000 | placed | true     |
      | 34 | 17    | 2        | 2024-12-18T13:00:00.0000 | placed | false    |
      | 36 | 18    | 3        | 2024-12-18T14:00:00.0000 | placed | true     |
      | 38 | 19    | 4        | 2024-12-18T15:00:00.0000 | placed | false    |
      | 40 | 20    | 0        | 2024-12-18T16:00:00.0000 | placed | true     |

  @consultarOrden
  Scenario Outline: Consulta de Orden
    When consulto la orden con id "<id>"
    Then valido que el codigo de respuesta sea "200"
    And valido que la orden tenga el id "<id>"
    And valido que la orden tenga el petId "<petId>"
    And valido que la orden tenga la cantidad "<quantity>"
    Examples:
      | id | petId | quantity |
      | 2  | 1     | 1        |
      | 4  | 2     | 2        |
      | 6  | 3     | 3        |
      | 8  | 4     | 4        |
      | 10 | 5     | 0        |
      | 12 | 6     | 1        |
      | 14 | 7     | 2        |
      | 16 | 8     | 3        |
      | 18 | 9     | 4        |
      | 20 | 10    | 0        |
      | 22 | 11    | 1        |
      | 24 | 12    | 2        |
      | 26 | 13    | 3        |
      | 28 | 14    | 4        |
      | 30 | 15    | 0        |
      | 32 | 16    | 1        |
      | 34 | 17    | 2        |
      | 36 | 18    | 3        |
      | 38 | 19    | 4        |
      | 40 | 20    | 0        |