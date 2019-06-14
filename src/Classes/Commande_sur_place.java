package Classes ;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Commande_sur_place extends Commande implements Reduction,Comparable,Serializable
{
	private TTable type_table;
	private Panier panier;
	public Commande_sur_place(Client client, LocalDate Date_consommation, LocalTime Heure_consommation,
							  int nb_personne, TTable type_table, Panier panier) {
		super(client,"Surplace",Date_consommation, Heure_consommation, nb_personne);
		this.type_table = type_table;
		this.panier = panier;
	}
	public TTable getType_table() {
		return type_table;
	}
	public void setType_table(TTable type_table) {
		this.type_table = type_table;
	}
	public int Prix_Commande()
	{
		return (panier.CalculerNote());
	}
	public float Note_avec_prime()
	{
		float note = Prix_Commande() ;
		if(this.type_table == TTable.Exterieur)
		{
			if(nb_personne >= 4)
			{
				if(super.client.isFidele())
				{
					Client_Fidele e = (Client_Fidele)super.client;
					if(e.isEtudiant())//le client est un etudiant.
					{
						note = note - note*((primeetudiant+primefidelite+primegroupedomicile)/100)
						+note*(primetableexterieur/100) ;
					}
					else
					{
						note = note - note*((primefidelite+primegroupedomicile)/100)
								+note*(primetableexterieur/100);
					}
				}
				else//le client n'est pas Fidele.
				{
					note = note - note*((primegroupedomicile)/100) +note*(primetableexterieur/100);
				}
			}
			else
			{
				note = note + note*((primetableexterieur)/100);
			}
		}
		return note;
	}

	@Override
	public int compareTo(Object o)
	{
		return super.compareTo((Commande) o);
	}
}
