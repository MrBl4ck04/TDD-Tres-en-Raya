// src/main/java/com/tictactoe/model/ConsolePlayer.java
package com.tictactoe.model;

import java.util.Scanner;

public class ConsolePlayer implements Player {
    private final char mark;
    private final Scanner sc;

    public ConsolePlayer(char mark, Scanner sc) {
        this.mark = mark;
        this.sc = sc;
    }

    @Override
    public Move nextMove(Board board) {
        while (true) {
            System.out.printf("Jugador %c, ingresa columna y fila (0–2): ", mark);
            int col = sc.nextInt(); // Columna (X)
            int row = sc.nextInt(); // Fila (Y)
            try {
                // Utilizamos directamente el método colocarPieza del Requerimiento 1
                // que ya incluye todas las validaciones necesarias
                // Nota: No colocamos realmente la ficha, solo validamos
                try {
                    // Intentamos validar usando colocarPieza sin realmente colocar
                    // Creamos un tablero temporal para la validación
                    Board tempBoard = new Board();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            Character ficha = board.obtenerCasilla(i, j);
                            if (ficha != null) {
                                tempBoard.colocarPieza(j, i, ficha);
                            }
                        }
                    }

                    // Validamos la jugada usando colocarPieza
                    tempBoard.colocarPieza(col, row, mark);

                    // Si llegamos aquí, la jugada es válida
                    return new Move(row, col, mark);
                } catch (IllegalArgumentException ex) {
                    // La excepción ya contiene el mensaje específico de validarPosicionX,
                    // validarPosicionY o validarCasillaVacia
                    throw ex;
                }
            } catch (IllegalArgumentException ex) {
                // Mostramos el mensaje específico de la excepción
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public char getMark() {
        return mark;
    }
}
