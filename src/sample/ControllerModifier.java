package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerModifier implements Initializable {
    @FXML
    public TextField Nom;
    @FXML
    public TextField Prenom;
    @FXML
    public TextField NumTelephone;
    @FXML
    public Button ModifierBTN;

    public void ModifierEvent(MouseEvent mouseEvent) {
            if (Main.Esi.LesClients.get(ControllerLogin.indexconnecte).isFidele())
                Main.Esi.LesClients.get(ControllerLogin.indexconnecte).setNom(Nom.getText());
                Main.Esi.LesClients.get(ControllerLogin.indexconnecte).setPrenom(Prenom.getText());
                Main.Esi.LesClients.get(ControllerLogin.indexconnecte).setNum_telephone(NumTelephone.getText());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bravo");
                alert.setHeaderText("Le Profile a été Modifier avec succée");
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

            @Override
            public void initialize (URL location, ResourceBundle resources){
                try {
                    if (Main.Esi.LesClients.get(ControllerLogin.indexconnecte).isFidele()) {
                        Nom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNom());
                        Prenom.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getPrenom());
                        NumTelephone.setText(Main.Esi.LesClients.get(ControllerLogin.indexconnecte).getNum_telephone());
                    }
                } catch (Exception ex) {

                }

            }
        }

