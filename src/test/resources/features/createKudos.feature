@Kudos
Feature: Envio de reconocimientos entre compañeros
  Como empleado de Sofka
  Quiero enviar un reconocimiento (Kudo) a un compañero
  Para fortalecer la cultura de equipo

  Scenario Outline: Envio exitoso de Kudo seleccionando colaborador por nombre
    Given que el empleado se encuentra en la pantalla de "Envío de Kudos"
    When el empleado selecciona como remitente a "<nombre_remitente>"
    And busca y selecciona al destinatario "<nombre_destinatario>"
    And elige la categoría de reconocimiento "<categoria>"
    And escribe un mensaje de agradecimiento: "<mensaje>"
    And desliza el control de confirmación hasta el final
    Then el sistema debe mostrar una notificación de envío exitoso
    And los campos del formulario deben quedar vacíos para un nuevo registro

    Examples:
      | nombre_remitente | nombre_destinatario | categoria  | mensaje                                               |
      | Christopher Pallo| Santiago   | Innovation | Gran iniciativa con el nuevo diseño del dashboard.    |
      | Santiago  | Christopher Pallo   | Teamwork   | Gracias por el apoyo técnico en la sesión de hoy.     |
      | Backend Team       | Frontend Team           | Passion    | Excelente ejecución de los casos de prueba de carga.  |
