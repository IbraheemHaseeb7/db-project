package com.example.dbproject;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.textfield.TextFields;

import java.sql.ResultSet;
import java.util.ArrayList;

public class placeOrderController {
    @FXML
    ComboBox searchComboBox;
    @FXML
    VBox productsVbox, productsVbox1;
    @FXML
    public Text amountPaid, discount, totalBill, totalBillAfterDiscount, returnAmount;
    @FXML
    TextField discountInput, customerPhoneNoInput, customerNameInput, amountPaidInput;
    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList();
        try {
          String q = "select * from PRODUCT";
          ResultSet res = HelloApplication.statement.executeQuery(q);

          while (res.next()) {
              items.add(res.getString("P_NAME"));
          }

        } catch (Exception e) {
            e.printStackTrace();
        }


        FilteredList<String> filteredItems = new FilteredList<String>(items, p -> true);
        searchComboBox.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = searchComboBox.getEditor();
            final String selected = (String)searchComboBox.getSelectionModel().getSelectedItem();
            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });

        searchComboBox.setItems(filteredItems);

    }

    public static ArrayList<Product> products = new ArrayList<>();

    @FXML
    public void handleSelection(ActionEvent e) {
        String typed = searchComboBox.getValue().toString();
        addInVbox(typed);
    }

    @FXML
    public void handleSearch() {
        String typed = searchComboBox.getValue().toString();
        addInVbox(typed);
    }
    @FXML
    public void handleCustomerName() {

    }
    @FXML
    public void handleAmountPaid() {
        amountPaid.setText(amountPaidInput.getText());
    }
    @FXML
    public void handleCustomerPhoneNo() {

    }
    @FXML
    public void handleDiscount() {

    }
    public void addInVbox(String typed) {
        try {
            String q = "select * from PRODUCT p where p.P_NAME='" + typed + "'";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            res.next();

            if (res.getString("P_TYPE").equals("Q")) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("byQRow.fxml"));
                Parent comp = loader.load();

                byQRowController bqrc = loader.getController();
                bqrc.productsVbox = productsVbox;
                bqrc.comp = comp;
                bqrc.byQName.setText(res.getString("P_NAME"));
                bqrc.productId.setText(res.getString("P_ID"));
                bqrc.quantity.setText("1");
                bqrc.price.setText(res.getString("P_PRICE"));
                bqrc.totalPrice.setText(res.getString("P_PRICE"));
                bqrc.givenQuantity.setText(res.getString("P_WEIGHT"));
                bqrc.totalBill = totalBill;

                products.add(new Product());
                bqrc.p = products.get(products.size() - 1);

                bqrc.p.name = res.getString("P_NAME");
                bqrc.p.id = res.getString("P_ID");
                bqrc.p.price = Integer.parseInt(res.getString("P_PRICE"));
                bqrc.p.quantity = 1;

                totalBill.setText(sumBill() + "");

                productsVbox.getChildren().add(comp);
            } else {

                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("byWRow.fxml"));
                Parent comp = loader.load();

                byWRowController bwrc = loader.getController();
                bwrc.comp = comp;
                bwrc.productsVbox = productsVbox1;
                bwrc.byQName1.setText(res.getString("P_NAME"));
                bwrc.productId.setText(res.getString("P_ID"));
                bwrc.price.setText(res.getString("P_PRICE"));
                bwrc.amount.setText("0");
                bwrc.unitAmount = Integer.parseInt(res.getString("P_WEIGHT"));
                bwrc.totalPrice.setText("0");
                bwrc.weight.setText(res.getString("P_WEIGHT"));

                products.add(new Product());
                bwrc.p = products.get(products.size() - 1);

                productsVbox1.getChildren().add(comp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double sumBill() {
        double sum = 0;
        for (Product p : products) {
            sum += p.price;
        }
        return sum;
    }
}
