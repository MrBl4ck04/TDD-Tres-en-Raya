package com.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tictactoe.controller.Game;
import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
public class Req3Test {
    @Test
    public void gameDetectaVictoriaDeP1() {
        Board board = new Board();

        // Stub para P1: devolverá (0,0,'X'), luego (0,1,'X'), luego (0,2,'X')
        Player p1 = new Player() {
            private final Iterator<Move> moves = Arrays.asList(
                new Move(0, 0, 'X'),
                new Move(0, 1, 'X'),
                new Move(0, 2, 'X')
            ).iterator();
            @Override
            public Move nextMove(Board b) {
                return moves.next();
            }
            @Override
            public char getMark() {
                return 'X';
            }
        };

        // Stub para P2: movimientos dummy que no importan (nunca se usan antes de que gane P1)
        Player p2 = new Player() {
            @Override
            public Move nextMove(Board b) {
                // retorno cualquier casilla válida, no se utilizará porque el juego acaba antes
                return new Move(2, 2, 'O');
            }
            @Override
            public char getMark() {
                return 'O';
            }
        };

        Game game = new Game(board, p1, p2);

        // Alternamos turnos hasta que P1 coloque sus tres 'X'
        game.step(); // P1 -> (0,0)
        game.step(); // P2 -> (2,2)
        game.step(); // P1 -> (0,1)
        game.step(); // P2 -> (2,2)
        game.step(); // P1 -> (0,2)

        assertTrue(game.isOver(),      "El juego debería haber terminado");
        assertEquals('X', game.getResult(),
                     "Debería ganar P1 con 'X' en la fila 0");
    }

}
