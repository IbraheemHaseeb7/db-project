package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.sql.ResultSet;

public class changePassword {
    @FXML
    TextField newPassword = new TextField();
    @FXML
    TextField repeatPassword = new TextField();
    @FXML
    Text notification = new Text();
    @FXML
    Text enterYourNewPassword = new Text();
    @FXML
    protected void handleChangePassword() {

        if (newPassword.getText().equals(repeatPassword.getText())) {

            try {
                String query = "update EMPLOYEE set E_PASS='" + newPassword.getText() + "' where E_USERNAME='";
                ResultSet res = HelloApplication.statement.executeQuery(query);

                if (res.next()) {
                    HelloApplication.mainStage.setScene(new Scene(new FXMLLoader(HelloApplication.class.getResource("home.fxml")).load(), 1000, 800));
                } else {
                    notification.setText("Something went wrong. Try Again :(");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            notification.setText("New password is not as same as repeated password");
        }
    }

}
