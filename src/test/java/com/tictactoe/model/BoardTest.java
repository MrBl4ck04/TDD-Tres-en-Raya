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
    
    @Test
    public void testPiezaFueraDeEjeY() {
        // Arrange
        Board tablero = new Board();
        char pieza = 'X';
        
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarPieza(0, 3, pieza);
        });
        
        String mensajeEsperado = "Posición Y fuera del tablero";
        String mensajeActual = exception.getMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
    
    @Test
    public void testPiezaEnLugarOcupado() {
        // Arrange
        Board tablero = new Board();
        char pieza1 = 'X';
        char pieza2 = 'O';
        
        // Act
        tablero.colocarPieza(1, 1, pieza1);
        
        // Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarPieza(1, 1, pieza2);
        });
        
        String mensajeEsperado = "Posición ya ocupada";
        String mensajeActual = exception.getMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}