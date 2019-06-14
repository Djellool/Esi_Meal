package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Classes.EsiMeal;

public class Menu implements Initializable
{
    @FXML
    public Button ListeMets;
    @FXML
    public Button AjouterMet;
    @FXML
    public Button Listedesupplement;
    @FXML
    public Button Ajoutersupplement;
    @FXML
    public Button listcommandeattente;
    @FXML
    public ComboBox Choix;
    @FXML
    public DatePicker Datededebut;
    @FXML
    public DatePicker Datedefin;
    @FXML
    public Button Resultat;
    @FXML
    public TextField Textresult;

    public void ListeMets(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("ModifierMet.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterMet(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("AjouterMet.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ListeSupplement(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("ListeSupplement.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AjouterSupplement(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("AjouterSupplement.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Listecommandesattentes(MouseEvent mouseEvent)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("ListeCommandesattentes.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Choix.setItems(FXCollections.observableArrayList("Nombre des commandes effectuées","Nombre des commandes sur place","Le nombre des commandesdomcile",
                "Nombre evenements","Montant des commandes effectuées","Montant des commandes sur place" ,"Mantant des commandes domicile","Montant des évenemanets","Montant totale des reductions",
                "Mantant des reductions de type fédilité","Montant des reductions de type etudiant","Montant des reduction de type groupe a domicile","Montant des réduction de type évenement"
        ));
    }

    public void Resultat(MouseEvent mouseEvent)
    {
        int i = Choix.getSelectionModel().getSelectedIndex();
        System.out.println(i+"");
        switch (i){
            case 0 :
                Textresult.setText(Integer.toString(Main.Esi.nombre_Commande(Datededebut.getValue(),Datedefin.getValue())));

                break;

            case 1:
                Textresult.setText(Integer.toString(Main.Esi.nombre_Commande_surplace(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 2:
                Textresult.setText(Integer.toString(Main.Esi.nombre_Commandedomicil(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 3:
                Textresult.setText(Integer.toString(Main.Esi.nombre_Event(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 4 :
                Textresult.setText(Double.toString(Main.Esi.Montant_Commande(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 5 :
                Textresult.setText(Double.toString(Main.Esi.Montant_Commande_surplace(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 6 :
                Textresult.setText(Double.toString(Main.Esi.Montant_Commande_domicil(Datededebut.getValue(),Datedefin.getValue())));
                break;
            case 7 :
                Textresult.setText(Float.toString(Main.Esi.Reductionfidele()));
                break;
            case 8 :
                Textresult.setText(Float.toString(Main.Esi.ReductionEtudiant()));
                break;
            case 9 :
                Textresult.setText(Float.toString(Main.Esi.Reductiongroupedomicile()));
                break;
            case 10 :
                Textresult.setText(Float.toString(Main.Esi.Reductionevenement()));
                break;







        }

    }
}
