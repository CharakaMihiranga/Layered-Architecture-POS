package com.example.layeredarchitecture.dao.Custom.Impl;

import com.example.layeredarchitecture.dao.Custom.QueryDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDaoImpl implements QueryDAO {

    @Override
    public ArrayList<OrderDTO> getOrderDetail() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT\n" +
                "    o.oid AS OrderID,\n" +
                "    o.date AS OrderDate,\n" +
                "    o.customerID AS CustomerID,\n" +
                "    c.name AS CustomerName,\n" +
                "    SUM(od.qty * od.unitPrice) AS OrderTotal\n" +
                "FROM\n" +
                "    Orders o\n" +
                "JOIN\n" +
                "    Customer c ON o.customerID = c.id\n" +
                "JOIN\n" +
                "    OrderDetails od ON o.oid = od.oid\n" +
                "GROUP BY\n" +
                "    o.oid, o.date, o.customerID, c.name;\n");
        ArrayList<OrderDTO> allOrders = new ArrayList<>();
        while (rst.next()) {
            OrderDTO orderDTO = new OrderDTO(
                    rst.getString("OrderID"),
                    rst.getDate("OrderDate").toLocalDate(),
                    rst.getString("CustomerID"),
                    rst.getString("CustomerName"),
                    rst.getBigDecimal("OrderTotal")
            );
            allOrders.add(orderDTO);
        }
        return allOrders;
    }
}
