Descripción

Este proyecto implementa un framework de QA Automation utilizando Playwright + Cucumber + POM en Java.

Se automatizaron los siguientes escenarios:
- Inicio de sesión
- Validación de productos
- Gestión de carrito y compra en checkout

Se utilizaron las siguientes tecnologias 
- Lenguaje: Java
- Frameworks: Playwright, Cucumber
- Arquitectura: Page Object Model (POM)
- Gestión de dependencias: Maven

Comando para ejecutar las pruebas:
- mvn clean test

 Escenarios Cubiertos
- Login válido e inválido
- Ordenamiento por nombre y precio (ascendente/descendente)
- Validación de carrito y checkout

 Reportes
- Los reportes de ejecución se generan automáticamente en:
  /target/test-classes
