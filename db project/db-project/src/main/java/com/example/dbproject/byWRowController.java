package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.function.Function;

public class byWRowController {
    @FXML
    Text byQName1, productId, price, totalPrice, amount, weight;
    double am;
    double unitAmount;
    @FXML
    TextField priceInput, weightInput;

    VBox productsVbox;
    Parent comp;
    Product p;
    @FXML
    public void handleDelete() {
        productsVbox.getChildren().remove(comp);
    }
    @FXML
    public void handlePrice() {
        String typed = priceInput.getText();
        am = Integer.parseInt(typed);
        am = (am / Integer.parseInt(price.getText())) * unitAmount;
        amount.setText(am + "");
        totalPrice.setText(typed);
        weightInput.setText("");
    }
    @FXML
    public void handleWeight() {
        String typed = weightInput.getText();
        am = Integer.parseInt(typed);
        am = am / unitAmount * Integer.parseInt(price.getText());
        amount.setText(typed);
        totalPrice.setText(am + "");
        priceInput.setText("");
    }
}
