package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dto.OrderDetailsDTO;
import dto.OrderDTO;
import views.tm.OrderDetailTM;
import views.tm.OrderTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String getOrderId() throws SQLException, ClassNotFoundException {

        /*ResultSet rst = CrudUtil.executeQuery("SELECT orderId FROM `Order` ORDER BY orderId DESC LIMIT 1");

        if (rst.next()){

            int tempId = Integer.parseInt(rst.getString(1).split("-")[1]);

            tempId=tempId+1;
            if (tempId<9){
                return "O-00"+tempId;
            }else if (tempId<99){
                return "O-0"+tempId;
            }else {
                return "O-"+tempId;
            }

        }else {
            return "O-001";
        }*/

        return null;
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO){
       /* try {

            boolean addOrder = CrudUtil.executeUpdate("INSERT INTO `Order` VALUE (?,?,?,?)",

                    orderDTO.getOrderId(),
                    orderDTO.getOrderDate(),
                    orderDTO.getCustId(),
                    orderDTO.getCost()

            );

            if (addOrder){

                return saveOrderDetail(orderDTO.getOrderId(), orderDTO.getItems());

            }else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;*/

        return true;

    }


    @Override
    public boolean saveOrderDetail(String orderId, ArrayList<OrderDetailsDTO> items) throws SQLException, ClassNotFoundException {
       /* for (OrderDetailsDTO temp: items
             ) {

            boolean orderDetail = CrudUtil.executeUpdate("INSERT INTO `Order Detail` VALUES(?,?,?,?)",

                    orderId,
                    temp.getItemCode(),
                    temp.getOrderQty(),
                    temp.getDprice()
            );

            if (orderDetail){

                if (updateQty(temp.getItemCode(), temp.getOrderQty())){

                }else {
                    return false;
                }

            }else {
                return false;
            }


        }
        return true;*/

        return true;
    }

    @Override
    public boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException {

//        return CrudUtil.executeUpdate("UPDATE Item SET qtyOnHand=(qtyOnHand-" + qty + ") WHERE itemCode='" + itemCode + "'");

        return true;

    }

    @Override
    public ObservableList<OrderDetailTM> getAllOrderDetail(String orderId) throws SQLException, ClassNotFoundException {

        /*ResultSet resultSet = CrudUtil.executeQuery(
                "SELECT i.itemCode, i.orderQty, i.dPrice, o.cost FROM `order detail` i JOIN `order` o ON o.orderId=i.orderId WHERE i.orderId = '" + orderId + "'");

        ObservableList<OrderDetailTM> orderDetail = FXCollections.observableArrayList();
        while (resultSet.next()){
            orderDetail.add(new OrderDetailTM(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4)
            ));
        }
        return orderDetail;*/

        return null;

    }

    @Override
    public ArrayList<OrderTM> getAllOrders() throws SQLException, ClassNotFoundException {

        /*ArrayList<OrderTM> order = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `Order`");

        while (rst.next()){
            order.add(new OrderTM(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));
        }
        return order;*/

        return null;
    }
}
