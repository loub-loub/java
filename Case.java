import java.util.ArrayList;

public class Case {
	
	private char typeobjet;
	public int nbobj=0;
	private ArrayList<Objet> obj = new ArrayList<Objet>();
	 
	public Case() {
		obj=new ArrayList<Objet>();
	}
	
	
	public ArrayList<Objet> getC() {
		return obj;
	}
	
	public void setC(ArrayList<Objet> obj) {
		this.obj=obj;
	}
	
	public char getTypeobjet() {
		return typeobjet;
	}
	public void setTypeobjet(char typeobjet) {
		this.typeobjet = typeobjet;
	}
	public int getNbobj() {
		return nbobj;
	}
	public void setNbobj(int nbobj) {
		this.nbobj = nbobj;
	}
	
	
		public String toString() {
	return "" + typeobjet;
}
}