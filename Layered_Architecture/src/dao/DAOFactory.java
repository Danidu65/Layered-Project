package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return (SuperDAO) new dao.custom.impl.CustomerDAOImpl();
            case ITEM:
                return (SuperDAO) new dao.custom.impl.ItemDAOImpl();
            case ORDER:
                return (SuperDAO) new dao.custom.impl.OrderDAOImpl();
            case ORDER_DETAILS:
                return (SuperDAO) new dao.custom.impl.OrderDetailsDAOImpl();
            case QUERY_DAO:
                return (SuperDAO) new dao.custom.impl.QueryDAOImpl();
            default:
                return null;
        }
    }


}
