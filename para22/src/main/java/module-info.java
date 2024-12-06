module com.example.para22 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens com.example.para22 to javafx.fxml;
    exports com.example.para22;
}