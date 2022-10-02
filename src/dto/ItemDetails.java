package dto;

public class ItemDetails {
    private String orderId;
    private String itemCode;
    private int orderQty;
    private double dprice;

    public ItemDetails() {

    }

    public ItemDetails(String orderId, String itemCode, int orderQty, double dprice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.dprice = dprice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getDprice() {
        return dprice;
    }

    public void setDprice(double dprice) {
        this.dprice = dprice;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", orderQty=" + orderQty +
                ", dprice=" + dprice +
                '}';
    }
}
