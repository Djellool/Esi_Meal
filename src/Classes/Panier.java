package Classes ;
import java.io.Serializable;
import java.util.ArrayList;

public class Panier implements Serializable {
    public ArrayList<Menu> panier;
    public Panier()
    {
        this.panier = new ArrayList<Menu>();
    }
    public void RemplirPan(ArrayList<Menu> list)
    {
    	this.panier = list;
    };
    public void ajouter_Menu(Menu menu)
    {
        panier.add(menu);
    }
    public void supprimer_Menu(Menu menu)
    {
        panier.remove(menu);
    }
    public int Calculer_Calorie()
    {
        int k=0;
        for (Menu menu:panier)
        {
            k=k+menu.CalculerNbCal();
        }
        return k ;
    };
    public void afficher_calorie()
    {
        System.out.println(Calculer_Calorie());
    }
    public int CalculerNote()
    {
        int k=0;
        for (Menu menu:panier)
        {
            k=k+menu.CalculerNote();
        }
        return k ;
    };
}
