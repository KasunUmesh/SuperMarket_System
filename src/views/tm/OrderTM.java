package views.tm;

public class OrderTM {
    private String orderId;
    private String customerId;
    private String date;

    public OrderTM() {
    }

    public OrderTM(String orderId, String customerId, String date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
    }

    public static void add(OrderTM orderTM) {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
