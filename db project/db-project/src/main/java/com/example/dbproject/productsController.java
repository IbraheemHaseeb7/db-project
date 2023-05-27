package com.example.dbproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;

public class productsController {

    @FXML
    VBox productsVbox;

    @FXML
    public void initialize() {
        loadAllProducts();
    }
    @FXML
    protected void sortByUnitSellingCost() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_PRICE";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByUnitPurchaseCost() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_PURCHASE";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByProductName() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_NAME";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByProductId() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_ID";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByAvailableAmount() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_QUANTITY";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByProductType() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_TYPE";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sortByWeightQuantity() {
        clearAllProducts();

        try {
            String q = "select * from PRODUCT p order by p.P_WEIGHT";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAllProducts() {
        productsVbox.getChildren().clear();
    }
    public void loadAllProducts() {
        try {
            String q = "select * from PRODUCT";
            ResultSet res = HelloApplication.statement.executeQuery(q);

            while (res.next()) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("productRow.fxml"));
                Parent row = loader.load();

                productRowController prc = loader.getController();
                prc.productId.setText(res.getString("P_ID"));
                prc.productName.setText(res.getString("P_NAME"));
                prc.productType.setText(res.getString("P_TYPE").equals("W") ? "By Weight": "By Quantity");
                prc.unitPurchaseCost.setText(res.getString("P_PURCHASE"));
                prc.unitSellingCost.setText(res.getString("P_PRICE"));
                prc.weightQuantity.setText(res.getString("P_WEIGHT"));
                prc.availableAmount.setText(res.getString("P_QUANTITY"));
                prc.moreDetails.setId(res.getString("P_ID"));

                productsVbox.getChildren().add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
