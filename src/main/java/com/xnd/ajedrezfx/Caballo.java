package com.xnd.ajedrezfx;

/**
 * Clase del caballo, hija de la clase Pieza
 */
public class Caballo extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Caballo(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov, Tablero tablero) {
        return (Math.abs(mov.saltoVertical()) == 1 && Math.abs(mov.saltoHorizontal()) == 2) || (Math.abs(mov.saltoVertical()) == 2 && Math.abs(mov.saltoHorizontal()) == 1);
    }
}
