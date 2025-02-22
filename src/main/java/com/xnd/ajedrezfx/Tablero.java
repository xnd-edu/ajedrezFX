package com.xnd.ajedrezfx;

import java.util.Scanner;

/**
 * Clase del tablero, incluye el array con las piezas y métodos para camiarlas.
 */
public class Tablero {
    // ******* ATRIBUTOS *******
    Pieza[][] tablero = new Pieza[8][8];

    // ******* CONSTRUCTORES *******
    /**
     * Constructor del tablero. Coloca las piezas en sus respectivas posiciones iniciales.
     */
    public Tablero() {
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(false, "PeonNegro"); // Peones negros
            tablero[6][i] = new Peon(true, "PeonBlanco"); // Peones blancos
        }

        // Torres
        tablero[0][0] = new Torre(false, "TorreNegra"); // Torre negra izquierda
        tablero[0][7] = new Torre(false, "TorreNegra"); // Torre negra derecha
        tablero[7][0] = new Torre(true, "TorreBlanca");  // Torre blanca izquierda
        tablero[7][7] = new Torre(true, "TorreBlanca");  // Torre blanca derecha

        // Caballos
        tablero[0][1] = new Caballo(false, "CaballoNegro"); // Caballo negro izquierda
        tablero[0][6] = new Caballo(false, "CaballoNegro"); // Caballo negro derecha
        tablero[7][1] = new Caballo(true, "CaballoBlanco");  // Caballo blanco izquierda
        tablero[7][6] = new Caballo(true, "CaballoBlanco");  // Caballo blanco derecha

        // Alfiles
        tablero[0][2] = new Alfil(false, "AlfilNegro"); // Alfil negro izquierda
        tablero[0][5] = new Alfil(false, "AlfilNegro"); // Alfil negro derecha
        tablero[7][2] = new Alfil(true, "AlfilBlanco");  // Alfil blanco izquierda
        tablero[7][5] = new Alfil(true, "AlfilBlanco");  // Alfil blanco derecha

        // Damas
        tablero[0][3] = new Reina(false, "ReinaNegra"); // Reina negra
        tablero[7][3] = new Reina(true, "ReinaBlanca");  // Reina blanca

        // Reyes
        tablero[0][4] = new Rey(false, "ReyNegro"); // Rey negro
        tablero[7][4] = new Rey(true, "ReyBlanco");  // Rey blanco
    }

    // ******* MÉTODOS *******
    /**
     * Método que imprime el tablero con las piezas en sus posiciones actuales
     */
    public void pintarTablero() {
        // Imprimir los números de las columnas
        for (int i = 0; i < tablero.length; i++) {
            if (i == 0)
                System.out.print("  \u2006\u2006");
            System.out.print((char) (i + 'A') + "\u2006 ");
        }
        System.out.println();

        int k = 8;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                // Imprimir las letras de las filas
                if (j == 0) {
                    System.out.print(k + " ");
                    k--;
                }

                if (hayPieza(i,j)) {
                    System.out.print("\u2006\u2006" + devuelvePieza(i,j).getNombre()); // \u2006 es un espacio para centrar las piezas mas
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print(" \u25A1"); // Cuadrado blanco
                    } else {
                        System.out.print(" \u25A0"); // Cuadrado negro
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Comprueba si existe una pieza en una casilla (not null)
     * @param fila
     * @param columna
     * @return true si hay pieza
     */
    public boolean hayPieza(int fila, int columna) {
        return tablero[fila][columna] != null;
    }

    /**
     * Comprueba si existe una pieza en una casilla (not null)
     * @param pos
     * @return true si hay pieza
     */
    public boolean hayPieza(Posicion pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    /**
     * Método que comprueba si existen piezas dentro del movimiento especificado
     * @param mov Movimiento
     * @return true si hay piezas entre la posición inicial y final
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        if (mov == null) {
            return false;
        }

        boolean piezaDetectada = false;
        int filaInicialMov = mov.posInicial.getFila();
        int columnaInicialMov = mov.posInicial.getColumna();
        int filaFinalMov = mov.posFinal.getFila();
        int columnaFinalMov = mov.posFinal.getColumna();

        if (mov.esVertical()) {
            if (filaFinalMov < filaInicialMov) {
                int aux = filaFinalMov;
                filaFinalMov = filaInicialMov;
                filaInicialMov = aux;
            }
            for (int i = filaInicialMov + 1; i < filaFinalMov; i++) {
                if (hayPieza(i, columnaInicialMov))
                    piezaDetectada = true;
            }
        } else if (mov.esHorizontal()) {
            if (columnaFinalMov < columnaInicialMov) {
                int aux = columnaFinalMov;
                columnaFinalMov = columnaInicialMov;
                columnaInicialMov = aux;
            }
            for (int i = columnaInicialMov + 1; i < columnaFinalMov; i++) {
                if (hayPieza(filaInicialMov, i))
                    piezaDetectada = true;
            }
        } else if (mov.esDiagonal()) {
            int pasoFila = filaFinalMov > filaInicialMov ? 1 : -1;
            int pasoColumna = columnaFinalMov > columnaInicialMov ? 1 : -1;

            int fila = filaInicialMov + pasoFila;
            int columna = columnaInicialMov + pasoColumna;

            while (fila != filaFinalMov && columna != columnaFinalMov) {
                if (hayPieza(fila, columna)) return true;
                fila += pasoFila;
                columna += pasoColumna;
            }
        }

        return piezaDetectada;
    }

    /**
     * Método que pone una pieza en la casilla especificada
     * @param figura
     * @param fila
     * @param columna
     */
    public void ponPieza (Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }

    /**
     * Método que pone una pieza en la casilla especificada
     * @param figura
     * @param pos
     */
    public void ponPieza (Pieza figura, Posicion pos) {
        ponPieza(figura, pos.getFila(), pos.getColumna());
    }

    /**
     * Método que elimina una pieza de la casilla especificada
     * @param fila
     * @param columna
     */
    public void quitaPieza (int fila, int columna) {
        tablero[fila][columna] = null;
    }

    /**
     * Método que elimina una pieza de la casilla especificada
     * @param pos
     */
    public void quitaPieza (Posicion pos) {
        quitaPieza(pos.getFila(), pos.getColumna());
    }

    /**
     * Método que devuelve la pieza situada en la casilla especificada
     * @param fila
     * @param columna
     * @return La clase Pieza
     */
    public Pieza devuelvePieza (int fila, int columna) {
        return tablero[fila][columna];
    }

    public Pieza devuelvePieza (Posicion pos) {
        return devuelvePieza(pos.getFila(), pos.getColumna());
    }

    public void promocionPeon (Movimiento mov) {
        boolean noValido;
        int opcion;
        boolean color = devuelvePieza(mov.posInicial).getColor();
//        String idioma = strings.getIdioma();
        Scanner sc = new Scanner(System.in);
//        System.out.println(strings.toString(idioma, "promocionPeon"));
        do {
            noValido = false;
            opcion = sc.nextInt();
            switch (opcion) {
                // Reina
                case 1:
                    if (color)
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Reina(true, "\u2655");
                    else
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Reina(false, "\u265B");
                    break;
                // Torre
                case 2:
                    if (color)
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Torre(true, "\u2656");
                    else
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Torre(false, "\u265C");
                    break;
                // Alfil
                case 3:
                    if (color)
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Alfil(true, "\u2657");
                    else
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Alfil(false, "\u265D");
                    break;
                // Caballo
                case 4:
                    if (color)
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Caballo(true, "\u2658");
                    else
                        tablero[mov.posInicial.getFila()][mov.posInicial.getColumna()] = new Caballo(false, "\u265E");
                    break;
                default:
//                    System.out.println(strings.toString(idioma, "errOpcionNoValida"));
                    noValido = true;
            }
        } while (noValido);
    }
}
