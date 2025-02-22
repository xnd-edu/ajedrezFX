module com.example.ej3gridimageview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xnd.ajedrezfx to javafx.fxml;
    exports com.xnd.ajedrezfx;
}