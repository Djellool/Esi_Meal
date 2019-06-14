package sample;

import Classes.Client;
import Classes.TEvenement;
import Classes.TTable;
import javafx.collections.FXCollections;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class Evenement implements Initializable
{
    public static LocalDate dateconsommation;
    public static int Nombre_de_personne;
    public static TEvenement type;
    public static Client client;
    public static String thematique;
    @FXML
    public TextField Nom;
    @FXML
    public TextField Prenom;
    @FXML
    public TextField Nombredepersonne;
    @FXML
    public TextField Thematique;
    @FXML
    public DatePicker Date;
    @FXML
    public ChoiceBox Type;
    @FXML
    public Button Suivant;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Type.setItems(FXCollections.observableArrayList("Anniversaire","Diplome","Marriage","Retraite"));
        try
        {
            if(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).isFidele())
            {
                Nom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNom());
                Prenom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getPrenom());
            }
        }
        catch (Exception ex)
        {

        }
    }

    public void Suivant(MouseEvent mouseEvent)
    {
        try {
            client = new Client(Nom.getText(),Prenom.getText(),"0561403441",false);
            dateconsommation = Date.getValue();
            Nombre_de_personne = Integer.parseInt(Nombredepersonne.getText());
            thematique = Thematique.getText();
            if(Type.getSelectionModel().getSelectedIndex() == 0)
            {
                type = TEvenement.Anniversaire;
            }
            else
            {
                if(Type.getSelectionModel().getSelectedIndex() == 1)
                {
                    type = TEvenement.Diplome;
                }
                else
                {
                    if(Type.getSelectionModel().getSelectedIndex() == 2)
                    {
                        type = TEvenement.Mariage;
                    }
                    else
                    {
                        type = TEvenement.Retraite;
                    }
                }

            }
            Parent window1;
            try {
                window1 = FXMLLoader.load(getClass().getResource("CoixMenuEve.fxml"));
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
        }
    }
}
