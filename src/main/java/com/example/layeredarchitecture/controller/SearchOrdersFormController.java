package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.bo.Custom.Impl.QueryBOImpl;
import com.example.layeredarchitecture.bo.CustomerBO;
import com.example.layeredarchitecture.bo.QueryBO;
import com.example.layeredarchitecture.dao.Custom.Impl.OrderDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.QueryDaoImpl;
import com.example.layeredarchitecture.dao.Custom.QueryDAO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.FactoryBO;
import com.example.layeredarchitecture.entity.Search;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.SearchDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrdersFormController {

    @FXML
    private Label unitPrice;
    @FXML
    private Label lblQty;
    @FXML
    private Label itemCode;
    @FXML
    private Label cusId;

    @FXML
    private Label cusName;

    @FXML
    private Label orderDate;

    @FXML
    private Label orderTotal;

    @FXML
    private ComboBox orderID;

    @FXML
    private AnchorPane root;
    QueryBO queryBO = (QueryBO) FactoryBO.getBoFactory().getBO(FactoryBO.BOTypes.QUERY);


    ArrayList<Search> allOrderDetails= new ArrayList<>();

    public void initialize(){
        loadAllOrderIds();
    }

    private void loadAllOrderIds() {
        try {
             allOrderDetails = queryBO.getOrderDetail();

            for (Search dto : allOrderDetails ) {
                orderID.getItems().add(dto.getOrderId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void cmbOnAction(ActionEvent actionEvent) {
        String cmdId = (String) orderID.getValue();

        for (int i = 0; i < allOrderDetails.size(); i++) {
            if (allOrderDetails.get(i).getOrderId() == cmdId){

                cusId.setText(allOrderDetails.get(i).getCustomerId());
                cusName.setText(allOrderDetails.get(i).getCustomerName());
                orderDate.setText(String.valueOf(allOrderDetails.get(i).getOrderDate()));
                orderTotal.setText(String.valueOf(allOrderDetails.get(i).getOrderTotal()));
                itemCode.setText(String.valueOf(allOrderDetails.get(i).getItemCode()));
                lblQty.setText(String.valueOf(allOrderDetails.get(i).getQty()));
                unitPrice.setText(String.valueOf(allOrderDetails.get(i).getUnitPrice()));

            }
        }

    }
}
