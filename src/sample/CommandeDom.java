package sample;

import Classes.Client;
import Classes.TTable;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class CommandeDom implements Initializable
{
    public static LocalDate dateconsommation;
    public static LocalTime Heure ;
    public static TTable type;
    public static Client client;
    public static int nombre_personne;
    @FXML
    public TextArea Nom;
    @FXML
    public TextArea Prenom;
    @FXML
    public ChoiceBox TypeTable;
    @FXML
    public TextArea NbTelephone;
    @FXML
    public TextArea nb_personne;
    @FXML
    public TextArea HeureConsommation;
    @FXML
    public Button Suivant;
    @FXML
    public DatePicker Date;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            TypeTable.setItems(FXCollections.observableArrayList("Interieur","Extrerieur"));
            if(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).isFidele())
            {
                Nom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNom());
                Prenom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getPrenom());
                NbTelephone.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNum_telephone());
            }
        }
       catch (Exception ex)
       {

       }
    }

    public void Suivant(MouseEvent mouseEvent) throws ParseException {
        try {

            client = new Client(Nom.getText(),Prenom.getText(),NbTelephone.getText(),false);
            dateconsommation = Date.getValue();
            Heure= LocalTime.parse(HeureConsommation.getText());
            nombre_personne = Integer.parseInt(nb_personne.getText());
            if(TypeTable.getSelectionModel().getSelectedIndex() == 0)
            {
                type = TTable.Interieur;
            }
            else
            {
                type = TTable.Exterieur;
            }
            Parent window1;
            try {
                window1 = FXMLLoader.load(getClass().getResource("Commande.fxml"));
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
            alert.setHeaderText("Veillez vérifier le format de vos données");
            alert.show();
        }

    }
}
