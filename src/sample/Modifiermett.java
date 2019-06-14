package sample;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Iterator;
import java.util.ResourceBundle;

public class Modifiermett implements Initializable
{
    @FXML
    public ListView Listview;
    @FXML
    public Tab RepasTab;
    @FXML
    public Tab BoissonTab;
    @FXML
    public RadioButton Entre;
    @FXML
    public RadioButton Plat;
    @FXML
    public RadioButton Dessert;
    @FXML
    public TextField NomRepas;
    @FXML
    public TextField PrixRepas;
    @FXML
    public TextField NBCalRepas;
    @FXML
    public TextField NombreuniteRepas;
    @FXML
    public TextField Nom;
    @FXML
    public TextField Marque;
    @FXML
    public TextField Gout;
    @FXML
    public TextField Prix;
    @FXML
    public TextField Nombre_Calorie;
    @FXML
    public TextField Nombre_unite;
    @FXML
    public TabPane Pane;
    @FXML
    public Button Modifier_Repas;
    @FXML
    public Button ModifierBoisson;
    @FXML
    public RadioButton Eau;
    @FXML
    public RadioButton Jus;
    @FXML
    public RadioButton Gazeuze;
    @FXML
    public RadioButton Cafe;
    @FXML
    public RadioButton the;

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

    private TBoisson Typedeboisson()
    {
        if(Eau.isSelected())
        {
            return TBoisson.Eau;
        }
        else
        {
            if(Jus.isSelected())
            {
                return TBoisson.jus;
            }
            else
            {
                if(Gazeuze.isSelected())
                {
                    return TBoisson.BoissonGazzouz;
                }
                else
                {
                    if(Cafe.isSelected())
                    {
                        return TBoisson.Cafe;
                    }
                    else
                    {
                        return TBoisson.the;
                    }
                }
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources)
    {
        if(Main.Esi.MetDispo.get(ModifierMet.index) instanceof Repas)
        {
            BoissonTab.setDisable(true);
            NomRepas.setText(Main.Esi.MetDispo.get(ModifierMet.index).GetNom());
            PrixRepas.setText(Main.Esi.MetDispo.get(ModifierMet.index).getPrix()+"");
            NBCalRepas.setText(Main.Esi.MetDispo.get(ModifierMet.index).getNbCal()+"");
            NombreuniteRepas.setText(Main.Esi.MetDispo.get(ModifierMet.index).getNbUnit()+"");
            Listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            ArrayList<String> supplementsstring = new ArrayList<String>();
            for ( Supplement supp: Main.Esi.Supplements)
            {
                supplementsstring.add(supp.getNom() +"          "+ supp.getPrix()+ "             "+ supp.getNbCal());
            }
            ObservableList<String> liste = FXCollections.observableArrayList(supplementsstring);
            Listview.setItems(liste);
        }
        else
        {
            if (Main.Esi.MetDispo.get(ModifierMet.index) instanceof Boisson)
            {
                RepasTab.setDisable(true);
                Pane.getSelectionModel().select(BoissonTab);
                Nom.setText(Main.Esi.MetDispo.get(ModifierMet.index).GetNom());
                Prix.setText(Main.Esi.MetDispo.get(ModifierMet.index).getPrix()+"");
                Nombre_Calorie.setText(Main.Esi.MetDispo.get(ModifierMet.index).getNbCal()+"");
                Marque.setText(((Boisson) Main.Esi.MetDispo.get(ModifierMet.index)).marque);
                Gout.setText(((Boisson) Main.Esi.MetDispo.get(ModifierMet.index)).gout);
                Nombre_unite.setText(Main.Esi.MetDispo.get(ModifierMet.index).getNbUnit()+"");
            }
        }
    }

    public void Appliquer_Repas(MouseEvent mouseEvent) {
        ArrayList<Supplement> list = new ArrayList<Supplement>();//une list qui contient les supplement possible pour ce repas.
        ObservableList selectedIndices = Listview.getSelectionModel().getSelectedIndices();
        Iterator i = selectedIndices.iterator();
        while (i.hasNext()) {
            int x = (int) i.next();
            list.add(Main.Esi.Supplements.get(x));//on ajoute le supplement dans la liste des supplements acceptable pour ce met.
        }
        Repas repas;
        repas = new Repas(Typederepas(), Integer.parseInt(PrixRepas.getText()), NomRepas.getText(), Integer.parseInt(NBCalRepas.getText()),
                Integer.parseInt(NombreuniteRepas.getText())
                , list,null);
        Main.Esi.MetDispo.remove(ModifierMet.index);
        Main.Esi.MetDispo.add(ModifierMet.index,repas);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Met Modifier");
        alert.setHeaderText("Le Repas a ete modifier avec succes");
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

    public void Modifier(MouseEvent mouseEvent)
    {
        Boisson boisson = new Boisson(Typedeboisson(),Marque.getText(),Gout.getText(),Nom.getText(),Integer.parseInt(Prix.getText()),
                Integer.parseInt(Nombre_Calorie.getText()),Integer.parseInt(Nombre_unite.getText()));
        Main.Esi.MetDispo.remove(ModifierMet.index);
        Main.Esi.MetDispo.add(ModifierMet.index,boisson);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Met Modifier");
        alert.setHeaderText("La boisson a ete modifier avec succes");
        alert.show();
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
}
