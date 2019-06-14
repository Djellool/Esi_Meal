package Classes;
import sample.Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Client_Fidele extends Client implements Serializable
{
	private String Code_fidelite;
	private ArrayList<String> Adresses=null;
	private int Nb_Commandes=0;
	private boolean etudiant ;
    public String MotDePasse;
    public Boolean Conennexion;

    public Client_Fidele(String nom, String Prenom, String Num_telephone, boolean fidele, ArrayList<String> adresse, int nb_Commandes, boolean etudiant, String motDePasse) {
        super(nom, Prenom, Num_telephone, fidele);
        Code_fidelite = Integer.toString(Main.Esi.LesClients.size()+10000);
        this.Adresses = adresse;
        setNb_Commandes();
        this.etudiant = etudiant;
        MotDePasse = motDePasse;
    }

    public String getCode_fidelite() {
		return Code_fidelite;
	}
	public void setCode_fidelite(String code_fidelite) {
		Code_fidelite = code_fidelite;
	}
	public String getAdresses() {
		return Adresses.get(Adresses.size()-1);
	}
	public void setAdresses(String adresses) { Adresses.add(adresses); }
	public int getNb_Commandes() {
		return Nb_Commandes;
	}
	public void setNb_Commandes() {
		Nb_Commandes = Nb_Commandes+1;
	}
	public boolean isEtudiant() {
		return etudiant;
	}

	public void setEtudiant(boolean etudiant) {
		this.etudiant = etudiant;
	}
	public void increment_NbCommandes()
	{
		this.Nb_Commandes = this.Nb_Commandes + 1;
	}
	public void Ajout_Adresse(String Adresse)
	{
		this.Adresses.add(Adresse);
	}
	public void ajouter_Adresse(String adress)
	{
		this.Adresses.add(adress);
	}
}
