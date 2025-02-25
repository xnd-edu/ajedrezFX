package com.xnd.ajedrezfx;

/**
 * Clase que maneja el sistema de strings traducidos
 */
public class Strings {
    private String idioma;

    /**
     * Constructor del sistema de strings, por defecto el idioma es el inglés.
     */
    public Strings() {
        this.idioma = "en";
    }

    /**
     * Devuelve el idioma establecido de los strings
     * @return Código del idioma (Ej: "en")
     */
    public String getIdioma() {
        if (this.idioma == null)
            return "en";
        else
            return this.idioma;
    }

    /**
     * Establece el idioma de los strings
     * @param idioma Código del idioma (Ej: "en")
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Método que devuelve el string indicado en el idioma establecido
     * @param idioma Idioma establecido (si no se especifica usa el inglés)
     * @param string El nombre del string que será devuelto
     * @return String traducido. Si no existe el string devuelve un mensaje indicando que falta localizarlo.
     */
    public String toString(String idioma, String string) {
        switch (this.idioma) {
            default:
                // Si no se especifica idioma usar el inglés
            case "English":
                switch (string) {
                    // Clase main
                    case "empezarJuego":
                        return "Starting game...";
                    case "errOpcionNoValida":
                        return "Please choose a valid option.";
                    case "turnoBlancas":
                        return "Whites turn";
                    case "turnoNegras":
                        return "Blacks turn";
                    case "introduceJugada":
                        return "Introduce move (Example: A2B3):";
                    // Clase Juego
                    case "errLongitudJugada":
                        return "Error: The move must have 4 characters. (Example: A2B3)";
                    case "errFormato":
                        return "Error: Incorrect format.";
                    case "errNoPieza":
                        return "There is no piece in that position.";
                    case "errColorIncorrecto":
                        return "That piece does not belong to you.";
                    case "errCanibal":
                        return "You cannot eat your own pieces.";
                    case "errMovNoValido":
                        return "The move is not valid.";
                    case "errPiezasEnMedio":
                        return "There are pieces in between.";
                    // Clase HelloController
                    case "promocionPeon":
                        return "Which piece do you want to promote to?";
                    case "piezaSelec":
                        return "Piece selected in: ";
                    case "casillaVacia":
                        return "Empty square";
                    case "eligeCasilla":
                        return "Click the squares to move the pieces";
                    case "reina":
                        return "Queen";
                    case "torre":
                        return "Rook";
                    case "alfil":
                        return "Bishop";
                    case "caballo":
                        return "Horse";
                    case "eligePieza":
                        return "Choose a piece:";
                    case "cierreJuego":
                        return "Exit Game";
                    case "confirmacionCierre":
                        return "Are you sure you want to quit?";
                    case "advertenciaCierre":
                        return "Any progress will be lost.";
                }

            case "Español":
                switch (string) {
                    // Clase main
                    case "empezarJuego":
                        return "Empezando el juego...";
                    case "errOpcionNoValida":
                        return "Por favor elija una opción valida.";
                    case "turnoBlancas":
                        return "Turno de blancas";
                    case "turnoNegras":
                        return "Turno de negras";
                    case "introduceJugada":
                        return "Introduce jugada (Ejemplo: A2B3):";
                    // Clase Juego
                    case "errLongitudJugada":
                        return "Error: La jugada debe tener 4 caracteres. (Ejemplo: A2B3)";
                    case "errFormato":
                        return "Error: Formato incorrecto.";
                    case "errNoPieza":
                        return "No hay ninguna pieza en esa posición.";
                    case "errColorIncorrecto":
                        return "Esa pieza no te pertenece.";
                    case "errCanibal":
                        return "No puedes comerte tus propias piezas.";
                    case "errMovNoValido":
                        return "El movimiento no es válido.";
                    case "errPiezasEnMedio":
                        return "Hay piezas en medio.";
                    // Clase HelloController
                    case "promocionPeon":
                        return "¿A qué pieza quieres promocionar?";
                    case "piezaSelec":
                        return "Pieza seleccionada en: ";
                    case "casillaVacia":
                        return "Casilla vacía";
                    case "eligeCasilla":
                        return "Haz click en las casillas para mover las piezas.";
                    case "reina":
                        return "Reina";
                    case "torre":
                        return "Torre";
                    case "alfil":
                        return "Alfil";
                    case "caballo":
                        return "Caballo";
                    case "eligePieza":
                        return "Elige una pieza:";
                    case "cierreJuego":
                        return "Cerrar el Juego";
                    case "confirmacionCierre":
                        return "¿Estás seguro de que quieres salir?";
                    case "advertenciaCierre":
                        return "Se perderá todo el progreso.";
                }
        }
        return "STRING NOT LOCALISED";
    }
}
