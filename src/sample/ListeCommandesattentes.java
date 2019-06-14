package sample;

import Classes.Commande;
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
import java.util.ResourceBundle;

public class ListeCommandesattentes implements Initializable
{
    @FXML
    public ListView listecommandeattentes;
    @FXML
    public Button Retour;
    @FXML
    public Button MarquerFaite;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
            listecommandeattentes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            ArrayList<String> Commandes = new ArrayList<String>();
            for ( Commande cmd: Main.Esi.LesCommandesAtt)
            {
                Commandes.add(cmd.getClient().getNom()+"       "+cmd.getType()+"        "+cmd.getDate_Consommation()+"      "+cmd.getHeure_Consommation());
            }
            ObservableList<String> liste = FXCollections.observableArrayList(Commandes);
            listecommandeattentes.setItems(liste);

    }

    public void RetourMenu(MouseEvent mouseEvent)
    {
        Parent window1;//on ouvre la fenetre modifier.
        try {
            window1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MarquerCommeFaite(MouseEvent mouseEvent)
    {
        int indice = listecommandeattentes.getSelectionModel().getSelectedIndex();
        if(indice != -1)
        {
            Main.Esi.Commandes_Recues(Main.Esi.LesCommandesAtt.get(indice));//on mets la commande comme etant consomme
            ArrayList<String> Commandes = new ArrayList<String>();
            for ( Commande cmd: Main.Esi.LesCommandesAtt)
            {
                Commandes.add(cmd.getClient().getNom()+"       "+cmd.getType()+"        "+cmd.getDate_Consommation()+"      "+cmd.getHeure_Consommation());
            }
            ObservableList<String> liste = FXCollections.observableArrayList(Commandes);
            listecommandeattentes.setItems(liste);
        }
    }
}
