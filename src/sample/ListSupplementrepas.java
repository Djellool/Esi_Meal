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

public class ListSupplementrepas implements Initializable
{
    public static ArrayList<Supplement> listsupplementt = new ArrayList<Supplement>();//une list qui contient les supplement choisis ce repas.
    @FXML
    public ListView listsupplement;
    @FXML
    public Button Appliquer;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        listsupplement.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Met met  = Main.Esi.MetDispo.get(Commanddomcile.indice);
        ArrayList<String> listsupp = new ArrayList<String >();
        if(met instanceof Repas)
        {
            for (Supplement sup: ((Repas) met).supplementpossible)
            {
                listsupp.add(sup.getNom()+"     "+sup.getPrix()+"       "+sup.getNbCal());
            }
        }
        ObservableList<String> liste = FXCollections.observableArrayList(listsupp);
        listsupplement.setItems(liste);
    }

    public void Appliquer(MouseEvent mouseEvent)
    {
        ObservableList selectedIndices = listsupplement.getSelectionModel().getSelectedIndices();
        ArrayList<Met> metdispo2 = new ArrayList<Met>();
        Iterator i = selectedIndices.iterator();
        while(i.hasNext()) {
            int x = (int)i.next();
            if(Main.Esi.MetDispo.get(Commanddomcile.indice) instanceof Repas)
            {
                listsupplementt.add(((Repas) Main.Esi.MetDispo.get(Commandesurplace.indice)).supplementpossible.get(x));//on ajoute le supplement dans la liste des supplements accep
            }
        }
        if (Main.Esi.MetDispo.get(Commanddomcile.indice) instanceof Repas)
        {
            Repas repas =Commanddomcile.listrepasstatic.get(Commanddomcile.indice);
            Commandesurplace.listedesmets.add(new Repas(repas.repas,repas.getPrix(),repas.GetNom(),repas.getNbCal(),repas.getNbUnit()
                    ,repas.supplementpossible,listsupplementt));//on creer un nouveau objet repas.
        }
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("Commanddomcile.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
