package com.xnd.ajedrezfx;

/**
 * Clase padre de todas las piezas
 */
public abstract class Pieza {
    // ******* ATRIBUTOS *******
    boolean color; // true = BLANCO , false = NEGRO
    String nombre;

    // ******* CONSTRUCTORES *******
    /**
     * Constructor de pieza
     * @param color true = BLANCA, false = NEGRA
     * @param nombre Icono de la pieza (caracter unicode)
     */
    public Pieza(boolean color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    // ******* GETTERS *******
    /**
     * Devuelve el color de la pieza
     * @return Color de la pieza
     */
    public boolean getColor() {
        return color;
    }

    /**
     * Devuelve el icono de la pieza
     * @return Icono de la pieza
     */
    public String getNombre() {
        return nombre;
    }

    // ******* MÉTODOS *******
    /**
     * Método que verifica si un movimiento es válido para ese tipo de pieza
     * @param mov Movimiento
     * @return true si el movimiento es válido
     */
    public abstract boolean validoMovimiento (Movimiento mov, Tablero tablero);
}
