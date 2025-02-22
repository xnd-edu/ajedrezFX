package com.xnd.ajedrezfx;

/**
 * Clase del peón, hija de la clase Pieza
 */
public class Peon extends Pieza {
    // ******* CONSTRUCTORES *******
    public Peon(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if (mov.esVertical()) {
            if (color) {
                if (mov.posInicial.getFila() == 6) {
                    return !tablero.hayPieza(mov.posFinal) && (mov.saltoVertical() == -1 || mov.saltoVertical() == -2);
                } else {
                    return !tablero.hayPieza(mov.posFinal) && mov.saltoVertical() == -1;
                }
            } else {
                if (mov.posInicial.getFila() == 1) {
                    return !tablero.hayPieza(mov.posFinal) && (mov.saltoVertical() == 1 || mov.saltoVertical() == 2);
                } else {
                    return !tablero.hayPieza(mov.posFinal) && mov.saltoVertical() == 1;
                }
            }
        } else if (mov.esDiagonal()) {
            if (color) {
                return mov.saltoVertical() == -1 && tablero.hayPieza(mov.posFinal);
            } else {
                return mov.saltoVertical() == 1 && tablero.hayPieza(mov.posFinal);
            }
        } else
            return false;
    }
}
