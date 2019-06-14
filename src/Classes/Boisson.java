package Classes ;

import java.io.Serializable;

public class Boisson extends Met implements Serializable {
    public TBoisson boisson;
    public String marque;
    public String gout;

    public Boisson(TBoisson boisson, String marque, String gout,String nom,int prix,int NbCal,int Nb_unit)
    {
        this.boisson = boisson;
        this.marque = marque;
        this.gout = gout;
        super.NbCal = NbCal;
        super.prix = prix;
        super.nom = nom;
        super.NbUnit = Nb_unit;
    }

}
