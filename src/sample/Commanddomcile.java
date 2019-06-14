package sample;

import Classes.*;
import Classes.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Commanddomcile implements Initializable
{
    public static ArrayList<Met> listedesmets = new ArrayList<Met>();
    public static ArrayList<Repas> listrepasstatic = new ArrayList<Repas>();
    public static int indice ;
    public static ArrayList<Integer> lesindices = new ArrayList<Integer>();
    @FXML
    public ListView listrepas;
    @FXML
    public ListView listboisson;
    @FXML
    public TextField Prixtotale;
    @FXML
    public Button Commander;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        listrepas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ArrayList<String> Mets = new ArrayList<String>();
        for ( Met met: Main.Esi.MetDispo)
        {
            if(met instanceof Repas)
            {
                Mets.add(((Repas) met).repas+"      "+met.GetNom()+"     "+met.getPrix()+"       "+met.getNbCal());
                listrepasstatic.add((Repas) met);
            }
        }
        ObservableList<String> liste = FXCollections.observableArrayList(Mets);
        listrepas.setItems(liste);
        listboisson.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ArrayList<String> Boissons= new ArrayList<String>();
        for ( Met met: Main.Esi.MetDispo)
        {
            if(met instanceof Boisson)
            {
                Mets.add(((Boisson) met).boisson+"      "+met.GetNom()+"     "+met.getPrix()+"       "+met.getNbCal());
            }
        }
        ObservableList<String> list = FXCollections.observableArrayList(Boissons);
        listboisson.setItems(list);
        listrepas.getSelectionModel().select(indice);
        int x=0;
        for (Met met:listedesmets
                )
        {
            x=x+met.getPrix();
        }
        Prixtotale.setText("   "+x+"");
    }

    public void listedessupplement(MouseEvent mouseEvent)
    {
        listrepas.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    indice = listrepas.getSelectionModel().getSelectedIndex();
                    lesindices.add(indice);
                    Parent window1;
                    try {
                        window1 = FXMLLoader.load(getClass().getResource("listSupplementrepas.fxml"));
                        Stage window1Stage;
                        Scene window1Scene = new Scene(window1);
                        window1Stage = Main.homeStage;
                        window1Stage.setScene(window1Scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void Commander(MouseEvent mouseEvent)
    {
        Classes.Menu menu = new Classes.Menu(listedesmets);
        Panier panier = new Panier();
        panier.panier.add(menu);
        Commande_domicil cmd = new Commande_domicil(Commandedomicile.client,Commandedomicile.dateconsommation,Commandedomicile.Heureconsom,1,Commandedomicile.Adresse,
                Commandedomicile.Distanse,panier);
        if (cmd.isValide())
        {
            Main.Esi.LesCommandesAtt.add(cmd);//on ajoute la commande a la liste des commandes en attantes.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Commande effectue");
            alert.setHeaderText("La commande a ete ajoute avec succes");
            alert.show();
            Parent window1;
            try {
                window1 = FXMLLoader.load(getClass().getResource("Client.fxml"));
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("La commande n'est pas valide.");
            alert.show();
            Parent window1;
            try {
                window1 = FXMLLoader.load(getClass().getResource("Client.fxml"));
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
