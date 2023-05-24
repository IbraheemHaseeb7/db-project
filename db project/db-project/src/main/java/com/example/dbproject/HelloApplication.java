package com.example.dbproject;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // ASSIGNING TO A PUBLIC VARIABLE SO IT CAN BE HANDLED ANYWHERE
        mainStage = stage;

        // LOADING FXML FILE
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 600, 400);

        // STAGE PROPERTIES
        mainStage.setTitle("Login!");
        mainStage.setResizable(true);
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    // making connection static and public to reduce unnecessary connections everywhere
    public static Connection con;
    public static Statement statement;
    public static Stage mainStage;
    public static Scene mainScene;

    // connection to database
    {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T93TQ81;trustServerCertificate=true;IntegratedSecurity=true;encrypt=true;Database=ISMS");
            statement = con.createStatement();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}