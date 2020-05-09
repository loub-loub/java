
public class Potions extends Objet{
	
	
	public int Sante;
	public int degatsE;
	
	public Potions(char nom,int sante,int degatsE) {
		this.nom=nom;
		this.Sante=sante;
		this.degatsE=degatsE;
	}

	
	//getter setter
	public char getNom() {
		return nom;
	}

	public void setNom(char nom) {
		this.nom = nom;
	}

	public int getSante() {
		return Sante;
	}

	public void setSante(int sante) {
		Sante = sante;
	}

	public int getDegatsE() {
		return degatsE;
	}

	public void setDegatsE(int degatsE) {
		this.degatsE = degatsE;
	}
	
	

}
