package com.tictactoe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class VictoryTest {

    /** Requerimiento: si no hay línea completa, no hay victoria */
    @Test
    void noHayVictoriaEnTableroVacioNiParcial() {
        Board tablero = new Board();
        // coloca algunas fichas desordenadas, pero sin completar línea
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 1, 'O');
        tablero.colocarFicha(2, 2, 'X');
        assertFalse(tablero.hayVictoria('X'), "No debería haber victoria para X");
        assertFalse(tablero.hayVictoria('O'), "No debería haber victoria para O");
    }

    /** REQUERIMIENTO 2: línea horizontal completa => victoria */
    @Test
    void victoriaHorizontal() {
        Board tablero = new Board();
        tablero.colocarFicha(1, 0, 'X');
        tablero.colocarFicha(1, 1, 'X');
        tablero.colocarFicha(1, 2, 'X');
        assertTrue(tablero.hayVictoria('X'), "X debe ganar con fila 1 completa");
        assertFalse(tablero.hayVictoria('O'), "O no debe ganar");
    }
    /** REQUERIMIENTO 3: línea vertical completa => victoria */
    @Test
    void victoriaVertical() {
        Board tablero = new Board();
        tablero.colocarFicha(0, 2, 'O');
        tablero.colocarFicha(1, 2, 'O');
        tablero.colocarFicha(2, 2, 'O');
        assertTrue(tablero.hayVictoria('O'), "O debe ganar con columna 2 completa");
        assertFalse(tablero.hayVictoria('X'), "X no debe ganar");
    }
    /** GREEN REQUERIMIENTO 4: línea diagonal completa => victoria */
    @Test
    void victoriaDiagonal() {
        Board tablero = new Board();
        // diagonal principal
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 1, 'X');
        tablero.colocarFicha(2, 2, 'X');
        assertTrue(tablero.hayVictoria('X'), "X debe ganar en diagonal principal");

        // diagonal secundaria
        Board t2 = new Board();
        t2.colocarFicha(0, 2, 'O');
        t2.colocarFicha(1, 1, 'O');
        t2.colocarFicha(2, 0, 'O');
        assertTrue(t2.hayVictoria('O'), "O debe ganar en diagonal secundaria");
    }
    /** REQUERIMIENTO 1: test de empate usando un nuevo método hayEmpate() que aún no existe */
    @Test
    void debeDetectarEmpateConNuevoMetodo() {
        Board tablero = new Board();
        // llenamos todo el tablero sin dar victoria a nadie:
        char[] secuencia = {
            'X','O','X',
            'X','O','X',
            'O','X','O'
        };
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero.colocarFicha(i, j, secuencia[idx++]);
            }
        }

        // Ahora esperamos que exista un método hayEmpate()
        assertTrue(tablero.hayEmpate(),
            "Cuando está lleno y no hay victoria debe devolver empate");
    }
}
