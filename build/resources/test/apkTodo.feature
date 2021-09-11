Feature: Validación del APK Todo

  Scenario: Como usuario quiero agregar tareas para verlas luego del registro

    Given Abro la aplicacion Todo
    When hago click en el boton +
    And lleno el formulario con una nueva tarea
      | title  | Taller3      |
      | notes  | TextoTaller3 |
    And hago click en el check
    Then la tarea "Taller3" apareceria creada en la lista
