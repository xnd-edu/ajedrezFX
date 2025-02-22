package com.xnd.ajedrezfx;

import java.util.Scanner;

/**
 * Clase donde se ejecuta el juego
 */
public class Main {
//    public static void main(String[] args) {
//        boolean finJuego = false;
//        boolean noValido;
//        Tablero tablero = new Tablero();
//        Juego juego = new Juego();
//        Scanner sc = new Scanner(System.in);
//        Movimiento mov = new Movimiento();
//        Strings strings = new Strings();
//        String idioma = strings.getIdioma();
//
//        System.out.println("Choose your language:");
//        System.out.println("1. English");
//        System.out.println("2. Español (Spanish)");
//        do {
//            noValido = false;
//            int opcion = sc.nextInt();
//            switch (opcion) {
//                case 1:
//                    strings.setIdioma("en");
//                    break;
//                case 2:
//                    strings.setIdioma("es");
//                    break;
//                default:
//                    System.out.println(strings.toString(idioma, "errOpcionNoValida"));
//                    noValido = true;
//            }
//        } while (noValido);
//        System.out.println(strings.toString(idioma, "empezarJuego") + "\n");
//
//        // Limpiar escáner
//        sc.nextLine();
//
//        do {
//            if (juego.getTurno())
//                System.out.println(strings.toString(idioma, "turnoBlancas"));
//            else
//                System.out.println(strings.toString(idioma, "turnoNegras"));
//
//            tablero.pintarTablero();
//
//            do {
//                System.out.println(strings.toString(idioma, "introduceJugada"));
//                String jugada = sc.nextLine().toUpperCase();
//
//                if (jugada.equals("QUIT") || jugada.equals("SALIR")) {
//                    finJuego = true;
//                    break;
//                }
//
//                mov = juego.jugada(jugada, tablero, strings);
//            } while (mov == null);
//
//            tablero.ponPieza(tablero.devuelvePieza(mov.posInicial), mov.posFinal);
//            tablero.quitaPieza(mov.posInicial);
//
//            juego.setTurno(!juego.getTurno());
//        } while (!finJuego);
//    }
}
