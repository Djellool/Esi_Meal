package sample;

import Classes.Commande;
import Classes.EsiMeal;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import Classes.Evenement;
import Classes.Fichier;
import Classes.Met;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    public static EsiMeal Esi;
    public static Stage homeStage ;
    @Override
    public void start(Stage primaryStage) throws Exception{
        homeStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        homeStage.setTitle("Esi Meal");
        homeStage.setScene(new Scene(root));
        homeStage.setResizable(false);
        homeStage.show();
        homeStage.setOnCloseRequest(event -> {
           Fichier.OutEsi(Esi);//on sauvegarde l'objet ESI a la fermeture de l'application.
        });
    }


    public static void main(String[] args)
    {
        if (Files.exists(Paths.get("Esi.dat")))
        {
            Esi = Fichier.InEsi();//on recupere les informations depuis le fichier.
        }
        else
        {
            Esi = new EsiMeal();//on creer un nouvel objet de type restaurant a la premiere utilisation.
        }
        launch(args);
    }
}
