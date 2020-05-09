import java.util.ArrayList;

// a finir
public class Objet {
	//attribut
	public int x;
	public int y;
	public char nom;
	
	
	
	
	// constructeur modifier
	
	
	public Objet() {
		
	}
	
public Objet(char nom,int x,int y){
		
		this.nom=nom;
		this.x=x;
		this.y=y;
	}
	
	
	// getter setter

	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getNom() {
		return nom;
	}
	public void setNom(char nom) {
		this.nom = nom;
	}
	

}
