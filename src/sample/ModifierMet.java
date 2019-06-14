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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ModifierMet implements Initializable
{
    public static int index ;
    @FXML
    public ListView listMets;
    @FXML
    public Button Modifier;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        listMets.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ArrayList<String> Mets = new ArrayList<String>();
        for ( Met met: Main.Esi.MetDispo)
        {
            if(met instanceof Repas)
            {
                Mets.add("Repas     "+met.GetNom()+"     "+met.getPrix()+"       "+met.getNbUnit());
            }
            else {
                Mets.add("Boisson       " + met.GetNom() + "    " + met.getPrix() + "       " + met.getNbUnit());
            }

        }
        ObservableList<String> liste = FXCollections.observableArrayList(Mets);
        listMets.setItems(liste);
    }

    public void ModifierMet(MouseEvent mouseEvent)
    {
        if(listMets.getSelectionModel().getSelectedIndex() != -1) {
            index = listMets.getSelectionModel().getSelectedIndex();
            Parent window1;//on ouvre la fenetre modifier.
            try {
                window1 = FXMLLoader.load(getClass().getResource("Modifiermett.fxml"));
                Stage window1Stage;
                Scene window1Scene = new Scene(window1);
                window1Stage = Main.homeStage;
                window1Stage.setScene(window1Scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
