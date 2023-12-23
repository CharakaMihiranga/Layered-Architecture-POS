package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.Custom.Impl.OrderDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.OrderDetailDaoImpl;
import com.example.layeredarchitecture.dao.Custom.OrderDAO;
import com.example.layeredarchitecture.dao.Custom.OrderDetailDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderBOImpl implements PlaceOrderBO{
    OrderDAO orderDAO = new OrderDaoImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDaoImpl();


    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean isExistsOrder(String orderId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrder(String orderID, LocalDate orderDate, String customerID) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return false;
    }
}
