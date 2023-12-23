package com.example.layeredarchitecture.dao.Custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetail> {
    public boolean saveOrderDetail(String orderId, OrderDetail orderDetailDTO) throws SQLException, ClassNotFoundException;
}
