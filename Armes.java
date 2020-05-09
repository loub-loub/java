
public class Armes extends Objet {
	
	public int maniabiliteArme; //maniabilité arme
	public int impactArme;  //impact arme utilisée
	
	public Armes(){
		
	}
	
	public Armes(char nom,int m, int i){
		this.nom=nom;
		this.maniabiliteArme=m;
		this.impactArme=i;
		
	}
	
	
	public void placerArmes(int i, int j, Univers u) {
		u.getCase(i, j).getC().add(this);
	}
	@Override
	public String toString() {
		return "Armes [nom=" + nom + ", maniabiliteArme=" + maniabiliteArme + ", impactArme=" + impactArme + "]";
	}

	public char getNom() {
		return nom;
	}

	public void setNom(char nom) {
		this.nom = nom;
	}

	public int getManiabiliteArme() {
		return maniabiliteArme;
	}

	public void setManiabiliteArme(int maniabiliteArme) {
		this.maniabiliteArme = maniabiliteArme;
	}

	public int getImpactArme() {
		return impactArme;
	}

	public void setImpactArme(int impactArme) {
		this.impactArme = impactArme;
	}
	
}
