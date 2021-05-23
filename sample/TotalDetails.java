package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class TotalDetails {
    @FXML
    public TextArea allAccDetails;
    int i=0;
    public void viewList(int i){
        BankAccount acc=Main.info.display(i);
        if(acc!=null){
            allAccDetails.setText(acc+" ");
        }
        else
            allAccDetails.setText("No more Accounts to show -.-");
    }
    public void startButton(ActionEvent event){
        viewList(0);
    }
    public void nextButton(ActionEvent event){
        if (i<Main.info.accounts.size()-1) {
            i++;
            viewList(i);
        }
        else
            allAccDetails.setText("No Accounts to show!");
    }
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
}
