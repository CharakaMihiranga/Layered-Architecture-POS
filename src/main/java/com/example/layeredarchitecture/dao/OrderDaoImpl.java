package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public class OrderDaoImpl implements OrderDAO {

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

    }
    @Override
    public boolean isExistsOrder(String orderId) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        pstm.setString(1, orderId);
        ResultSet rst = pstm.executeQuery();

        return rst.next();
    }
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        pstm.setString(1,orderDTO.getOrderId());
        pstm.setDate(2, Date.valueOf(orderDTO.getOrderDate()));
        pstm.setString(3, orderDTO.getCustomerId());

        return pstm.executeUpdate() > 0;
    }

}
