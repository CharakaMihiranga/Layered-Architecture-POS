package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.Custom.Impl.OrderDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.QueryDaoImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrdersFormController {

    @FXML
    private ComboBox orderID;
    @FXML
    private AnchorPane root;

    QueryDaoImpl queryDao = new QueryDaoImpl();

    public void initialize(){
        loadAllOrderIds();
    }

    private void loadAllOrderIds() {
        try {
            ArrayList<OrderDTO> allOrders = queryDao.getOrderDetail();

            for (OrderDTO dto : allOrders ) {
                orderID.getItems().add(dto.getOrderId());
                System.out.println("Order ID : " + dto.getOrderId());
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
    }
}
