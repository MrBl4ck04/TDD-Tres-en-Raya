// src/main/java/com/tictactoe/controller/Game.java
package com.tictactoe.controller;

import com.tictactoe.model.*;

public class Game {
    private final Board board;
    private final Player p1, p2;
    private Player current;

    public Game(Board board, Player p1, Player p2) {
        this.board   = board;
        this.p1      = p1;
        this.p2      = p2;
        this.current = p1;
        // El primer turno siempre es para el jugador con marca 'X'
        this.current = (p1.getMark() == 'X') ? p1 : (p2.getMark() == 'X' ? p2 : p1);
    }

    /** Juega un turno: pide movimiento, lo coloca, cambia jugador. */
    public void playTurn() {
        Move m = current.nextMove(board);
        board.colocarFicha(m.row, m.col, m.mark);
        // no cambiamos turno aún hasta que comprobemos fin
    }
    /** Devuelve la ficha del jugador que está por jugar. */
    public char getCurrentMark() {
        return current.getMark();
    }
    
    /** Aplica un turno completo: move + cambio de turno */
    public void step() {
        playTurn();
       
        current = (current == p1 ? p2 : p1);
    
    }

    /** ¿Se terminó el juego? */
    public boolean isOver() {
        return board.hayVictoria(p1.getMark())
            || board.hayVictoria(p2.getMark())
            || board.estaLleno();
    }

    /** Si hay ganador devuelve su marca, si es empate devuelve ' ' */
    public char getResult() {
        if (board.hayVictoria(p1.getMark())) return p1.getMark();
        if (board.hayVictoria(p2.getMark())) return p2.getMark();
        return board.estaLleno() ? ' ' : 0;
    }
}
