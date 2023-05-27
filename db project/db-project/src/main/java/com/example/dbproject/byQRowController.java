package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class byQRowController {
    int q = 1;
    @FXML
    Text byQName, productId, quantity, price, totalPrice;
    VBox productsVbox;
    Parent comp;
    @FXML
    public void handleAdd() {
        q++;
        quantity.setText(q + "");
        totalPrice.setText((q *  Integer.parseInt(price.getText())) + "");
    }
    @FXML
    public void handleSub() {
        q--;
        quantity.setText(q + "");
        totalPrice.setText((q *  Integer.parseInt(price.getText())) + "");
    }
    @FXML
    public void handleDelete() {
        productsVbox.getChildren().remove(comp);
    }
}
