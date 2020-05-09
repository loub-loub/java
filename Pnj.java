import java.util.Random;
import java.util.Scanner;

public class Pnj extends Personnage {
	
	


	public char nom;
	public int Pv=100;
	public int posx;
	public int posy;
	public int level;
    public int force;
    public int adresse;
    public int endurence;
    
    /*
    public String initiative;
    public String attaque;
    public String defense;
    public String degats;
	*/
	
public Pnj(char nom,int x,int y,int force,int adresse,int endurance) {
		
		this.nom=nom;
		this.posx=x;
		this.posy=y;
		this.level = 5;
		this.force=force;
		this.adresse=adresse;
		this.endurence=endurance;
		
	
	}

	
//Caracteristiques
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

    
    
    
 //actions pnj
 
 public void attaquerPnj(Univers m,PJ j,Pnj M) {
 	
 	
 	
 	boolean attval = false;
 	do {
 		
 		if(  m.case1(M.getPosx(),M.getPosy())==1  ){  // modifier
 			if(M.attaque() > j.esquiver()) {
 				if(j.defendre() < M.attaque()) {
 					j.setPv(j.getPv()-M.attaque()-j.defendre());
 				}
 				
 			}
 			else {
 				
 			}
 			
 		attval =true;	
 		
 		}
 		else {
 			
 		}
 		
 		break;
 	}while(attval == false);
 
 }


 
 public void seDeplacerPnj(Univers m,PJ a,Pnj b) {
	 int xj=a.getPosx();
	 int yj=a.getPosy();
	
	 /* */if( xj != b.getPosx() || b.getPosx() !=  xj  ){
		 DeplacementX(m,a,b);
	 }
	
	 else if( yj != b.getPosy()  || yj != b.getPosy()) {
		 DeplacementY(m,a,b);
	 }
	 else {
		 
	 }
	
 }
  
public void DeplacementX(Univers m,PJ a,Pnj b) {
	int xj=a.getPosx();	
	//haut
	if(b.getPosx()-xj > 0){
		m.setPerso(b.getPosx(),b.getPosy(),'w');
		 b.setPosx(b.getPosx()-1);
		 m.setPerso(b.getPosx(),b.getPosy(),b.getNom());
	}
	//bas
	else if(xj-b.getPosx() > 0){
		m.setPerso(b.getPosx(),b.getPosy(),'w');
		 b.setPosx(b.getPosx()+1);
		 m.setPerso(b.getPosx(),b.getPosy(),b.getNom());
	}
	 
}

public void DeplacementY(Univers m,PJ a,Pnj b){
	 
	 int yj=a.getPosy();
	 //gauche
	 if( yj+1 < b.getPosy()) {
		 m.setPerso(b.getPosx(),b.getPosy(),'w');
		 b.setPosy(b.getPosy()-1);
		 m.setPerso(b.getPosx(),b.getPosy(),b.getNom());
	 }
	 //droite
	 else if(yj-b.getPosy()-1 > 0) {
		 m.setPerso(b.getPosx(),b.getPosy(),'w');
		 b.setPosy(b.getPosy()+1);
		 m.setPerso(b.getPosx(),b.getPosy(),b.getNom());
	 }
	 
	
	
}
 
 
 //getter setter
	public char getNom() {
		return nom;
	}


	public void setNom(char nom) {
		this.nom = nom;
	}


	public int getPv() {
		return Pv;
	}


	public void setPv(int pv) {
		Pv = pv;
	}


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


	
	
	@Override
	public String toString() {
		return "Pnj [nom=" + nom + ", Pv=" + Pv + ", posx=" + posx + ", posy=" + posy + ", level=" + level + ", force="
				+ force + ", adresse=" + adresse + ", endurence=" + endurence + "]";
	}


	
	public int getForce() {
		return force;
	}


	public void setForce(int force) {
		this.force = force;
	}


	public int getAdresse() {
		return adresse;
	}


	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}


	public int getEndurence() {
		return endurence;
	}


	public void setEndurence(int endurence) {
		this.endurence = endurence;
	}

	
	
	
}
