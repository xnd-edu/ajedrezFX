package com.xnd.ajedrezfx;

/**
 * Clase del rey, hija de la clase Pieza
 */
public class Rey extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Rey(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov, Tablero tablero) {
        return Math.abs(mov.saltoVertical()) == 1 && mov.esVertical() || Math.abs(mov.saltoHorizontal()) == 1 && mov.esHorizontal() || Math.abs(mov.saltoHorizontal()) == 1 && Math.abs(mov.saltoVertical()) == 1;
    }
}
