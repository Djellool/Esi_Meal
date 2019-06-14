package sample;

import Classes.Boisson;
import Classes.Supplement;
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

public class ModifierSupplement implements Initializable
{
    @FXML
    public TextField NomSupp;
    @FXML
    public TextField PrixSupp;
    @FXML
    public TextField NbCalSupp;
    @FXML
    public Button Appliquer;

    public void Modifier(MouseEvent mouseEvent)
    {
        try
        {
            Supplement sup = new Supplement(NomSupp.getText(), Integer.parseInt(PrixSupp.getText()),Integer.parseInt(NbCalSupp.getText()));
            Main.Esi.Supplements.remove(ModifierMet.index);
            Main.Esi.Supplements.add(ModifierMet.index,sup);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supplement  Modifier");
            alert.setHeaderText("Le Supplement a ete modifier avec succes");
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
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veillez vous assurer du format de vos informations.");
            alert.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        NomSupp.setText(Main.Esi.Supplements.get(ListSupplement.index).getNom());
        PrixSupp.setText(Main.Esi.Supplements.get(ListSupplement.index).getPrix()+"");
        NbCalSupp.setText(Main.Esi.Supplements.get(ListSupplement.index).getNbCal()+"");
    }
}
