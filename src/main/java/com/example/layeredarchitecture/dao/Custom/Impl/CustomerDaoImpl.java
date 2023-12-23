package com.example.layeredarchitecture.dao.Custom.Impl;


import com.example.layeredarchitecture.dao.Custom.CustomerDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        /*Get all customers*/
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//
//
//        while (rst.next()) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    rst.getString("id"),
//                    rst.getString("name"),
//                    rst.getString("address")
//            );
//            allCustomers.add(customerDTO);
//        }
//        return allCustomers;

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer" );
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            allCustomers.add(customer);
        }

        return allCustomers;

    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Customer (id,name,address) VALUES (?, ?, ?)",
                entity.getId(),entity.getName(),entity.getAddress());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
//        pstm.setString(1, customerDTO.getName());
//        pstm.setString(2, customerDTO.getAddress());
//        pstm.setString(3, customerDTO.getId());
//
//        return pstm.executeUpdate() > 0;

        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
                entity.getName(),entity.getAddress(),entity.getId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//
//        return pstm.executeUpdate() > 0;

        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",
                id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//
//        return pstm.executeQuery().next();

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
   @Override
    public Customer search(String newValue) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
//        pstm.setString(1, newValue + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//
//        return new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));

       ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue );
       rst.next();
       return new Customer(newValue + "", rst.getString("name"), rst.getString("address"));

    }
}
