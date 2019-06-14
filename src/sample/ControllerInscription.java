package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.Main.Esi;
import Classes.*;

public class ControllerInscription implements Initializable {

    @FXML
    public TextField nomfield;
    @FXML
    public TextField prenomfield;
    @FXML
    public TextField ndtfield;
    @FXML
    public TextField adressefield;
    @FXML
    public ComboBox<String> etudiantfield;
    @FXML
    public PasswordField mdpfield;
    @FXML
    public Button btninscrire;

    public void initialize(URL location, ResourceBundle resources) {
        etudiantfield.setItems(FXCollections.observableArrayList("oui","Non"));
    }
 public void inscrireevent(MouseEvent mouseEvent) throws IOException {
        boolean etudiant = false;
        if (etudiantfield.getSelectionModel().equals("oui")){
            etudiant=true;
        }
     ArrayList<String> adresse=new ArrayList<String>();
        adresse.add(adressefield.getText());
        Client_Fidele e = new Client_Fidele(nomfield.getText(),prenomfield.getText(),ndtfield.getText(), true,adresse, 0,etudiant,mdpfield.getText());
        Esi.LesClients.add(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bravo");
        alert.setHeaderText("Inscription réussite,votre code de fedilité est :"+e.getCode_fidelite());
        alert.show();

        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene=new Scene(root);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
