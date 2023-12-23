package com.example.layeredarchitecture.bo.Custom.Impl;

import com.example.layeredarchitecture.bo.PlaceOrderBO;
import com.example.layeredarchitecture.dao.Custom.CustomerDAO;
import com.example.layeredarchitecture.dao.Custom.Impl.CustomerDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.ItemDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.OrderDaoImpl;
import com.example.layeredarchitecture.dao.Custom.Impl.OrderDetailDaoImpl;
import com.example.layeredarchitecture.dao.Custom.ItemDAO;
import com.example.layeredarchitecture.dao.Custom.OrderDAO;
import com.example.layeredarchitecture.dao.Custom.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    CustomerDAO customerDao = new CustomerDaoImpl();
    OrderDAO orderDao = new OrderDaoImpl();
    OrderDetailDAO orderDetailDao = new OrderDetailDaoImpl();
    ItemDAO itemDao = new ItemDaoImpl();


    @Override
    public boolean PlaceOrder(String orderId, LocalDate date, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/
        Connection connection = null;
        connection= DBConnection.getDbConnection().getConnection();

        //Check order id already exist or not

        boolean b1 = isExistsOrder(orderId);
        /*if order id already exist*/
        if (b1) {
            return false;
        }

        connection.setAutoCommit(false);

        //Save the Order to the order table
        boolean b2 = saveOrder(orderId,date,customerId);

        if (!b2) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


        // add data to the Order Details table

        for (OrderDetailDTO detail : orderDetails) {
            boolean b3 = orderDetailDao.saveOrderDetail(orderId,detail);
            if (!b3) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //Search & Update Item
            ItemDTO item = itemDao.findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            //update item
            boolean b = itemDao.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

            if (!b) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDao.generateNewOrderId();
    }

    @Override
    public boolean isExistsOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderDao.isExistsOrder(orderId);
    }

    @Override
    public boolean saveOrder(String orderID, LocalDate orderDate, String customerID) throws SQLException, ClassNotFoundException {
        return orderDao.saveOrder(orderID,orderDate,customerID);
    }
}
