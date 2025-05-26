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
            //throw new IllegalArgumentException("La casilla está ocupada");
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
        return hayVictoriaEnFilas(mark)
                || hayVictoriaEnColumnas(mark)
                || hayVictoriaEnDiagonales(mark);
    }

    // ——— Métodos auxiliares de victoria ———
    /**
     * R3- Prueba 2: Refactor reutiliza el helper checkLine para evitar repetir
     * esFichaIgual
     */
    private boolean hayVictoriaEnFilas(char mark) {
        for (int i = 0; i < SIZE; i++) {
            // Reutiliza el helper checkLine para evitar repetir esFichaIgual
            if (checkLine(i, 0, i, 1, i, 2, mark)) {
                return true;
            }
        }
        return false;
    }

    /**
     * R3- Prueba 3: Refactor reutiliza el helper checkLine para evitar repetir
     * esFichaIgual
     */
    private boolean hayVictoriaEnColumnas(char mark) {
        for (int j = 0; j < SIZE; j++) {
            // Usa el helper checkLine para simplificar la comparación
            if (checkLine(0, j, 1, j, 2, j, mark)) {
                return true;
            }
        }
        return false;
    }

    /**
     * R3- Prueba 4: Refactor usando el helper checkLine para ambas diagonales.
     */
    private boolean hayVictoriaEnDiagonales(char mark) {
        return checkLine(0, 0, 1, 1, 2, 2, mark) // diagonal principal
                || checkLine(0, 2, 1, 1, 2, 0, mark); // diagonal secundaria
    }

    private boolean esFichaIgual(int fila, int columna, char mark) {
        return cells[fila][columna] != null
                && cells[fila][columna] == mark;
    }

    /**
     * R3- Prueba 1 : Refactor devuelve true si el tablero está lleno y no hay
     * victoria de X ni de O.
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
                    String.format("Coordenadas (%d,%d) fuera de rango", fila, columna));
        }
    }

    private boolean checkLine(int r1, int c1,
            int r2, int c2,
            int r3, int c3,
            char mark) {
        return cells[r1][c1] != null && cells[r1][c1] == mark
                && cells[r2][c2] != null && cells[r2][c2] == mark
                && cells[r3][c3] != null && cells[r3][c3] == mark;
    }

    /**
     * R1: Una pieza puede estar colocada en un espacio de un tablero 3x3
     * Coloca una pieza en el tablero validando que las coordenadas sean válidas
     * y que la casilla no esté ocupada.
     */
    public void colocarPieza(int x, int y, char pieza) {
        validarPosicionX(x);
        validarPosicionY(y);
        validarCasillaVacia(x, y);

        // Ahora colocamos la pieza en el tablero
        cells[y][x] = pieza;
    }

    /**
     * Requerimiento 1 - Prueba 1: Validación de posición en eje X
     * Verifica que la coordenada X esté dentro del rango válido (0-2)
     */
    private void validarPosicionX(int x) {
        if (x < 0 || x > 2) {
            throw new IllegalArgumentException("[!] Posición X fuera del tablero");
        }
    }

    /**
     * Requerimiento 1 - Prueba 2: Validación de posición en eje Y
     * Verifica que la coordenada Y esté dentro del rango válido (0-2)
     */
    private void validarPosicionY(int y) {
        if (y < 0 || y > 2) {
            throw new IllegalArgumentException("[!] Posición Y fuera del tablero");
        }
    }

    /**
     * Requerimiento 1 - Prueba 3: Validación de casilla ocupada
     * Verifica que la casilla no esté ocupada antes de colocar una pieza
     */
    private void validarCasillaVacia(int x, int y) {
        if (cells[y][x] != null) {
            throw new IllegalArgumentException("[!] Posición ya ocupada");
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
