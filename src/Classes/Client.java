package Classes ;

import java.io.Serializable;

public class Client implements Serializable
{
	private String nom;
	private String Prenom ;
	private String Num_telephone;

	public boolean isFidele() {
		return fidele;
	}

	public void setFidele(boolean fidele) {
		this.fidele = fidele;
	}

	private boolean fidele ;
	public Client(String nom,String Prenom,String Num_telephone,boolean fidele)
	{
		this.nom = nom;
		this.Prenom = Prenom;
		this.Num_telephone = Num_telephone;
		this.fidele = fidele;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNum_telephone() {
		return Num_telephone;
	}
	public void setNum_telephone(String num_telephone) {
		Num_telephone = num_telephone;
	}
	public void afficher_Client()
	{
		System.out.println(this.nom + " " + this.Prenom + " " + this.Num_telephone);
	}
}

