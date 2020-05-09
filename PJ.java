import java.util.Random;

public class PJ extends Personnage{
	
	public char nom;
	public Objet mainGauche;
	public Objet mainDroite;
	public int Pv=100;
	public Armures armure;
	
	public Armures getArmures() {
		return armure;
	}

	public void setArmures(Armures armure) {
		this.armure = armure;
	}

	public int posx;
	public int posy;
	
	/* heriter de Personnage
	 *Force
	 *Adresse 
	 *endurance
	 */
	/*  Caracteristiques
	 * esquiver
	 * attaque
	 * defense
	 * calculdegats
	 * initiative
	 * */
	
	
	//constructeur
	public PJ() {
		
	}
	
	public Objet getMainGauche() {
		return mainGauche;
	}

	public void setMainGauche(Objet mainGauche) {
		this.mainGauche= mainGauche;
	}
	
	public Objet getMainDroite() {
		return mainGauche;
	}

	public void setMainDroite(Objet mainGauche) {
		this.mainGauche= mainGauche;
	}
	
	public PJ(char nom,int x,int y,int force,int adresse,int endurance) {
		
		this.nom=nom;
		this.posx=x;
		this.posy=y;
		this.level = 3;
		this.force=force;
		this.adresse=adresse;
		this.endurence=endurance;
		
	
	}
	
	
	
	// Caracteristiques
	public int esquiver() {
    	int x;
    	int i=0;
    	int a=this.adresse/3;
    	int b=this.adresse%3;
    	int t;
    	int res=0;
    	do {
    		t=tirage();
    		res+=t;
    		
    		i++;
    	}while(i<a);
    	
    	
    	x=res-3/*-armeequipe*/+b; 
    	return x;
    
    }

    
    public int defendre() {
    	int x;
    	int i=0;
    	int a=this.endurence/3;
    	int b=this.endurence%3;
    	int t;
    	int res=0;
    	do {
    		t=tirage();
    		res+=t;
    		
    		i++;
    	}while(i<a);
    	
    	
    	x=res+3/*+armeequipe*/+b;
    	return x;
    }

    
    public int initiative() {
    	int x;
    	int i=0;
    	int a=this.adresse/3;
    	int b=this.adresse%3;
    	int t;
    	int res=0;
    	do {
    		t=tirage();
    		res+=t;
    		
    		i++;
    	}while(i<a);
    	
    	
    	x=res-3/*-armeequipe*/+b;
    	return x;
    }
    

    public int attaque(){
    	int x;
    	int i=0;
    	int a=this.adresse/3;
    	int b=this.adresse%3;
    	int t;
    	int res=0;
    	do {
    		t=tirage();
    		res+=t;
    		
    		i++;
    	}while(i<a);
    	
    	
    	x=res+3/*+armeequipe*/+b;
    	return x;
    }
    
    public int calculDegats() {
    	int x;
    	int i=0;
    	int a=this.force/3;
    	int b=this.force%3;
    	int t;
    	int res=0;
    	do {
    		t=tirage();
    		res+=t;
    		
    		i++;
    	}while(i<a);
    	
    	
    	x=res+3/*+armeequipe*/+b;
    	return x;
    }

	
	
	
	//getter setter tostring
	
    public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public char getNom() {
		return nom;
	}
	public void setNom(char pj) {
		nom = pj;
	}



	public void setPv(int pv) {
		Pv = pv;
	}

	@Override
	public String toString() {
		return "PJ [nom=" + nom + ", Pv=" + Pv + ", posx=" + posx + ", posy=" + posy + ", force=" + force + ", adresse="
				+ adresse + ", endurence=" + endurence + "]";
	}

	public int getPv() {
		return Pv;
	}
}
