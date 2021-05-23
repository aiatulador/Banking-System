package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
public class Savings {
    @FXML
    public TextField name;
    @FXML
    public TextField initialAmount;
    @FXML
    public TextField maxWithLimit;
    @FXML
    public TextField accNumber;

    public void DoneButton(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Welcome to Bank of UAP");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void CancleButton(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAccount.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Welcome to Bank of UAP");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void EnterButton(ActionEvent event){
    String nm= name.getText();
    double inAmount= Double.parseDouble(initialAmount.getText());
    double maxWlimit= Double.parseDouble(maxWithLimit.getText());
    String returnedAccNumber=Main.info.addNewAccount(nm, inAmount,maxWlimit);
     accNumber.setText(returnedAccNumber);
    }

}
