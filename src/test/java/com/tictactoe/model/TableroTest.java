package com.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Tablero siguiendo metodología TDD
 * 
 * Este archivo sirve como ejemplo de cómo implementar pruebas unitarias
 * siguiendo el enfoque de Test-Driven Development (TDD).
 */
public class TableroTest {

    // Esta clase de prueba es un ejemplo de cómo implementar TDD
    // Primero se escriben las pruebas y luego se implementa la funcionalidad

    /**
     * Prueba que verifica que un tablero recién creado esté vacío
     * 
     * Esta prueba fallará inicialmente hasta que se implemente la clase Tablero
     * con la funcionalidad requerida.
     */
    @Test
    public void tableroNuevoDebeEstarVacio() {
        // Esta prueba fallará hasta que se implemente la clase Tablero
        // Siguiendo TDD, primero escribimos la prueba y luego implementamos la clase

        // Ejemplo de cómo sería la prueba una vez implementada la clase Tablero:
        // Tablero tablero = new Tablero();
        // for (int fila = 0; fila < 3; fila++) {
        // for (int columna = 0; columna < 3; columna++) {
        // assertNull(tablero.obtenerCasilla(fila, columna));
        // }
        // }

        // Por ahora, esta prueba está comentada ya que la clase Tablero aún no existe
        // Este es el primer paso del ciclo TDD: escribir una prueba que falle
    }

    /**
     * Ejemplo de otra prueba que verificaría que se puede colocar una ficha en el
     * tablero
     */
    @Test
    public void debePoderColocarFichaEnCasillaVacia() {
        // Ejemplo de cómo sería la prueba una vez implementada la clase Tablero:
        // Tablero tablero = new Tablero();
        // tablero.colocarFicha(0, 0, 'X');
        // assertEquals('X', tablero.obtenerCasilla(0, 0));

        // Esta prueba también está comentada ya que la clase Tablero aún no existe
        // Siguiendo TDD, implementaremos la clase Tablero para que estas pruebas pasen
    }

    // Más pruebas se agregarán siguiendo el enfoque TDD
    // 1. Escribir una prueba que falle
    // 2. Implementar el código mínimo para que la prueba pase
    // 3. Refactorizar el código manteniendo las pruebas en verde
}