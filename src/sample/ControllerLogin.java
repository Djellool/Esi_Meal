package sample;

import Classes.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.Esi;


public class ControllerLogin extends Stage{

    public static int indexconnecte = -1;
    @FXML
    public Button Connexion;
    @FXML
    public TextField UtilisateurField;
    @FXML
    public PasswordField MPDField;
    @FXML
    public Button Annonyme;


    public void ConnexionEvent(MouseEvent mouseEvent) throws IOException
    {
        String Utilisateur = UtilisateurField.getText();
        String Mpd = MPDField.getText();
        boolean bool =true;
        for (Client client : Esi.LesClients) {
            if (client instanceof Client_Fidele) {
                if (Utilisateur.equals(((Client_Fidele) client).getCode_fidelite()) & Mpd.equals(((Client_Fidele) client).MotDePasse)) {
                    indexconnecte = Esi.LesClients.indexOf(client);
                    System.out.println(indexconnecte);
                    ((Client_Fidele) client).Conennexion=true;
                    Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    bool=false;
                    break;
                }

            }

        }
        if (bool) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("erreur");
            alert.setHeaderText("Echec d'authentification");
            alert.show();
        }
    }
    @FXML
    public Button BTNInscription;
    public void InscriptionEvent(MouseEvent mouseEvent){
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Stage window1Stage;
            Scene window1Scene = new Scene(window1);
            window1Stage = Main.homeStage;
            window1Stage.setScene(window1Scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ConnexionAnnonyme(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}

