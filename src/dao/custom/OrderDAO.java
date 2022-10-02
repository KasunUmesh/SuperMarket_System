package dao.custom;

import javafx.collections.ObservableList;
import dto.ItemDetails;
import dto.Order;
import views.tm.OrderDetailTM;
import views.tm.OrderTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDAO {

    public String getOrderId() throws SQLException, ClassNotFoundException;
    public boolean placeOrder(Order order);
    public boolean saveOrderDetail(String orderId, ArrayList<ItemDetails> items) throws SQLException, ClassNotFoundException;
    public boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException;
    public ObservableList<OrderDetailTM> getAllOrderDetail(String orderId) throws SQLException, ClassNotFoundException;
    public ArrayList<OrderTM> getAllOrders() throws SQLException, ClassNotFoundException;
}
