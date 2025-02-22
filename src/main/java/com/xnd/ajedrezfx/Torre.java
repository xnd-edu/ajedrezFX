package com.xnd.ajedrezfx;

/**
 * Clase de la torre, hija de la clase Pieza
 */
public class Torre extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Torre(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov, Tablero tablero) {
        return mov.esVertical() || mov.esHorizontal();
    }
}
