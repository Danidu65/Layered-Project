package bo;

import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailsBO {
    public ArrayList<OrderDetailDTO> getAllOrderDetail() throws SQLException, ClassNotFoundException;
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;
    public OrderDetailDTO searchOrderDetail(String id) throws SQLException, ClassNotFoundException;
}
