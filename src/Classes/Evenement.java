package Classes ;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Evenement extends Commande implements Reduction,Serializable {
    private Menu MenuEve;
    private String thematique;
    private TEvenement Teve;
    public Evenement(Client client, LocalDate Date_consommation, LocalTime Heure_consommation, int nb_personne, Menu MenuEVE
    , String thematique, TEvenement Teve)
    {
        super(client,"Event",Date_consommation,Heure_consommation,nb_personne);
        this.MenuEve = MenuEVE;
        this.Teve = Teve;
        this.thematique = thematique;
    }
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public float Note_avec_prime()
    {
        float Note = this.MenuEve.CalculerNote();
        if(this.nb_personne>50)
        {
            if(this.client.isFidele())
            {
                Client_Fidele e = (Client_Fidele) this.client;
                if(e.isEtudiant())
                {
                    return  Note - Note*(primeetudiant+primeevent+primefidelite/100);
                }
                else
                {
                    return Note - Note*(primeevent+primefidelite/100);
                }
            }
            else
            {
                return Note - Note*(primeevent/100);
            }
        }
        else
        {
            if(this.client.isFidele())
            {
                Client_Fidele e = (Client_Fidele) this.client;
                if(e.isEtudiant())
                    return Note - Note * (primeetudiant + primefidelite / 100);
                return Note - Note*(primefidelite/100);
            }
            else
                return Note;
        }
    }
}
