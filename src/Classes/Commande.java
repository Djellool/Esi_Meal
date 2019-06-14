package Classes ;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public abstract class Commande implements Comparable,Serializable
{
	protected Client client;
	protected Boolean Validite;

	public LocalDate getDate_Consommation() {
		return Date_Consommation;
	}

	protected LocalDate Date_Consommation;
	protected LocalTime  Heure_Consommation;
	protected int nb_personne;
	protected String type;
	public Commande(Client client, String type, LocalDate Date_consommation, LocalTime Heure_consommation, int nb_personne) {
		this.client = client;
		this.Date_Consommation = Date_consommation;
		this.Heure_Consommation = Heure_consommation;
		this.nb_personne = nb_personne;
		this.type = type;
	}

	public int compareTo(Commande commande) {
		if(this.Date_Consommation.compareTo(commande.Date_Consommation)==0)
		{
			if(this.Heure_Consommation.compareTo(commande.Heure_Consommation)==0)
			{
				if(this.type =="Domicile")
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return this.Heure_Consommation.compareTo(commande.Heure_Consommation);
			}
		}
		else
		{
			return this.Date_Consommation.compareTo(commande.Date_Consommation);
		}
	}
	public int Prix_Commande() { return 0;} // on les definit juste pour les utiliser dans commandes_domicil et surplace.
	public abstract float Note_avec_prime() // on les definit juste pour les utiliser dans commandes_domicil et surplace.
	;

	public String getType()
	{
		return this.type;
	}
	public Client getClient()
	{
		return this.client;
	}
	public LocalDate getDateConsommation()
	{
		return this.Date_Consommation;
	}
	public  LocalTime getHeure_Consommation()
	{
		return this.Heure_Consommation;
	}
}
