package com.example.dbproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class homeController {

    @FXML
    ComboBox<String> statusComboBox;
    @FXML
    public Button orders;
    @FXML
    Button inStock;

    @FXML
    BorderPane homeBorderPane = new BorderPane();
    @FXML
    VBox productsVbox;

    @FXML
    public void initialize() {
        statusComboBox = new ComboBox<String>();
        statusComboBox.getItems().removeAll(statusComboBox.getItems());
        statusComboBox.getItems().addAll("completed", "payment due");
        statusComboBox.setStyle("-fx-prompt-text-fill: #fff");
    }
    @FXML
    protected void handleOption(ActionEvent e) throws IOException {
        String opt = ((Button)e.getSource()).getId();
        switch (opt) {
            case "orders":
                homeBorderPane.setCenter(new FXMLLoader(HelloApplication.class.getResource("orders.fxml")).load());
                break;
            case "inStock":
                homeBorderPane.setCenter(new FXMLLoader(HelloApplication.class.getResource("products.fxml")).load());
                break;
            case "sale":
                homeBorderPane.setCenter(new FXMLLoader(HelloApplication.class.getResource("placeOrder.fxml")).load());
        }
    }
}
