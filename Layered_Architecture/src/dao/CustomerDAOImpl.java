package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean add(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        System.out.println(dto.getId()+ dto.getName()+ dto.getAddress());
        String query = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        return SQLUtil.execute(query, dto.getId(), dto.getName(), dto.getAddress());
    }
    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        String query = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return SQLUtil.execute(query, dto.getName(), dto.getAddress(), dto.getId());
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        String query = "SELECT id FROM Customer WHERE id=?";
        ResultSet rs = SQLUtil.execute(query, id);
        return rs.next();
    }
    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
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
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM Customer WHERE id=?";
        return SQLUtil.execute(query, id);
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }

}
