package sample;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AjouterMet implements Initializable
{
    @FXML
    public ListView Listview;
    @FXML
    public AnchorPane Anchorpane;
    @FXML
    public TextField NomRepas;
    @FXML
    public TextField PrixRepas;
    @FXML
    public TextField NBCalRepas;
    @FXML
    public TextField NombreuniteRepas;
    @FXML
    public Button AjouterRepas;
    @FXML
    public RadioButton Entre;
    @FXML
    public RadioButton Plat;
    @FXML
    public RadioButton Dessert;
    @FXML
    private TextField Nom;

    @FXML
    private TextField Marque;

    @FXML
    private TextField Gout;

    @FXML
    private TextField Prix;

    @FXML
    private TextField Nombre_Calorie;

    @FXML
    private TextField Nombre_unite;

    @FXML
    private Button Ajouter;

    public void Ajouter_Boisson(MouseEvent mouseEvent)
    {
        try
        {
            Boisson boisson = new Boisson(TBoisson.Eau,Marque.getText(),Gout.getText(), Nom.getText(),Integer.parseInt(Prix.getText()),
                    Integer.parseInt(Nombre_Calorie.getText()),Integer.parseInt(Nombre_unite.getText()));
            Main.Esi.Ajouter_metdispo(boisson);//on ajoute la boisson a la liste des mets disponibles.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Met Ajoutee");
            alert.setHeaderText("La boisson a ete ajoute avec succes");
            alert.show();
            Parent window1;
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
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("erreur");
            alert.setHeaderText("Verifiez le format de vos Donnee");
            alert.show();
        }
    }

    private TRepas Typederepas()
    {
        if(Entre.isSelected())
        {
            return TRepas.entree ;
        }
        else
        {
            if(Plat.isSelected())
            {
                return TRepas.plat ;
            }
            else
            {
                    return TRepas.dessert;
            }
        }
    }
    public void jouterRepas(MouseEvent mouseEvent)//on ajoute un repas a la liste des mets disponibles.
    {
        try
        {
            ArrayList<Supplement> list = new ArrayList<Supplement>();//une list qui contient les supplement possible pour ce repas.
            ObservableList selectedIndices = Listview.getSelectionModel().getSelectedIndices();
            Iterator i = selectedIndices.iterator();
            while(i.hasNext()) {
                int x = (int)i.next();
                list.add(Main.Esi.Supplements.get(x));//on ajoute le supplement dans la liste des supplements acceptable pour ce met.
            }
            Repas repas = new Repas(Typederepas(),Integer.parseInt(PrixRepas.getText())
                    ,NomRepas.getText(),Integer.parseInt(NBCalRepas.getText()),Integer.parseInt(NombreuniteRepas.getText()),list,null);//on creer un objet de type repas.
            Main.Esi.Ajouter_metdispo(repas);//on ajoute le repas a nos liste de repas.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Met Ajoutee");
            alert.setHeaderText("La repas a ete ajoute avec succes");
            alert.show();
            Parent window1;
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
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Verifiez le format de vos donnee");
            alert.show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ArrayList<String> supplementsstring = new ArrayList<String>();
        for ( Supplement supp: Main.Esi.Supplements)
        {
            supplementsstring.add(supp.getNom() +"          "+ supp.getPrix()+ "             "+ supp.getNbCal());
        }
        ObservableList<String> liste = FXCollections.observableArrayList(supplementsstring);
        Listview.setItems(liste);
    }
}
