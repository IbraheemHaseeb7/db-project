package com.example.dbproject;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class homeController {

    @FXML
    ComboBox<String> statusComboBox;

    @FXML
    public void initialize() {
        statusComboBox = new ComboBox<String>();
        statusComboBox.getItems().removeAll(statusComboBox.getItems());
        statusComboBox.getItems().addAll("completed", "payment due");
        statusComboBox.setStyle("-fx-prompt-text-fill: #fff");

    }
}
