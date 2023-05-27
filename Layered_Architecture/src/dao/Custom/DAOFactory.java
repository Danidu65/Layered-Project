package dao.custom;

import dao.CustomerDAOImpl;
import dao.ItemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTyeps{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }
    public ItemDAOImpl getDAO (DAOTyeps tyeps){
        switch (tyeps){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
        }
        return null;
    }
}
