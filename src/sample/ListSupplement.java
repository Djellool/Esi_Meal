package sample;

import Classes.Met;
import Classes.Repas;
import Classes.Supplement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListSupplement implements Initializable
{
    public static int index ;
    @FXML
    public ListView listMets;
    @FXML
    public Button Modifier;

    public void ModifierMet(MouseEvent mouseEvent)
    {
        if (listMets.getSelectionModel().getSelectedIndex() != -1)
        {
            index = listMets.getSelectionModel().getSelectedIndex();
            Parent window1;
            try {
                window1 = FXMLLoader.load(getClass().getResource("ModifierSupplement.fxml"));
                Stage window1Stage;
                Scene window1Scene = new Scene(window1);
                window1Stage = Main.homeStage;
                window1Stage.setScene(window1Scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        listMets.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ArrayList<String> Mets = new ArrayList<String>();
        for ( Supplement sup: Main.Esi.Supplements)
        {
                Mets.add(sup.getNom()+"     "+sup.getPrix()+"       "+sup.getNbCal());
        }
        ObservableList<String> liste = FXCollections.observableArrayList(Mets);
        listMets.setItems(liste);
    }
}
