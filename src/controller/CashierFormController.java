package controller;

import bo.custom.CustomerBO;
import bo.custom.impl.CustomerBOImpl;
import bo.custom.ItemBO;
import bo.custom.impl.ItemBOImpl;
import dao.custom.OrderDAO;
import dao.custom.impl.OrderDAOImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import dto.Customer;
import dto.Item;
import dto.ItemDetails;
import dto.Order;
import views.tm.CartTm;
import views.tm.CustomerTM;
import views.tm.OrderDetailTM;
import views.tm.OrderTM;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CashierFormController {

    public AnchorPane cashier;
    public Label lblDate;
    public Label lblTime;
    
    public TextField txtcID;
    public TextField txtcTitle;
    public TextField txtcName;
    public TextField txtcAddress;
    public TextField txtCity;
    public TextField txtcdProvince;
    public TextField txtcdPostalCode;
    
    public TableView<CustomerTM> tblCustomerDetails;
    public TableColumn colID;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostalCode;

    public ComboBox<String> cmbCustomerID;
    public ComboBox<String> cmbItemCode;
   
    public TextField txtOrderCustName;
    public TextField txtOrderCustAddress;
    public TextField txtOrderCustCity;
    
    public TextField txtOrderDescription;
    public TextField txtOrderPackSize;
    public TextField txtOrderQTYOnHand;
    public TextField txtOrderUnitPrice;
    public TextField txtOrderQTY;
    
    public TableView<CartTm> tblAddListTable;
    public TableColumn colListItemCode;
    public TableColumn colListDescription;
    public TableColumn colListQTY;
    public TableColumn colListUnitPrice;
    public TableColumn colListTotal;
    public Label txtttl;
    public Label lblOrderId;
    
    public TableView<OrderTM> tblOrders;
    public TableColumn colOrderId;
    public TableColumn colOrderCustId;
    public TableColumn colOrderDate;
    
    public TableView<OrderDetailTM> tblOrderDetails;
    public TableColumn colItemCode;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;


    CustomerTM selectedCustomer = null;

    int cartSelectedRowForRemove = -1;

    private OrderDAO order = new OrderDAOImpl();

    private CustomerBO customer = new CustomerBOImpl();
    private ItemBO item = new ItemBOImpl();


    public void initialize(){

        colListItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colListDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colListQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colListUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colListTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));




        try {

            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

            colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            colOrderCustId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            colOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));

            loadAllOrder(order.getAllOrders());
            setCustomerToTable(customer.getAllCustomer());
            loadCustomerIds();
            loadItemCodes();
            setOrderId();

            tblCustomerDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue!=null){
                    selectedCustomer = newValue;
                }
            });

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            try {

                setCustomerData(newValue);

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {

                setItemData(newValue);

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        tblAddListTable.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });

        tblOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {

                setOrderDetailToTable(newValue.getOrderId());

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        loadDateAndTime();

    }

    private void setOrderDetailToTable(String orderId) throws SQLException, ClassNotFoundException {

        ObservableList<OrderDetailTM> orderDetail = order.getAllOrderDetail(orderId);

        tblOrderDetails.setItems(orderDetail);
    }

    private void loadAllOrder(ArrayList<OrderTM> order) throws SQLException, ClassNotFoundException {
        ObservableList<OrderTM> obList = FXCollections.observableArrayList();
        order.forEach(o -> {
            obList.add(new OrderTM(o.getOrderId(),o.getCustomerId(),o.getDate()));
        });
        tblOrders.setItems(obList);


    }

    private void setOrderId() throws SQLException, ClassNotFoundException {
        lblOrderId.setText(order.getOrderId());

    }

    private void setItemData(String itemId) throws SQLException, ClassNotFoundException {

        Item i1 = item.searchItem(itemId);
        if (i1 == null) {

            new Alert(Alert.AlertType.WARNING, "Empty Result Set");

        } else {
           txtOrderDescription.setText(i1.getDescription());
           txtOrderPackSize.setText(i1.getPackSize());
           txtOrderQTYOnHand.setText(String.valueOf(i1.getQtyOnHand()));
           txtOrderUnitPrice.setText(String.valueOf(i1.getUnitPrice()));

        }
    }

    private void setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        Customer c1 = customer.searchCustomer(customerId);
        if (c1 == null) {

            new Alert(Alert.AlertType.WARNING, "Empty Result Set");

        } else {
            txtOrderCustName.setText(c1.getName());
            txtOrderCustAddress.setText(c1.getAddress());
            txtOrderCustCity.setText(c1.getCity());

        }

    }

    private void loadItemCodes() throws SQLException, ClassNotFoundException {

        List<String> allItemCodes = item.getAllItemCodes();
        cmbItemCode.getItems().addAll(allItemCodes);
    }

    private void loadCustomerIds() throws SQLException, ClassNotFoundException {

        List<String> customerIds = customer.getCustomerIds();
        cmbCustomerID.getItems().addAll(customerIds);

    }

    private void setCustomerToTable(ArrayList<Customer> customers){
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(new CustomerTM(e.getId(),e.getTitle(),e.getName(),e.getAddress(),e.getCity(),e.getProvince(),e.getPostalCode()));
        });
        tblCustomerDetails.setItems(obList);
    }


    public void tbBackButton(Event event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/DashBoardForm.fxml"));
        Scene scene = new Scene(parent);

        Stage primaryStage = (Stage) this.cashier.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer c1 = new Customer(
                txtcID.getText(),
                txtcTitle.getText(),
                txtcName.getText(),
                txtcAddress.getText(),
                txtCity.getText(),
                txtcdProvince.getText(),
                txtcdPostalCode.getText()
        );
        if (customer.addCustomer(c1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

            txtcID.clear();
            txtcTitle.clear();
            txtcName.clear();
            txtcAddress.clear();
            txtCity.clear();
            txtcdProvince.clear();
            txtcdPostalCode.clear();
            txtcID.requestFocus();

            setCustomerToTable(customer.getAllCustomer());

        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();

            txtcID.clear();
            txtcTitle.clear();
            txtcName.clear();
            txtcAddress.clear();
            txtCity.clear();
            txtcdProvince.clear();
            txtcdPostalCode.clear();
            txtcID.requestFocus();
        }
        
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour()+ " : "+currentTime.getMinute()+" : "+currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String customerId = txtcID.getText();

        Customer c1 = customer.searchCustomer(customerId);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }else {
            setData(c1);
        }

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer c1 = new Customer(
                txtcID.getText(),
                txtcTitle.getText(),
                txtcName.getText(),
                txtcAddress.getText(),
                txtCity.getText(),
                txtcdProvince.getText(),
                txtcdPostalCode.getText()
        );


        if ( customer.updateCustomer(c1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
            setCustomerToTable(customer.getAllCustomer());

            txtcID.clear();
            txtcTitle.clear();
            txtcName.clear();
            txtcAddress.clear();
            txtCity.clear();
            txtcdProvince.clear();
            txtcdPostalCode.clear();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (selectedCustomer!=null){
            if (customer.deleteCustomer(selectedCustomer.getId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();

                setCustomerToTable(customer.getAllCustomer());

                txtcID.clear();
                txtcTitle.clear();
                txtcName.clear();
                txtcAddress.clear();
                txtCity.clear();
                txtcdProvince.clear();
                txtcdPostalCode.clear();


            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }

        }
    }

    void setData(Customer c){
        txtcID.setText(c.getId());
        txtcTitle.setText(c.getTitle());
        txtcName.setText(c.getName());
        txtcAddress.setText(c.getAddress());
        txtCity.setText(c.getCity());
        txtcdProvince.setText(c.getProvince());
        txtcdPostalCode.setText(c.getPostalCode());
    }

    ObservableList<CartTm> obList = FXCollections.observableArrayList();
    public void btnAddListOnAction(ActionEvent actionEvent) {

        String description = txtOrderDescription.getText();
        int qtyOnHand = Integer.parseInt(txtOrderQTYOnHand.getText());
        double unitPrice = Double.parseDouble(txtOrderUnitPrice.getText());
        int qtyForCustomer = Integer.parseInt(txtOrderQTY.getText());
        double total = qtyForCustomer * unitPrice;
        int nowQtyOnHand = qtyOnHand - qtyForCustomer;

        if (qtyOnHand<qtyForCustomer) {
            new Alert(Alert.AlertType.WARNING,"Invalid QTY").show();
            return;
        }

        CartTm tm = new CartTm(
                cmbItemCode.getValue(),
                description,
                qtyForCustomer,
                unitPrice,
                total
        );

        int rowNumber = isExists(tm);

        if (rowNumber==-1){
            obList.add(tm);

        }else {

            CartTm temp = obList.get(rowNumber);
            CartTm newTm = new CartTm(
                    temp.getItemCode(),
                    temp.getDescription(),
                    temp.getQty()+qtyForCustomer,
                    unitPrice,
                    total+temp.getTotal()
            );



            obList.remove(rowNumber);
            obList.add(newTm);
        }

        txtOrderQTYOnHand.setText(String.valueOf(nowQtyOnHand));


        tblAddListTable.setItems(obList);

        calculateCost();

        txtOrderQTY.clear();
    }
    
    private int isExists(CartTm tm){

        for (int i = 0; i < obList.size(); i++){
            if (tm.getItemCode().equals(obList.get(i).getItemCode())){
                return i;
            }
        }
        return -1;

    }
    void calculateCost(){
        double ttl = 0;
        for (CartTm tm: obList
             ) {
            ttl+=tm.getTotal();
        }
        txtttl.setText(ttl+" /=");
    }

    public void tblItemClearOnAction(ActionEvent actionEvent) {
        if (cartSelectedRowForRemove==-1){
            new Alert(Alert.AlertType.WARNING, "Please Select a Row").show();
        }else {
            obList.remove(cartSelectedRowForRemove);
            calculateCost();
            tblAddListTable.refresh();
        }
    }

    public void btnConfirmOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDetails> item = new ArrayList<>();
        double total = 0;
        for (CartTm tempTm : obList
             ) {
            total+=tempTm.getTotal();
            item.add(new ItemDetails(
                    "",
                    tempTm.getItemCode(),
                    tempTm.getQty(),
                    tempTm.getUnitPrice()
            ));

        }

        Order order = new Order(
                lblOrderId.getText(),
                lblDate.getText(),
                cmbCustomerID.getValue(),
                total,
                item
        );

        if (new OrderDAOImpl().placeOrder(order)){

            new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
            setOrderId();
            loadAllOrder(new OrderDAOImpl().getAllOrders());

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }


    }
}
