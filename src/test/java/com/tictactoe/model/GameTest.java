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
        
        Board board = new Board();
        Player p1 = new ConsolePlayer('O', null);
        Player p2 = new ConsolePlayer('X', null);
        Game game = new Game(board, p1, p2);

        //verifica que el primer turno sea de 'X'
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

    @Test
    public void despuesDeOJuegaX() {
        // Simula entrada de usuario para X y para O
        String input = "0 1\n";//input para O
        String input2 = "0 0\n";//input para X
        Scanner scanner = new java.util.Scanner(input);
        Scanner scanner2 = new java.util.Scanner(input2);

        Board board = new Board();
        Player p1 = new ConsolePlayer('O', scanner); // O jugara un turno en (0,1)
        Player p2 = new ConsolePlayer('X', scanner2); // X jugara un turno en (0,0)
        Game game = new Game(board, p1, p2);

        // X juega su turno (usando el input simulado)
        game.step();
        // O juega su turno (usando el input simulado)
        game.step();

        // Verifica que el siguiente turno sea de X
        assertEquals('X', game.getCurrentMark(), "Después de 'O', debe jugar 'X'");
    }

}
