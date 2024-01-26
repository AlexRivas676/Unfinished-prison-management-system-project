module com.example.prisonmangementsystem3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.prisonmangementsystem3 to javafx.fxml;
    exports com.example.prisonmangementsystem3;
}