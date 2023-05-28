package dao;

import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM Item WHERE code=?";
        return SQLUtil.execute(query, code);
    }

    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        return SQLUtil.execute(query, dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        String query = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return SQLUtil.execute(query, dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT code FROM Item WHERE code=?", code);
        return rs.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?", code + "");
        rst.next();
        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }


}
