package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class byQRowController {
    int q = 1;
    @FXML
    Text byQName, productId, quantity, price, totalPrice, givenQuantity;
    Text totalBill;
    VBox productsVbox;
    Parent comp;
    Product p = new Product();
    @FXML
    public void initialize() {
        p.id = productId.getText();
        p.name = byQName.getText();
        p.quantity = 1;
        p.price = Integer.parseInt(totalPrice.getText());
    }
    @FXML
    public void handleAdd() {
        q++;
        quantity.setText(q + "");
        totalPrice.setText((q *  Integer.parseInt(price.getText())) + "");

        p.quantity = q;
        p.price = Integer.parseInt(totalPrice.getText());
        totalBill.setText(placeOrderController.sumBill() + "");
    }
    @FXML
    public void handleSub() {
        q--;
        quantity.setText(q + "");
        totalPrice.setText((q *  Integer.parseInt(price.getText())) + "");

        p.quantity = q;
        p.price = Integer.parseInt(totalPrice.getText());
        totalBill.setText(placeOrderController.sumBill() + "");
    }
    @FXML
    public void handleDelete() {
        productsVbox.getChildren().remove(comp);
        placeOrderController.products.remove(p);
        totalBill.setText(placeOrderController.sumBill() + "");
    }
}
