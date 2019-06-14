package Classes ;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
public class EsiMeal implements Serializable
{
    public ArrayList<Client> LesClients = new ArrayList<Client>();
    public ArrayList<Met> MetDispo = new ArrayList<Met>();
    public ArrayList<Supplement> Supplements = new ArrayList<Supplement>();
    public final int Capacite= 80;
    public int NbTabInt;
    public int NbTabExt;
    public ArrayList<Commande>LesCommandesEff;//une liste des commandes effectues.
    public ArrayList<Commande>LesCommandesAtt;//une liste des commandes en attantes.
    public ArrayList<LocalDate> DateEvenArr; //une liste qui contient les jours ou le restaurant est reserve.

    public EsiMeal()
    {
        MetDispo = new ArrayList<Met>();
        Supplements = new ArrayList<Supplement>();
        LesClients = new ArrayList<Client>();
        LesCommandesEff = new ArrayList<Commande>();
        LesCommandesAtt = new ArrayList<Commande>();
        DateEvenArr = new ArrayList<LocalDate>();
    }
    public void ReservRest(Evenement Eve) {
        boolean Accept = true;
        if (DateEvenArr.contains(Eve.getDate_Consommation())) {
            Accept = false;
        }
        if (Accept)//on ajoute la date de l'evenment comme etant reserve.
        {
            DateEvenArr.add(Eve.getDate_Consommation());
        } else {
            System.out.println("Le restaurant est deja reserve,Veillez choisir une autre date");
        }

    };

    public void ajouter_Client(Client client)
    {
        this.LesClients.add(client);
    }

    public void Supprimer_Client(Client client)
    {
        this.LesClients.remove(client);
    }

    public void ajouter_commande_att(Commande commande)
    {
        this.LesCommandesAtt.add(commande);
        Collections.sort(this.LesCommandesAtt);//on trie les commandes en attentes.
    }
    public void Commandes_Recues(Commande commande)
    {
        this.LesCommandesAtt.remove(commande);
        this.LesCommandesEff.add(commande);
    }

    public void Ajouter_metdispo(Met met)
    {
        MetDispo.add(met);
    }
    public void supprimer(Met met)
    {
        MetDispo.remove(met);
    }

    public void ajouter_Supplement(Supplement sup)
    {
        Supplements.add(sup);
    }
    public void nb_table_interieur(int i)
    {
        this.NbTabInt = i;
    }
    public void nb_table_exterieur(int i)
    {
        this.NbTabExt = i;
    }

    public double Montant_Commande(LocalDate datedebut,LocalDate datefin)//retourne le montant des commandes effectue entre datedebut et datefin(avec les reductions comprises).
    {
        double x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut))
            {
                x =x + cmd.Note_avec_prime();
            }
        }
        return x;
    }
    public double Montant_Commande_surplace(LocalDate datedebut,LocalDate datefin)//retourne le montant des commandes effectue entre datedebut et datefin(avec les reductions comprises).
    {
        double x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) && cmd.type.equals("Surplace"))
            {
                x =x + cmd.Note_avec_prime();
            }
        }
        return x;
    }
    public double Montant_Commande_domicil(LocalDate datedebut,LocalDate datefin)//retourne le montant des commandes effectue entre datedebut et datefin(avec les reductions comprises).
    {
        double x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) && cmd.type.equals("Domicil"))
            {
                x =x + cmd.Note_avec_prime();
            }
        }
        return x;
    }
    public double Montant_Event(LocalDate datedebut,LocalDate datefin)//retourne le montant des commandes effectue entre datedebut et datefin(avec les reductions comprises).
    {
        double x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) &&(cmd instanceof Evenement))
            {
                x = x + cmd.Note_avec_prime();
            }
        }
        return x;
    }

    public int nombre_Commande(LocalDate datedebut,LocalDate datefin)//retourne le nombre maximm de commande entre datedebut et datefin.
    {
        int x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) )
            {
                x =x+1;
            }
        }
        return x;
    }
    public int nombre_Commande_surplace(LocalDate datedebut,LocalDate datefin)//retourne le nombre maximm de commande entre datedebut et datefin.
    {
        int x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) && cmd.type.equals("Surplace") )
            {
                x =x+1;
            }
        }
        return x;
    }
    public int nombre_Commandedomicil(LocalDate datedebut,LocalDate datefin)//retourne le nombre maximm de commande entre datedebut et datefin.
    {
        int x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) && cmd.type.equals( "Domicil" ))
            {
                x =x+1;
            }
        }
        return x;
    }
    public int nombre_Event(LocalDate datedebut,LocalDate datefin)//retourne le nombre maximm de commande entre datedebut et datefin.
    {
        int x =0;
        for (Commande cmd:this.LesCommandesEff)
        {
            if(cmd.Date_Consommation.isBefore(datefin) && cmd.Date_Consommation.isAfter(datedebut) && (cmd instanceof Evenement) )
            {
                x =x+1;
            }
        }
        return x;
    }

    public float ReductionOfferteTotale()
    {
        float x =0;
        for (Commande cmd: this.LesCommandesEff)
        {
            x = x+ cmd.Note_avec_prime()-cmd.Prix_Commande();
        }
        return x;
    }
    public float Reductionfidele()
    {
        float x =0;
        for (Commande cmd: this.LesCommandesEff)
        {
            if(cmd.client.isFidele())
            {
                x = x+ cmd.Prix_Commande()*(Reduction.primefidelite/100);//on offre a chaque client fidele 5% remise.
            }
        }
        return x;
    }
    public float ReductionEtudiant()
    {
        float x =0;
        for (Commande cmd: this.LesCommandesEff)
        {
            if(cmd.client instanceof Client_Fidele)
            {
                if (((Client_Fidele) cmd.client).isEtudiant())
                {
                    x = x+ cmd.Prix_Commande()*(Reduction.primeetudiant/100);//on offre a chaque client fidele 8% remise.
                }
            }
        }
        return x;
    }
    public float Reductiongroupedomicile()
    {
        float x =0;
        for (Commande cmd: this.LesCommandesEff)
        {
            if(cmd instanceof Commande_domicil)
            {
                if (cmd.nb_personne > 5)
                {
                    x = x+ cmd.Prix_Commande()*(Reduction.primegroupedomicile/100);//on offre a chaque groupe de plus de 5 personne remise.
                }
            }
        }
        return x;
    }
    public float Reductionevenement()
    {
        float x =0;
        for (Commande cmd: this.LesCommandesEff)
        {
            if(cmd instanceof Evenement)
            {
                    x = x+ cmd.Prix_Commande()*(Reduction.primeevent/100);//on offre a chaque evenement 10% remise.
            }
        }
        return x;
    }

}
