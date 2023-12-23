package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.Custom.Impl.CustomerDaoImpl;

public class DAOFactory {
    //singleton

    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory
                = new DAOFactory() : daoFactory;
    }

}
