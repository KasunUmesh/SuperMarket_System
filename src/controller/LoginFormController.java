package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
   
    public AnchorPane root;
    public TextField txtUserName;
    public TextField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userName.equals("Admin") && password.equals("1234")){
            Parent parent = FXMLLoader.load(getClass().getResource("../views/AdminForm.fxml"));
            Scene scene = new Scene(parent);

            Stage primaryStage = (Stage) this.root.getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);


        } else if (userName.equals("Cashier") && password.equals("1234")) {
            Parent parent = FXMLLoader.load(getClass().getResource("../views/CashierForm.fxml"));
            Scene scene = new Scene(parent);

            Stage primaryStage = (Stage) this.root.getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
        }


    }
}
