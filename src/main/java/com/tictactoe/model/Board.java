package com.tictactoe.model;

public class Board {
    private static final int SIZE = 3;
    private final Character[][] cells;

    public Board() {
        this.cells = new Character[SIZE][SIZE];
    }

    /**
     * Devuelve la ficha en la casilla (fila, columna), o null si está vacía.
     */
    public Character obtenerCasilla(int fila, int columna) {
        validarCoordenadas(fila, columna);
        return cells[fila][columna];
    }

    /**
     * Coloca la ficha 'mark' en la casilla indicada. Lanza IllegalArgumentException
     * si la casilla está ocupada o las coordenadas son inválidas.
     */
    public void colocarFicha(int fila, int columna, char mark) {
        validarCoordenadas(fila, columna);
        if (cells[fila][columna] != null) {
            throw new IllegalArgumentException("La casilla está ocupada");
        }
        cells[fila][columna] = mark;
    }

    /**
     * Verifica si el tablero está completamente lleno (sin casillas nulas).
     */
    public boolean estaLleno() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Comprueba si el jugador con ficha 'mark' ha ganado.
     */
    public boolean hayVictoria(char mark) {
        return hayVictoriaEnColumnas(mark)
            || hayVictoriaEnDiagonales(mark);
    }

    // ——— Métodos auxiliares de victoria ———

   

    private boolean hayVictoriaEnColumnas(char mark) {
        for (int j = 0; j < SIZE; j++) {
            if (esFichaIgual(0, j, mark)
             && esFichaIgual(1, j, mark)
             && esFichaIgual(2, j, mark)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Refactor  R3: comprueba ambas diagonales de forma concisa en una sola expresión.
     */
    private boolean hayVictoriaEnDiagonales(char mark) {
        boolean principal = esFichaIgual(0, 0, mark)
                         && esFichaIgual(1, 1, mark)
                         && esFichaIgual(2, 2, mark);
        boolean secundaria = esFichaIgual(0, 2, mark)
                          && esFichaIgual(1, 1, mark)
                          && esFichaIgual(2, 0, mark);
        return principal || secundaria;
    }


    private boolean esFichaIgual(int fila, int columna, char mark) {
        return cells[fila][columna] != null
            && cells[fila][columna] == mark;
    }
    /**
     * Devuelve true si el tablero está lleno y no hay victoria de X ni de O.
     */
    public boolean hayEmpate() {
        return estaLleno() 
            && !hayVictoria('X') 
            && !hayVictoria('O');
    }

    // ——— Validación de coordenadas ———

    private void validarCoordenadas(int fila, int columna) {
        if (fila < 0 || fila >= SIZE || columna < 0 || columna >= SIZE) {
            throw new IllegalArgumentException(
                String.format("Coordenadas (%d,%d) fuera de rango", fila, columna)
            );
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append("| ");
            for (int j = 0; j < SIZE; j++) {
                sb.append(cells[i][j] == null ? " " : cells[i][j]);
                sb.append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
