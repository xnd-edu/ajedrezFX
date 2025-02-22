package com.xnd.ajedrezfx;

import com.xnd.ajedrezfx.Juego;
import com.xnd.ajedrezfx.Movimiento;
import com.xnd.ajedrezfx.Posicion;
import com.xnd.ajedrezfx.Tablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private GridPane mainGrid;

    private Posicion posInicial = null;
    private Posicion posFinal = null;
    private Tablero tablero;
    private Juego juego;


    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }

    /*public void click(MouseEvent mouseEvent) {
        int columna = 0;
        int fila = 0;
        for (Node node : mainGrid.getChildren()) {
            if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                columna = GridPane.getColumnIndex(node);
                fila = GridPane.getRowIndex(node);
            }
        }
        boolean encontrado=false;
        for (int i=0; i< mainGrid.getChildren().size()  && !encontrado;i++) {
            Node node = mainGrid.getChildren().get(i);
            if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                columna = GridPane.getColumnIndex(node);
                fila = GridPane.getRowIndex(node);
                encontrado = true;
            }
        }
        System.out.println(fila+" "+columna);
        //Otra forma
        /*Node node = (Node) mouseEvent.getTarget();
        if (node != null && node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
            columna = GridPane.getColumnIndex(node);
            fila = GridPane.getRowIndex(node);
            System.out.println("Row : " + fila + ", Col : " + columna);
        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        juego = new Juego();
        tablero = new Tablero();
        pintarTablero();
    }
    public void accion(String coordenadas){
        String args[] = coordenadas.split(";");
        int fila = Integer.parseInt(args[0]);
        int columna = Integer.parseInt(args[1]);
        System.out.println(fila+"-"+columna);
    }
    public void accion(int x, int y){
        System.out.println(x+"-"+y);
    }
    private void pintarTablero() {
        mainGrid.getChildren().clear();

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                Pane pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #684714;");
                } else {
                    pane.setStyle("-fx-background-color: #ffe68e");
                }

                if (tablero.hayPieza(i,j)) {
                    pane.getChildren().add(new ImageView(new Image("File:src/main/resources/com/xnd/ajedrezfx/imagenes/" + tablero.devuelvePieza(i,j).getNombre() + ".png")));
                }

//                if (i == j) {
//                    //addAll vs add
//                    pane.getChildren().add(new ImageView(new Image("File:Ej3GridImageView/src/main/resources/com/example/ej3gridimageview/imagenes/CaballoBlanco.png")));
//
//                    //pane.getChildren().add(new ImageView(new Image("File:src/main/resources/com/example/ej3gridimageview/imagenes/CaballoBlanco.png")));
//                }

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
                label.setText("Pieza seleccionada en: " + fila + "," + columna);
            } else {
                label.setText("Casilla vacía");
            }
        } else {
            // Segunda selección: intentamos mover la pieza
            posFinal = new Posicion(fila, columna);
            Movimiento mov = new Movimiento(posInicial, posFinal);

            // Intentamos hacer el movimiento
            Movimiento resultado = juego.jugada(mov, tablero);

            if (resultado != null) {
                // Movimiento válido, actualizar tablero
                tablero.ponPieza(tablero.devuelvePieza(posInicial), posFinal);
                tablero.quitaPieza(posInicial);
                pintarTablero(); // Redibujar el tablero para reflejar los cambios
                juego.setTurno(!juego.getTurno()); // Cambiar turno
                label.setText(juego.getTurno() ? "Turno de Blancas" : "Turno de Negras");
            } else {
                label.setText("Movimiento no válido.");
            }

            // Resetear las selecciones
            posInicial = null;
            posFinal = null;
        }
    }



    public void enroque(ActionEvent actionEvent) {
    }
}