@Kudos
Feature: Exploración y Visualización de Kudos (Read Model)

  Background:
    Given que el sistema SofkianOS se encuentra operativo
    And el usuario accede a la página de listado de kudos

  Scenario: Visualización de kudos en el listado
    When el empleado visualiza el listado de kudos
    Then el sistema debe mostrar kudos en la tabla

  Scenario Outline: Filtrar kudos por categoría
    When el empleado filtra la lista por la categoría "<categoria>"
    And presiona el botón de aplicar filtros
    Then el sistema debe mostrar solo kudos de la categoría "<categoria>"

    Examples:
      | categoria |
      | Innovation |
      | Passion |
      | Teamwork |
