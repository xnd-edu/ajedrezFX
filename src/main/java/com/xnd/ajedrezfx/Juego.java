package com.xnd.ajedrezfx;

/**
 * Clase que maneja los turnos y las jugadas
 */
public class Juego {
    private boolean elTurno; // Como el color de pieza: true = BLANCAS , false = NEGRAS

    /**
     * Constructor del juego. El turno por defecto es true (blancas).
     */
    public Juego() {
        this.elTurno = true;
    }

    /**
     * Devuelve el turno actual
     *
     * @return El turno (true = turno blancas, false = turno negras)
     */
    public boolean getTurno() {
        return elTurno;
    }

    /**
     * Cambia el turno del juego
     *
     * @param elTurno El turno (true = turno blancas, false = turno negras)
     */
    public void setTurno(boolean elTurno) {
        this.elTurno = elTurno;
    }

    /**
     * Método que valida y convierte la jugada introducida por el usuario a un movimiento
     *
     * @param jugada  Coordenadas introducidas por el usuario (Ej: A2B3)
     * @param tablero Tablero donde se ejecuta la jugada
     * @param strings Sistema de strings para la localización
     * @return Movimiento de la pieza. Si el movimiento es nulo es que no es válido.
     */
    public Movimiento jugada(Movimiento mov, Tablero tablero) {
//        String idioma = strings.getIdioma();

//        // La jugada debe tener 4 caracteres
//        if (jugada.length() != 4)
//            System.out.println(strings.toString(idioma, "errLongitudJugada"));
//            // Los caracteres pares deben ser letras de de la A a la H
//        else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' || jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H')
//            System.out.println(strings.toString(idioma, "errFormato"));
//            // Los caracteres impares deben ser números del 1 al 8
//        else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' || jugada.charAt(3) < '1' || jugada.charAt(3) > '8')
//            System.out.println(strings.toString(idioma, "errFormato"));
//        else {
//
//            int columnaInicial = jugada.charAt(0) - 'A';
//            int columnaFinal = jugada.charAt(2) - 'A';
//            int filaInicial = 7 - (jugada.charAt(1) - '1');
//            int filaFinal = 7 - (jugada.charAt(3) - '1');

        // Abortar si el movimiento es inválido
        if (mov == null || mov.posInicial == null || mov.posFinal == null) {
            return null;
        }

        // Crear las posiciones del movimiento
        Posicion posInicial = mov.posInicial;
        Posicion posFinal = mov.posFinal;

        // Debe haber una pieza en la posición inicial, si no que estás moviendo?
        if (tablero.devuelvePieza(posInicial).getColor() != getTurno()) {
//                System.out.println(strings.toString(idioma, "errColorIncorrecto"));
            return null;
        } else if (tablero.hayPieza(posFinal)) {
            if (tablero.devuelvePieza(posFinal).getColor() == getTurno()) {
//                    System.out.println(strings.toString(idioma, "errCanibal"));
                return null;
            } else
                mov = new Movimiento(posInicial, posFinal);
        } else {
            // Si todo va bien crea una instancia del movimiento
            mov = new Movimiento(posInicial, posFinal);
        }

        // Verificar si el movimiento es válido para esa pieza
        // Si no es válido se vuelve nulo
        if (mov != null) {
            if ((tablero.hayPiezasEntre(mov))) {
                if (!(tablero.devuelvePieza(mov.posInicial).getNombre().equals("\u265E") || tablero.devuelvePieza(mov.posInicial).getNombre().equals("\u2658")) ){
//                    System.out.println(strings.toString(idioma, "errPiezasEnMedio"));
                    return null;
                }
            }
            if (!tablero.devuelvePieza(posInicial).validoMovimiento(mov, tablero)) {
//                System.out.println(strings.toString(idioma, "errMovNoValido"));
                return null;
            }
        }

        // Promoción del peón
        if (mov != null) {
            if ((tablero.devuelvePieza(posInicial).getNombre().equals("PeonNegro") && posFinal.getFila() == 7) || (tablero.devuelvePieza(posInicial).getNombre().equals("PeonBlanco") && posFinal.getFila() == 0)) {
                tablero.promocionPeon(mov);
            }
        }

        return mov;
    }

}
