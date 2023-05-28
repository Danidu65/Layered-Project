package dao;

import db.DBConnection;
import model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        return rs.next();
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDTO dto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)";
        return SQLUtil.execute(query, dto.getOrderId(), Date.valueOf(dto.getOrderDate()), dto.getCustomerId());
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }


}
