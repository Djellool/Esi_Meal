package Classes ;
import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
    public ArrayList<Met> mets;
    public Menu(ArrayList<Met> mets)
    {
        this.mets = mets;
    }
    public int CalculerNote()
    {
        int k = 0;
        for (Met met: mets)
        {
            k=k+met.prix;
        }
        return k;
    }

    public int CalculerNbCal()
    {
    	int k = 0;
        for (Met met: mets)
        {
            k=k+met.NbCal;
        }
        return k;
    }
    public void ajouter_met(Met m)
    {
        mets.add(m);
    }
    public void supprimer_met(Met m)
    {
        mets.remove(m);
    }

}
