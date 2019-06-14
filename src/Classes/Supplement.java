package Classes ;

import java.io.Serializable;

public class Supplement implements Serializable {
    private String nom;
    private int prix;
    private int NbCal;

    public Supplement(String nom, int prix, int nbCal) {
        this.nom = nom;
        this.prix = prix;
        NbCal = nbCal;
    }

    public String getNom()
    {
        return nom;
    }

    public int getPrix()
    {
        return prix;
    }

    public int getNbCal() {
        return NbCal;
    }
}
