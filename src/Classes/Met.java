package Classes ;

import java.io.Serializable;

public abstract class Met implements Serializable {
    protected String nom;
    protected int prix;
    protected boolean dispo;
    protected int NbCal;
    protected int NbUnit;
    public String GetNom()
    {
        return this.nom;
    }
    public int getPrix()
    {
        return this.prix;
    }
    public int getNbUnit()
    {
        return this.NbUnit;
    }
    public int getNbCal(){return  this.NbCal;}
}

