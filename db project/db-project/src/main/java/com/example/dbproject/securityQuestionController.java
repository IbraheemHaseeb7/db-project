package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.ResultSet;

public class securityQuestionController{

    @FXML
    TextField username = new TextField();
    @FXML TextField question = new TextField();
    @FXML
    Text notification = new Text();

    @FXML
    protected void handleSubmit() {

        try {
            String query = "SELECT E_NAME FROM EMPLOYEE e WHERE e.E_USERNAME='" + username.getText() + "' and e.E_QUESTION='" + question.getText() + "'";
            ResultSet res = HelloApplication.statement.executeQuery(query);

            FXMLLoader changePassword = new FXMLLoader(HelloApplication.class.getResource("changePassword.fxml"));

            if (res.next()) {
                Parent parent = changePassword.load();
                changePassword cp = new changePassword();
                cp = changePassword.getController();
                cp.enterYourNewPassword.setText("Enter your new password, " + res.getString("E_NAME"));
                HelloApplication.mainStage.setScene(new Scene(parent, 600, 400));
            } else {
                notification.setText("Imposter???????");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
