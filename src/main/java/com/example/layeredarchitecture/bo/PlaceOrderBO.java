package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface PlaceOrderBO {
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;
    public boolean isExistsOrder(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(String orderID, LocalDate orderDate, String customerID) throws SQLException, ClassNotFoundException;
    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;


}
