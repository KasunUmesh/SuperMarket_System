package entity;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String orderDate;
    private String custId;
    private double cost;
    private ArrayList<OrderDetails> items;

    public Order() {

    }

    public Order(String orderId, String orderDate, String custId, double cost, ArrayList<OrderDetails> items) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.cost = cost;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<OrderDetails> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderDetails> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", custId='" + custId + '\'' +
                ", cost=" + cost +
                ", items=" + items +
                '}';
    }
}
