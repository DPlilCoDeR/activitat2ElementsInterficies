module com.m486.activitat2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.m486.activitat2 to javafx.fxml;
    exports com.m486.activitat2;
}