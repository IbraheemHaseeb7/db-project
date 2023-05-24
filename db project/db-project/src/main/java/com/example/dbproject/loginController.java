package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.ResultSet;

public class loginController {

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Text notification;
    @FXML
    protected void login() {

        try {
            String query = "select E_NAME, E_USERNAME, E_PASS from EMPLOYEE e where e.E_USERNAME='" +username.getText() + "' and e.E_PASS='" + password.getText() + "'";
            ResultSet res = HelloApplication.statement.executeQuery(query);

            if (!res.isBeforeFirst()) {
                notification.setText("Incorrect details.");
            } else {
                res.next();
                notification.setText("Welcome Back, " + res.getString("E_NAME"));

                HelloApplication.mainStage.setScene(new Scene(new FXMLLoader(HelloApplication.class.getResource("home.fxml")).load()));
            }

            username.setText("");
            password.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}