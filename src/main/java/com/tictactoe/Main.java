package com.tictactoe;

import java.util.Scanner;

import com.tictactoe.controller.Game;
import com.tictactoe.model.Board;
import com.tictactoe.model.Player;
import com.tictactoe.model.ConsolePlayer;
/**
 * Clase principal que inicia el juego de Tres en Raya
 */
public class Main {

    /**
     * Método principal que inicia la aplicación
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al juego de Tres en Raya!!!! Prueba\n");
        System.out.println("Próximamente estará disponible la versión completa.");

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Player p1 = new ConsolePlayer('X', sc);
        Player p2 = new ConsolePlayer('O', sc);
        Game game = new Game(board, p1, p2);

        while (!game.isOver()) {
            System.out.println(board);        // imprime estado
            game.step();
        }
        System.out.println(board);
        char result = game.getResult();
        if (result == ' ') {
            System.out.println("¡Empate!");
        } else {
            System.out.printf("¡Gana %c!%n", result);
        }
        sc.close();
    }
}