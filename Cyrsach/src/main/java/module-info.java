module com.example.Cyrsach {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.Cyrsach to javafx.fxml;
    exports com.example.Cyrsach;

}