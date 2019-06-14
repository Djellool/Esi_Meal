package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientControl
{
    @FXML
    public Button ComDom;
    @FXML
    public Button ComPlace;
    @FXML
    public Button ComEve;
    @FXML
    public Button ModPro;

    public void Commandedomicil(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("CommandeDom.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Commandesurplace(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("Commandedomicile.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReserverEvent(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GOmodifier(MouseEvent mouseEvent) {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
