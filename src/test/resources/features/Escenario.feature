Feature: Escenario de Prueba

  Background:
    Given usuario se encuentra en la pagina de inicio

  @Regresiva @LoginExitoso
  Scenario: 001 - Usuario inicia Sesion con credenciales validas
    When ingreso las credenciales validas
    Then valido que se logeo correctamente

  @Regresiva @LoginFallido
  Scenario: 002 - Usuario inicia Sesion con credenciales invalidas
    When ingreso las credenciales invalidas
    Then valido que el usuario no se pudo logear correctamente

  @Regresiva @AgregarProductos
  Scenario: 003 - Usuario agrega producto al carrito
    When agrega productos al carrito
    Then el carrito debe mostrar los productos correctamente

  @Regresiva @FiltrarProductosAtoZ
  Scenario: 004 - Usuario ordena productos A to Z
    When escoge la opcion de filtrar producto alfabeticamente A to Z
    Then se valida que se filtro correctamente A to Z

  @Regresiva @FiltrarProductosZtoA
  Scenario: 005 - Usuario ordena productos Z to A
    When escoge la opcion de filtrar producto alfabeticamente Z to A
    Then se valida que se filtro correctamente Z to A

  @Regresiva @FiltrarProductosLowToHigh
  Scenario: 006 - Usuario ordena productos low to high
    When escoge la opcion de filtrar producto por precio Low To High
    Then se valida que se filtro correctamente Low To High

  @Regresiva @FiltrarProductosHighToLow
  Scenario: 007 - Usuario ordena productos high to low
    When escoge la opcion de filtrar producto alfabeticamente High To Low
    Then se valida que se filtro correctamente High To Low

  @Regresiva @CompraProductos
  Scenario: 008 - Usuario realiza una compra exitosa
    And completa los datos del formulario
    Then finaliza la compra
    And valida que se completo correctamente

