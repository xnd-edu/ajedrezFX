package com.xnd.ajedrezfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chess GOTY Edition");
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();

        // Evitar el cierre del juego
        stage.setOnCloseRequest(event -> {
            event.consume();
            controller.confirmarCierre(stage);
        });
    }




    public static void main(String[] args) {
        launch();
    }
}