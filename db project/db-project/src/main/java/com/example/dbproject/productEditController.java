package com.example.dbproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class productEditController {
    @FXML
    Text heading;
    @FXML
    TextField name, unitPrice, unitCost, weight, presetValue;
    Stage editStage;
    @FXML
    ComboBox<String> type;
    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("By Weight");
        list.add("By Quantity");

        type.setItems(list);
    }
    @FXML
    public void handleSubmitChanges() {
        try {
            String q = "update PRODUCT set P_NAME='" + name.getText() + "', P_PURCHASE=" + unitCost.getText() + ", P_PRICE=" + unitPrice.getText() + ", P_WEIGHT=" + weight.getText() + ", P_TYPE=" + ((type.getValue() == null ? type.getPromptText() : type.getValue()).equals("By Weight") ? "'W'" : "'Q'") + " where P_NAME='" + name.getText() + "'";
            int row = HelloApplication.statement.executeUpdate(q);

            if (row == 1) {
                editStage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
