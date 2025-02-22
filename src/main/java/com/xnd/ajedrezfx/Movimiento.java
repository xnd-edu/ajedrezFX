package com.xnd.ajedrezfx;

/**
 * Clase que maneja los movimientos con sus posiciones iniciales y finales
 */
public class Movimiento {
    // ******* ATRIBUTOS *******
    Posicion posInicial;
    Posicion posFinal;

    // ******* CONSTRUCTORES *******
    /**
     * Constructor del movimiento por defecto, posiciones (0,0) y (0,0)
     */
    public Movimiento() {
        this.posInicial = new Posicion(0,0);
        this.posFinal = new Posicion(0,0);
    }

    /**
     * Constructor del movimiento
     * @param posInicial Posición de donde empieza el movimiento
     * @param posFinal Posición donde acaba el movimiento
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    // ******* MÉTODOS *******
    /**
     * Método que verifica si un movimiento es vertical (en la misma columna)
     * @return true si el movimiento es vertical
     */
    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna() && !esHorizontal() && !esDiagonal();
    }

    /**
     * Método que verifica si un movimiento es horizontal (en la misma fila)
     * @return true si el movimiento es horizontal
     */
    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila() && !esVertical() && !esDiagonal();
    }

    /**
     * Método que verifica si un movimiento es diagonal
     * @return true si el movimiento es diagonal
     */
    public boolean esDiagonal() {
        return Math.abs(saltoHorizontal()) == Math.abs(saltoVertical());
    }

    /**
     * Método que cuenta cuantas casillas se mueve horizontalmente
     * @return Número de casillas desplazadas (será negativo si se desplaza a la izquierda)
     */
    public int saltoHorizontal() {
        return posFinal.getColumna() - posInicial.getColumna();
    }

    /**
     * Método que cuenta cuantas casillas se mueve verticalmente
     * @return Número de casillas desplazadas (será negativo si se desplaza hacia arriba)
     */
    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }
}
