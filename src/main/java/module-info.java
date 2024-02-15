module com.example.csd214_bipanalab1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.csd214_bipanalab1 to javafx.fxml;
    exports com.example.csd214_bipanalab1;
}