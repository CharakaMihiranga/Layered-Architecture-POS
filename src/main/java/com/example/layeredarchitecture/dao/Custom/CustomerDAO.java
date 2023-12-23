package com.example.layeredarchitecture.dao.Custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.model.CustomerDTO;

public interface CustomerDAO extends CrudDAO<Customer> {
    //using for Store unique Methods of CustomerDaoImpl

}
