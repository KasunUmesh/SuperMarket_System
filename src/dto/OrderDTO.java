package dto;

import java.util.ArrayList;

public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String custId;
    private double cost;
    private ArrayList<OrderDetailsDTO> items;

    public OrderDTO() {

    }

    public OrderDTO(String orderId, String orderDate, String custId, double cost, ArrayList<OrderDetailsDTO> items) {
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

    public ArrayList<OrderDetailsDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderDetailsDTO> items) {
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
