package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.bo.Custom.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.Custom.Impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.Custom.Impl.PlaceOrderBOImpl;
import com.example.layeredarchitecture.bo.Custom.Impl.QueryBOImpl;
import com.example.layeredarchitecture.bo.SuperBO;

public class FactoryBO {
    private static FactoryBO factoryBO;
    private FactoryBO(){}
    public static FactoryBO getBoFactory(){
        return (factoryBO == null) ? factoryBO
                = new FactoryBO() : factoryBO;
    }

    public enum BOTypes {
        CUSTOMERBO,ITEMBO,PLACEORDERBO,QUERY
    }

    public SuperBO getBO (BOTypes boTypes){
        switch (boTypes){
            case CUSTOMERBO:
                return new CustomerBOImpl();
            case ITEMBO:
                return new ItemBOImpl();
            case PLACEORDERBO:
                return new PlaceOrderBOImpl();
            case QUERY:
                return new QueryBOImpl();
            default:
                return null;
        }
    }
}
