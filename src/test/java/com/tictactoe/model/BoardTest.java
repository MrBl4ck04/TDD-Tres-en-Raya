package com.tictactoe.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    
    @Test
    public void testPiezaFueraDeEjeX() {
        // Arrange
        Board tablero = new Board();
        char pieza = 'X';
        
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarPieza(3, 0, pieza);
        });
        
        String mensajeEsperado = "Posición X fuera del tablero";
        String mensajeActual = exception.getMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}