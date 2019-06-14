package Classes ;
import java.io.Serializable;
import java.util.ArrayList;

public class Repas extends Met implements Serializable {
    public TRepas repas;
    public ArrayList<Supplement> supp;
    public ArrayList<Supplement> supplementpossible;

    public Repas(TRepas repas,int prix,String nom,
    int nb_calorie,int Nbunit,ArrayList<Supplement> supplementpossible, ArrayList<Supplement> supp) {
        this.repas = repas;
        this.supp = new ArrayList<Supplement>();//on creer un objet de la liste des supplement.
        super.prix = prix;
        super.nom = nom;
        super.NbCal = nb_calorie;
        super.NbUnit = Nbunit ;
        this.supplementpossible = supplementpossible;
        this.supp = supp;
    }
    public void ajouter_supp(Supplement supp)
    {
        this.supp.add(supp);
    }
    public int NoteSupplement()
    {
        int k=0;
        for (Supplement sup:supp)
        {
            k=k+sup.getPrix();
        }
        return k;
    }

}
