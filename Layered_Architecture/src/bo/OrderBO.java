package bo;

import model.ItemDTO;
import model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO {
    public ArrayList<OrderDTO> getAllOrder() throws SQLException, ClassNotFoundException;
    public boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    public boolean existOrder(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException;
}
