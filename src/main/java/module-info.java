module com.example.casitatest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.logic to javafx.fxml;
    exports com.example.logic;
}