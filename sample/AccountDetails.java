package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
public class AccountDetails {
    @FXML
    public TextField accNumber;
    @FXML
    public TextArea infoArea;

    public void ExitBotton(ActionEvent event) throws IOException
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
    public void EnterButton(ActionEvent event) throws InsufficientBalanceException
    {
        String accNum= accNumber.getText();
        BankAccount accDetails=Main.info.display(accNum);
        infoArea.setText(accDetails+ "");
    }
}
