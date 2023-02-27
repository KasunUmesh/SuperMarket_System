package controller;

import bo.custom.ItemBO;
import bo.custom.impl.ItemBOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import dto.ItemDTO;
import views.tm.ItemTM;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class AdminFormController {

    public AnchorPane admin;
    public TextField txtItemCode;
    public TextField txtDescription;
    public TextField txtPackSize;
    public TextField txtQTY;
    public TextField txtUnitPrice;

    public TableView<ItemTM> tblItemDetails;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colPackSize;
    public TableColumn colQTY;
    public TableColumn colUnitPrice;

    ItemTM selectedItem = null;

    private ItemBO item = new ItemBOImpl();

    public void initialize(){

        try {

            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            colQTY.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

            setItemToTable(item.getAllItem());

            tblItemDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null){
                    selectedItem = newValue;
                }
            });

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setItemToTable(ArrayList<ItemDTO> itemDTOS){
        ObservableList<ItemTM> obList = FXCollections.observableArrayList();
        itemDTOS.forEach(e->{
            obList.add(
                    new ItemTM(e.getItemCode(),e.getDescription(),e.getPackSize(),e.getUnitPrice(),e.getQtyOnHand()));
        });
        tblItemDetails.setItems(obList);
    }

    public void btnBackOnAction(Event event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/LoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) this.admin.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ItemDTO i1 = new ItemDTO(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTY.getText())
        );
        if(item.addItem(i1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved..").show();

            txtItemCode.clear();
            txtDescription.clear();
            txtPackSize.clear();
            txtUnitPrice.clear();
            txtQTY.clear();
            txtItemCode.requestFocus();

            setItemToTable(item.getAllItem());

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            txtItemCode.clear();
            txtDescription.clear();
            txtPackSize.clear();
            txtUnitPrice.clear();
            txtQTY.clear();
            txtItemCode.requestFocus();
        }


    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ItemDTO i1 = new ItemDTO(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTY.getText())
        );

        if (item.updateItem(i1)){

            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
            setItemToTable(item.getAllItem());

            txtItemCode.clear();
            txtDescription.clear();
            txtPackSize.clear();
            txtUnitPrice.clear();
            txtQTY.clear();
            txtItemCode.requestFocus();
            
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (selectedItem!=null){
            if (item.deleteItem(selectedItem.getItemCode())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();

                setItemToTable(item.getAllItem());

                txtItemCode.clear();
                txtDescription.clear();
                txtPackSize.clear();
                txtUnitPrice.clear();
                txtQTY.clear();


            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }

        }

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String itemCode = txtItemCode.getText();

        ItemDTO i1 = item.searchItem(itemCode);
        if (i1==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }else {
            setItem(i1);
        }

    }
    void setItem(ItemDTO i){
        txtItemCode.setText(i.getItemCode());
        txtDescription.setText(i.getDescription());
        txtPackSize.setText(i.getPackSize());
        txtUnitPrice.setText(String.valueOf(i.getUnitPrice()));
        txtQTY.setText(String.valueOf(i.getQtyOnHand()));
    }
}
