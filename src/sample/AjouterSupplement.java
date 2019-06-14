package sample;

import Classes.Boisson;
import Classes.Supplement;
import Classes.TBoisson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AjouterSupplement
{
    @FXML
    public TextField NomSupp;
    @FXML
    public TextField PrixSupp;
    @FXML
    public TextField NbCalSupp;
    @FXML
    public Button Ajouter;

    public void Ajouter(MouseEvent mouseEvent)
    {
        try
        {
            Supplement sup = new Supplement(NomSupp.getText(),Integer.parseInt(PrixSupp.getText()),Integer.parseInt(NbCalSupp.getText()));
            Main.Esi.ajouter_Supplement(sup);//on ajoute la boisson a la liste des mets disponibles.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supplement Sauvegarde");
            alert.setHeaderText("Le Supplement a ete ajoute avec succes");
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
}
