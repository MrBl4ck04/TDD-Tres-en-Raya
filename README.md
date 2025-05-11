# Tres en Raya con TDD

Proyecto para la materia de Gestión de Calidad utilizando Test-Driven Development (TDD).

## Descripción del Proyecto

Este proyecto consiste en la implementación de un juego de Tres en Raya (Tic-Tac-Toe) por consola utilizando el lenguaje de programación Java. El desarrollo se realizará siguiendo la metodología TDD (Test-Driven Development), donde primero se escriben las pruebas unitarias y luego se implementa la funcionalidad necesaria para que estas pruebas pasen.

## Objetivos

- Aplicar la metodología TDD en el desarrollo de software
- Implementar pruebas unitarias efectivas
- Desarrollar un juego de Tres en Raya funcional por consola
- Configurar integración continua mediante GitHub Actions

## Metodología TDD

El desarrollo seguirá el ciclo de TDD:

1. **Red**: Escribir una prueba que falle
2. **Green**: Implementar el código mínimo necesario para que la prueba pase
3. **Refactor**: Mejorar el código manteniendo la funcionalidad

## Estructura del Proyecto

El proyecto se organizará como una aplicación Maven con la siguiente estructura:

```
src/
├── main/
│   └── java/
│       └── com/
│           └── tictactoe/
│               ├── model/
│               ├── view/
│               └── controller/
└── test/
    └── java/
        └── com/
            └── tictactoe/
                ├── model/
                ├── view/
                └── controller/
```

## Plan de Trabajo

El desarrollo se dividirá entre los 3 miembros del equipo:

### Miembro 1

- Implementación del tablero y lógica básica del juego
- Pruebas unitarias para la validación del estado del tablero

### Miembro 2

- Implementación de la lógica de jugadores y turnos
- Pruebas unitarias para la validación de movimientos y turnos

### Miembro 3

- Implementación de la interfaz de consola y lógica de victoria
- Pruebas unitarias para la validación de condiciones de victoria

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior
- JUnit 5 para pruebas unitarias

## Instrucciones de Ejecución

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar pruebas
mvn test

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="com.tictactoe.Main"
```

## Equipo

- [Daniela Guzmán]
- [Jhulianna Tarqui]
- [Franz Carvajal]
