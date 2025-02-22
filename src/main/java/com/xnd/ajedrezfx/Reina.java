package com.xnd.ajedrezfx;

/**
 * Clase de la reina, hija de la clase Pieza
 */
public class Reina extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Reina(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov, Tablero tablero) {
        return mov.esHorizontal() || mov.esVertical() || mov.esDiagonal();
    }
}
