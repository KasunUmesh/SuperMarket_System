package controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {


    public AnchorPane root;

    public void btnAdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AdminForm.fxml"));
        Scene scene = new Scene(parent);

        Stage primaryStage = (Stage) this.root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

    }

    public void btnCashierLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/CashierForm.fxml"));
        Scene scene = new Scene(parent);

        Stage primaryStage = (Stage) this.root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();





    }
}
