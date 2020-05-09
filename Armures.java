
public class Armures extends Objet {
	
	public int encombrementVetements; // encombrement vêtements
	public int soliditeVetements;  //solidité vêtements
	
	
	public  Armures(){
		
	}
	
	public Armures(char nom,int x,int y, int e,int s){
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.encombrementVetements=e;
		this.soliditeVetements=s;
	}
	
	
	public int getEncombrementVetements() {
		return encombrementVetements;
	}
	public void setEncombrementVetements(int encombrementVetements) {
		this.encombrementVetements = encombrementVetements;
	}
	public int getSoliditeVetements() {
		return soliditeVetements;
	}
	public void setSoliditeVetements(int soliditeVetements) {
		this.soliditeVetements = soliditeVetements;
	}

	@Override
	public String toString() {
		return "Armures [encombrementVetements=" + encombrementVetements + ", soliditeVetements=" + soliditeVetements
				+ "]";
	}

}
