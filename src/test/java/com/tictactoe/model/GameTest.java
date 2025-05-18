package com.tictactoe.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
