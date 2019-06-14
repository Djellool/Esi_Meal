package Classes ;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Commande_domicil extends Commande implements Reduction,Serializable {
	private String Adresse_livraison;
	private int distance;
	private Panier panier;

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commande_domicil(Client client, LocalDate Date_consommation, LocalTime Heure_consommation,
							int nb_personne, String Adresse_livraison, int distance, Panier panier) {
		super(client,"Domicil",Date_consommation, Heure_consommation, nb_personne);
		this.Adresse_livraison = Adresse_livraison;
		this.distance = distance;
		this.panier = panier;
	}

	public int getDistance() {
		return distance;
	}

	public int Prix_Commande() {
		return (panier.CalculerNote());
	}
	public boolean isValide()
	{
		boolean valide = false;
		LocalTime lt = LocalTime.now();
		if(Heure_Consommation.minusMinutes(90).isAfter(LocalTime.now()) && Heure_Consommation.isBefore(LocalTime.parse("00:00")))
		{
			if(distance<20)
			{
				valide = true;
			}
		}
		return valide;
	}

	public float Note_avec_prime() {
		float note = Prix_Commande();
		if (super.client.isFidele()) {
			Client_Fidele e = (Client_Fidele) super.client;
			if (e.isEtudiant())//le client est un etudiant.
			{
				note = note - note * ((primeetudiant + primefidelite) / 100) + montantkilolivraison * getDistance();
			} else {
				note = note - note * ((primefidelite) / 100) + montantkilolivraison * getDistance();
			}
		} else//le client n'est pas fidele.
		{
			note = note + montantkilolivraison * getDistance();
		}
		return note;
	}
	@Override
	public int compareTo(Object o) {
		return super.compareTo((Commande) o);
	}
}
