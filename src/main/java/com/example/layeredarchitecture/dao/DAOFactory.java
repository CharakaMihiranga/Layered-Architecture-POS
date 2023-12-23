package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.SuperDAO;
import com.example.layeredarchitecture.dao.Custom.Impl.*;

public class DAOFactory {
    //singleton

    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory
                = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            case QUERY:
                return new QueryDaoImpl();
            default:
                return null;
        }
    }

}
