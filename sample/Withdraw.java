package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
public class Withdraw {
    @FXML
    public TextField accNumber;
    @FXML
    public TextField withdrawAmount;
    @FXML
    public TextArea infoArea;

    public void ExitButton(ActionEvent event) throws IOException
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
    public void EnterButton(ActionEvent event) throws InsufficientBalanceException{
        String accNum= accNumber.getText();
        double withAmount= Double.parseDouble(withdrawAmount.getText());
        Main.info.withdraw(accNum,withAmount);
        BankAccount area=Main.info.display(accNum);
        infoArea.setText(area+ "");
    }
}
