package com.tictactoe.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import com.tictactoe.controller.Game;
import com.tictactoe.model.Board;
import com.tictactoe.model.ConsolePlayer;
import com.tictactoe.model.Player;

public class GameTest {

    @Test
    public void primerTurnoSiempreEsX() {
        // 1. Preparación de la prueba
        Board board = new Board();
        Player p1 = new ConsolePlayer('O', null);
        Player p2 = new ConsolePlayer('X', null);
        Game game = new Game(board, p1, p2);
        //2. Logica de la prueba

        //3. Verificación o Assert
        assertEquals('X', game.getCurrentMark(), "El primer turno debe ser de 'X'");
    }
    @Test
    public void despuesDeXJuegaO() {
        // Simula entrada de usuario para X: fila 0, columna 0
        String input = "0 0\n";
        Scanner scanner = new java.util.Scanner(input);

        Board board = new Board();
        Player p1 = new ConsolePlayer('O', scanner); // O no jugará en este turno
        Player p2 = new ConsolePlayer('X', scanner); // X jugará en (0,0)
        Game game = new Game(board, p1, p2);

        // X juega su turno (usando el input simulado)
        game.step();

        // Verifica que el siguiente turno sea de O
        assertEquals('O', game.getCurrentMark(), "Después de 'X', debe jugar 'O'");
    }

}
