module com.iti.dbapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.iti.dbapp to javafx.fxml;
    exports com.iti.dbapp;
}