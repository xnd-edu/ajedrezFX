package com.xnd.ajedrezfx;

/**
 * Clase que controla la posición
 */
public class Posicion {
    // ******* ATRIBUTOS *******
    int fila;
    int columna;

    // ******* CONSTRUCTORES *******

    /**
     * Constructor de la posición por defecto (0,0)
     */
    public Posicion() {
        this.fila = 0;
        this.columna = 0;
    }

    /**
     * Contructor de la posición con su fila y columna
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // ******* SETTERS *******

    /**
     * Establece la fila de la posición
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Establece la columna de la posición
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

   // ******* GETTERS *******

    /**
     * Devuelve la fila de la posición
     * @return fila
     */
    public int getFila() {
        return this.fila;
    }

    /**
     * Devuelve la columna de la posición
     * @return columna
     */
    public int getColumna() {
        return this.columna;
    }
}
