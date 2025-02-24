package com.xnd.ajedrezfx;

import com.xnd.ajedrezfx.Juego;
import com.xnd.ajedrezfx.Movimiento;
import com.xnd.ajedrezfx.Posicion;
import com.xnd.ajedrezfx.Tablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Label labelTurno;
    @FXML
    private GridPane mainGrid;

    private Posicion posInicial = null;
    private Posicion posFinal = null;
    private Tablero tablero;
    private Juego juego;

    private Strings strings = new Strings();
    String idioma = strings.getIdioma();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        juego = new Juego();
        tablero = new Tablero();
        elegirIdioma();
        pintarTablero();
    }

    protected void elegirIdioma() {
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("English", "English", "Español");
        choiceDialog.setTitle("Language selection - Simple Chess");
        choiceDialog.setHeaderText("Choose your language");
        choiceDialog.setContentText("Select a language:");

        choiceDialog.showAndWait().ifPresent(idiomaSeleccionado -> strings.setIdioma(idiomaSeleccionado));
    }

    private void pintarTablero() {
        // Estos solo es ejecutan al empezar el juego
        labelTurno.setText(juego.getTurno() ? strings.toString(idioma, "turnoBlancas") : strings.toString(idioma, "turnoNegras"));
        label.setText(strings.toString(idioma, "eligeCasilla"));


        mainGrid.getChildren().clear();

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                Pane pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #146861;");
                } else {
                    pane.setStyle("-fx-background-color: #8defdd");
                }

                if (tablero.hayPieza(i, j)) {
                    pane.getChildren().add(new ImageView(new Image("File:src/main/resources/com/xnd/ajedrezfx/imagenes/" + tablero.devuelvePieza(i, j).getNombre() + ".png")));
                }

                int fila = i;
                int columna = j;
                pane.setOnMouseClicked(e -> manejadorMovimiento(fila, columna));

                mainGrid.add(pane, j, i);
            }
        }
    }

    private void manejadorMovimiento(int fila, int columna) {
        if (posInicial == null) {
            // Primera selección: guardamos la pieza seleccionada
            if (tablero.hayPieza(fila, columna)) {
                posInicial = new Posicion(fila, columna);
                char columnaTexto = (char) (columna + 65);
                int filaTexto = Math.abs(fila - 8);
                label.setText(strings.toString(idioma, "piezaSelec") + "(" + columnaTexto + filaTexto + ")");
            } else {
                label.setText(strings.toString(idioma, "casillaVacia"));
            }
        } else {
            // Segunda selección: intentamos mover la pieza
            posFinal = new Posicion(fila, columna);
            Movimiento mov = new Movimiento(posInicial, posFinal);

            // Intentamos hacer el movimiento
            String resultado = juego.jugada(mov, tablero, strings);

            if (resultado == null) {
                // Movimiento válido, actualizar tablero
                tablero.ponPieza(tablero.devuelvePieza(posInicial), posFinal);
                tablero.quitaPieza(posInicial);
                pintarTablero(); // Redibujar el tablero para reflejar los cambios
                juego.setTurno(!juego.getTurno()); // Cambiar turno
                labelTurno.setText(juego.getTurno() ? strings.toString(idioma, "turnoBlancas") : strings.toString(idioma, "turnoNegras"));
            } else if (resultado.equals("promocionPeon")) {
                ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(strings.toString(idioma, "reina"), strings.toString(idioma, "reina"), strings.toString(idioma, "torre"), strings.toString(idioma, "alfil"), strings.toString(idioma, "caballo"));
                choiceDialog.setTitle("Pawn promotion - Simple Chess");
                choiceDialog.setHeaderText(strings.toString(idioma, "promocionPeon"));
                choiceDialog.setContentText(strings.toString(idioma, "eligePieza"));

                choiceDialog.showAndWait().ifPresent(piezaSeleccionada -> tablero.promocionPeon(mov, piezaSeleccionada, strings));

                pintarTablero(); // Redibujar el tablero para reflejar los cambios
                juego.setTurno(!juego.getTurno()); // Cambiar turno
                labelTurno.setText(juego.getTurno() ? strings.toString(idioma, "turnoBlancas") : strings.toString(idioma, "turnoNegras"));
            } else {
                label.setText(resultado);
            }

            // Resetear las selecciones
            posInicial = null;
            posFinal = null;
        }
    }
}