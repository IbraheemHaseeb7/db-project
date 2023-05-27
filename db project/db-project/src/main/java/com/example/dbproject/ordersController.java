package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;

public class ordersController {
    @FXML
    VBox productsVbox;
    @FXML
    public void initialize() {
        try {

            String q = "select * from [ORDER]";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader row = new FXMLLoader(HelloApplication.class.getResource("orderRow.fxml"));
                Parent prow = row.load();

                orderRowController orc = row.getController();
                orc.oid.setText(res.getString("O_ID"));
                orc.cname.setText(res.getString("C_ID"));
                orc.status.setText(res.getString("O_STATUS"));
                orc.discount.setText(res.getString("O_DISCOUNT"));
                orc.total.setText(res.getString("O_ID"));

                productsVbox.getChildren().add(prow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
