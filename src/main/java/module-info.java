module com.example.gaztnik2_0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gaztnik2_0 to javafx.fxml;
    exports com.example.gaztnik2_0;
    exports com.example.gaztnik2_0.model;
    opens com.example.gaztnik2_0.model to javafx.fxml;
    exports com.example.gaztnik2_0.ui;
    opens com.example.gaztnik2_0.ui to javafx.fxml;
}