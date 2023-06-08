package com.example.dbproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;

public class purchaseRecordsRowController {
    @FXML
    Text purchaseId, supplierName, totalProducts, paymentMethod, employee, totalAmount, date;
    @FXML
    Button moreDetails, delete, edit;
    VBox purchaseVbox;
    Parent row;
    String presetValue = "";
    @FXML
    protected void handleMoreDetails(ActionEvent e) throws IOException {
        String pid = ((Button)e.getSource()).getId();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("purchaseRecordsMoreDetails.fxml"));
        Parent page = loader.load();
        String stageTitle = "";

        purchaseRecordsMoreDetailsController pmdc = loader.getController();

        try {
            String q = "select PUR_QUANTITY, PUR_PRICE,  \n" +
                    "(select P_NAME from PRODUCT p where p.P_ID=pd.P_ID) as P_NAME\n" +
                    "from [PRO_PUR] pd where PUR_ID='" + pid + "'";
            ResultSet res = HelloApplication.statement.executeQuery(q);


            while (res.next()) {
                FXMLLoader load = new FXMLLoader(HelloApplication.class.getResource("purchaseRecordsMoreDetailsRow.fxml"));
                Parent root = load.load();

                purchaseRecordsMoreDetailsRowController prmdr = load.getController();
                prmdr.name.setText(res.getString("P_NAME"));
                prmdr.price.setText(res.getString("PUR_PRICE"));
                prmdr.quantity.setText(res.getString("PUR_QUANTITY"));

                pmdc.productsVbox.getChildren().add(root);
            }

            res.next();

            pmdc.purchaseId.setText(pid);

            stageTitle = pid;

        } catch (Exception er) {
            er.printStackTrace();
        }


        Stage moreDetailsStage = new Stage();
        moreDetailsStage.setScene(new Scene(page));
        moreDetailsStage.setTitle(stageTitle);
        moreDetailsStage.setResizable(false);
        moreDetailsStage.show();
    }
}
