package sample;

import Classes.Client;
import Classes.Client_Fidele;
import Classes.TTable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class Commandedomicile implements Initializable
{
    public static Client_Fidele client;
    public static LocalDate dateconsommation;
    public static LocalTime Heureconsom ;
    public static String Adresse;
    public static int Distanse;
    @FXML
    public TextField Nom;
    @FXML
    public TextField Prenom;
    @FXML
    public TextField Numerotelephone;
    @FXML
    public TextField Adresselivraison;
    @FXML
    public Button Suivant;
    @FXML
    public TextField Distance;
    @FXML
    public DatePicker Date;
    @FXML
    public TextField Heure;

    public void Suivant(MouseEvent mouseEvent)
    {
        try {
            if(ControllerLogin.indexconnecte != -1)
            {
                if (Main.Esi.LesClients.get(ControllerLogin.indexconnecte) instanceof Client_Fidele){
                    ((Client_Fidele) Main.Esi.LesClients.get(ControllerLogin.indexconnecte)).setNb_Commandes();
                    ((Client_Fidele) Main.Esi.LesClients.get(ControllerLogin.indexconnecte)).setAdresses(Adresselivraison.getText());
                }
            }

            dateconsommation = Date.getValue();
            Heureconsom= LocalTime.parse(Heure.getText());
            Adresse = Adresselivraison.getText();
            Distanse = Integer.parseInt(Distance.getText());
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
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veillez verifier le format de vos donnee");
            alert.show();
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
        {
            if(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).isFidele()&&Main.Esi.LesClients.get(ControllerLogin.indexconnecte) instanceof Client_Fidele)
            {
                Nom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNom());
                Prenom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getPrenom());
                Numerotelephone.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNum_telephone());
                Adresselivraison.setText(((Client_Fidele) Main.Esi.LesClients.get(ControllerLogin.indexconnecte)).getAdresses());
            }
        }
        catch (Exception ex)
        {

        }
    }
}
