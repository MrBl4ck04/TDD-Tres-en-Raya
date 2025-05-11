# Ejemplos de Pruebas Unitarias para TDD

Este documento proporciona ejemplos prácticos de cómo implementar pruebas unitarias siguiendo la metodología TDD para el proyecto de Tres en Raya.

## Ejemplo 1: Tablero

### Paso 1: Escribir la prueba (Red)

```java
@Test
public void tableroNuevoDebeEstarVacio() {
    Tablero tablero = new Tablero();
    for (int fila = 0; fila < 3; fila++) {
        for (int columna = 0; columna < 3; columna++) {
            assertNull(tablero.obtenerCasilla(fila, columna));
        }
    }
}
```

### Paso 2: Implementar el código mínimo (Green)

```java
public class Tablero {
    private Character[][] casillas;

    public Tablero() {
        casillas = new Character[3][3];
    }

    public Character obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }
}
```

### Paso 3: Refactorizar

```java
public class Tablero {
    private final int TAMANIO = 3;
    private Character[][] casillas;

    public Tablero() {
        casillas = new Character[TAMANIO][TAMANIO];
    }

    public Character obtenerCasilla(int fila, int columna) {
        validarCoordenadas(fila, columna);
        return casillas[fila][columna];
    }

    private void validarCoordenadas(int fila, int columna) {
        if (fila < 0 || fila >= TAMANIO || columna < 0 || columna >= TAMANIO) {
            throw new IllegalArgumentException("Coordenadas fuera del tablero");
        }
    }
}
```

## Ejemplo 2: Colocar Ficha

### Paso 1: Escribir la prueba (Red)

```java
@Test
public void debePoderColocarFichaEnCasillaVacia() {
    Tablero tablero = new Tablero();
    tablero.colocarFicha(0, 0, 'X');
    assertEquals('X', tablero.obtenerCasilla(0, 0));
}

@Test
public void noDebePoderColocarFichaEnCasillaOcupada() {
    Tablero tablero = new Tablero();
    tablero.colocarFicha(0, 0, 'X');

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        tablero.colocarFicha(0, 0, 'O');
    });

    assertTrue(exception.getMessage().contains("ocupada"));
}
```

### Paso 2: Implementar el código mínimo (Green)

```java
public void colocarFicha(int fila, int columna, char ficha) {
    validarCoordenadas(fila, columna);

    if (casillas[fila][columna] != null) {
        throw new IllegalArgumentException("La casilla ya está ocupada");
    }

    casillas[fila][columna] = ficha;
}
```

## Ejemplo 3: Verificar Victoria

### Paso 1: Escribir la prueba (Red)

```java
@Test
public void debeDetectarVictoriaEnFila() {
    Tablero tablero = new Tablero();
    tablero.colocarFicha(0, 0, 'X');
    tablero.colocarFicha(0, 1, 'X');
    tablero.colocarFicha(0, 2, 'X');

    assertTrue(tablero.hayVictoria('X'));
    assertFalse(tablero.hayVictoria('O'));
}

@Test
public void debeDetectarVictoriaEnColumna() {
    Tablero tablero = new Tablero();
    tablero.colocarFicha(0, 0, 'O');
    tablero.colocarFicha(1, 0, 'O');
    tablero.colocarFicha(2, 0, 'O');

    assertTrue(tablero.hayVictoria('O'));
    assertFalse(tablero.hayVictoria('X'));
}

@Test
public void debeDetectarVictoriaEnDiagonal() {
    Tablero tablero = new Tablero();
    tablero.colocarFicha(0, 0, 'X');
    tablero.colocarFicha(1, 1, 'X');
    tablero.colocarFicha(2, 2, 'X');

    assertTrue(tablero.hayVictoria('X'));
}
```

### Paso 2: Implementar el código mínimo (Green)

```java
public boolean hayVictoria(char ficha) {
    // Verificar filas
    for (int i = 0; i < TAMANIO; i++) {
        if (casillas[i][0] != null && casillas[i][0] == ficha &&
            casillas[i][1] != null && casillas[i][1] == ficha &&
            casillas[i][2] != null && casillas[i][2] == ficha) {
            return true;
        }
    }

    // Verificar columnas
    for (int j = 0; j < TAMANIO; j++) {
        if (casillas[0][j] != null && casillas[0][j] == ficha &&
            casillas[1][j] != null && casillas[1][j] == ficha &&
            casillas[2][j] != null && casillas[2][j] == ficha) {
            return true;
        }
    }

    // Verificar diagonal principal
    if (casillas[0][0] != null && casillas[0][0] == ficha &&
        casillas[1][1] != null && casillas[1][1] == ficha &&
        casillas[2][2] != null && casillas[2][2] == ficha) {
        return true;
    }

    // Verificar diagonal secundaria
    if (casillas[0][2] != null && casillas[0][2] == ficha &&
        casillas[1][1] != null && casillas[1][1] == ficha &&
        casillas[2][0] != null && casillas[2][0] == ficha) {
        return true;
    }

    return false;
}
```

### Paso 3: Refactorizar

```java
public boolean hayVictoria(char ficha) {
    return hayVictoriaEnFilas(ficha) ||
           hayVictoriaEnColumnas(ficha) ||
           hayVictoriaEnDiagonales(ficha);
}

private boolean hayVictoriaEnFilas(char ficha) {
    for (int i = 0; i < TAMANIO; i++) {
        if (esFichaIgual(i, 0, ficha) &&
            esFichaIgual(i, 1, ficha) &&
            esFichaIgual(i, 2, ficha)) {
            return true;
        }
    }
    return false;
}

private boolean hayVictoriaEnColumnas(char ficha) {
    for (int j = 0; j < TAMANIO; j++) {
        if (esFichaIgual(0, j, ficha) &&
            esFichaIgual(1, j, ficha) &&
            esFichaIgual(2, j, ficha)) {
            return true;
        }
    }
    return false;
}

private boolean hayVictoriaEnDiagonales(char ficha) {
    // Diagonal principal
    if (esFichaIgual(0, 0, ficha) &&
        esFichaIgual(1, 1, ficha) &&
        esFichaIgual(2, 2, ficha)) {
        return true;
    }

    // Diagonal secundaria
    if (esFichaIgual(0, 2, ficha) &&
        esFichaIgual(1, 1, ficha) &&
        esFichaIgual(2, 0, ficha)) {
        return true;
    }

    return false;
}

private boolean esFichaIgual(int fila, int columna, char ficha) {
    return casillas[fila][columna] != null && casillas[fila][columna] == ficha;
}
```

## Ejemplo 4: Verificar Empate

### Paso 1: Escribir la prueba (Red)

```java
@Test
public void debeDetectarEmpate() {
    Tablero tablero = new Tablero();
    // Llenar el tablero sin victoria
    tablero.colocarFicha(0, 0, 'X');
    tablero.colocarFicha(0, 1, 'O');
    tablero.colocarFicha(0, 2, 'X');
    tablero.colocarFicha(1, 0, 'X');
    tablero.colocarFicha(1, 1, 'O');
    tablero.colocarFicha(1, 2, 'X');
    tablero.colocarFicha(2, 0, 'O');
    tablero.colocarFicha(2, 1, 'X');
    tablero.colocarFicha(2, 2, 'O');

    assertTrue(tablero.estaLleno());
    assertFalse(tablero.hayVictoria('X'));
    assertFalse(tablero.hayVictoria('O'));
}
```

### Paso 2: Implementar el código mínimo (Green)

```java
public boolean estaLleno() {
    for (int i = 0; i < TAMANIO; i++) {
        for (int j = 0; j < TAMANIO; j++) {
            if (casillas[i][j] == null) {
                return false;
            }
        }
    }
    return true;
}
```

## Consejos para Escribir Buenas Pruebas

1. **Pruebas específicas**: Cada prueba debe verificar una sola funcionalidad
2. **Nombres descriptivos**: El nombre de la prueba debe describir lo que se está probando
3. **Estructura AAA**: Arrange (preparar), Act (actuar), Assert (verificar)
4. **Independencia**: Las pruebas no deben depender de otras pruebas
5. **Cobertura**: Asegurarse de probar casos normales y casos límite

## Flujo de Trabajo Recomendado

1. Identificar la funcionalidad más pequeña que se puede implementar
2. Escribir una prueba que verifique esa funcionalidad
3. Ejecutar la prueba y verificar que falle
4. Implementar el código mínimo para que la prueba pase
5. Ejecutar todas las pruebas y verificar que pasen
6. Refactorizar el código si es necesario
7. Repetir el proceso para la siguiente funcionalidad
