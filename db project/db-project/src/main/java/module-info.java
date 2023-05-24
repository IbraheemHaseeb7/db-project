module com.example.dbproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;


    opens com.example.dbproject to javafx.fxml;
    exports com.example.dbproject;
}