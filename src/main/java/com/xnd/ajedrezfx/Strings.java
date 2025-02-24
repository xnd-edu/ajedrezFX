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
                    case "promocionPeon":
                        return "Which piece do you want to promote to? \n1. Queen \n2. Rook \n3. Bishop \n4. Knight";
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
                    case "promocionPeon":
                        return "¿A qué pieza quieres promocionar? \n1. Reina \n2. Torre \n3. Alfil \n4. Caballo";
                }
        }
        return "STRING NOT LOCALISED";
    }
}
