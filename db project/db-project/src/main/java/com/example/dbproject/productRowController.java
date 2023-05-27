package com.example.dbproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class productRowController {
    @FXML
    Text productId, productName, unitPurchaseCost, unitSellingCost, availableAmount, weightQuantity, productType;
    @FXML
    Button moreDetails;
    @FXML
    protected void handleMoreDetails(ActionEvent e) throws IOException {
        String pid = ((Button)e.getSource()).getId();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productMoreDetails.fxml"));
        Parent page = loader.load();
        String stageTitle = "";

        productMoreDetailsController pmdc = loader.getController();

        try {
            String q = "select * from PRODUCT p where p.P_ID='" + pid + "'";
            ResultSet res = HelloApplication.statement.executeQuery(q);
            res.next();

            pmdc.productId.setText(res.getString("P_ID"));
            pmdc.productName.setText(res.getString("P_NAME"));
            pmdc.productNameHeading.setText(res.getString("P_NAME"));
            pmdc.availableQuantity.setText(res.getString("P_QUANTITY"));
            pmdc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
            pmdc.unitSellingCost.setText(res.getString("P_PRICE"));
            pmdc.productSoldBy.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
            pmdc.supplier.setText(res.getString("P_ID"));
            pmdc.supplierPhone.setText(res.getString("P_ID"));
            pmdc.timesSold.setText(res.getString("P_ID"));
            pmdc.revenueGenerated.setText(res.getString("P_ID"));

            stageTitle = res.getString("P_NAME");

        } catch (Exception er) {
            er.printStackTrace();
        }


        Stage moreDetailsStage = new Stage();
        moreDetailsStage.setScene(new Scene(page));
        moreDetailsStage.setTitle(stageTitle);
        moreDetailsStage.show();
    }
}
