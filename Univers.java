
public class Univers {
	
	public Case [][]map;
	public int longueur;
	public int largeur;
	
	
	
	public Univers(int n, int m) {
	        this.longueur=n;
	        this.largeur=m;
	map = new Case[longueur][largeur];
	for(int i=0; i<longueur;i++) {
		for(int j=0; j<largeur; j++) {
			map[i][j]= new Case();
			if(i == 0 || j == 0 || i==longueur-1 || j==largeur-1 ) {
				map[i][j].setTypeobjet('#');
				
	}
			else {
				map[i][j].setTypeobjet(' ');
			}
	            
	      }
	}

}
	
	public Case getCase(int i , int j) {
		return this.map[i][j];
	}
	
	public void setCase(Case c, int i , int j) {
		this.map[i][j]=c;
	}
	
	
	public char getTypeObjet(int i, int j) {
		return this.map[i][j].getTypeobjet();
	}
	

	public void setTypeObjet(char c, int i,int j) {
		this.map[i][j].setTypeobjet(c);
	}
	
	public boolean caseMonster(int i,int j){
        //a gauche
      if(this.getCase(i,j).getTypeobjet()=='M')
    	  return true;
      else
    	  return false;

	}
	
	
 public Case[][] getMap(){
	 return this.map;
 }

 
 
	public void placerobj(int l,int h, char t) {
        if( l<0 || h<0 || l>longueur || h>largeur) {
            System.out.println("Erreur");
        }
        
        if(map[l][h].getTypeobjet()==' ') {
        	map[l][h].setTypeobjet(t);
        }
        else {
            System.out.println("Erreur de placement");
        }
        
    }
	
	public void placermur() {
		placerobj(3,4,'#');
        placerobj(3,5,'#');
        placerobj(3,6,'#');
        placerobj(4,11,'#');
        placerobj(4,12,'#');
        placerobj(4,13,'#');
        placerobj(4,14,'#');
        
        placerobj(4,4,'#');
        placerobj(5,4,'#');
        
        placerobj(8,6,'#');
        placerobj(8,7,'#');
        placerobj(8,8,'#');
        
        
        placerobj(9,6,'#');
        placerobj(9,8,'#');
        placerobj(10,6,'#');
        placerobj(10,8,'#');
        
        placerobj(11,6,'#');
        placerobj(11,8,'#');
    
        placerobj(11,11,'#');
        placerobj(11,12,'#');
        placerobj(11,13,'#');
        placerobj(11,14,'#');
        int nbc=5;
        
        for(int f=1;f<nbc;f++) {
            placerobj(2,f,'#'); 
        }
	}
	
	public void placerjoueur(int x,int y,char t) {
		placerobj(x,y,t);	       
	}
	
	
 public void initMap() {
	 
	 for(int i=0; i<longueur; i++) {
		 for(int j=0; j<largeur; i++) {
			  if(i == 0 || j == 0 || i==longueur-1 || j==largeur-1 ) {
              	
                  this.map[i][j].setTypeobjet('#');
              }
              else{
              	
            	  this.map[i][j].setTypeobjet(' ');
              }
              
		 }
	 }
 }
 

	

 public boolean estCaseValide(int i , int j) {
	 
	 if (i<longueur && j<largeur && this.map[i][j].getTypeobjet()== ' ') {
		 return true;
	 }
	 else return false;
 
 
}

 public int caseM(int i,int j){
     //a gauche
     if( map[i][j-1].getTypeobjet()=='M'){
         System.out.println("Monstre");
         return 1;
     }
     // a droite
     else if( map[i][j+1].getTypeobjet()=='M'){
         System.out.println("Monstre");
         return 1;
     }
     //en bas
     else if( map[i+1][j].getTypeobjet()=='M'){
         System.out.println("Monstre");
         return 1;
         }
         //en haut
     else if(map[i-1][j].getTypeobjet()=='M'){
         System.out.println("Monstre");
         return 1;
         }

     else{
         System.out.println("il y a pas de monstre");
         return 2;
         }

 }

 
 public int case1(int i,int j){
     //a gauche
     if( map[i][j-1].getTypeobjet()=='1'){
         System.out.println("Monstre");
         return 1;
     }
     // a droite
     else if( map[i][j+1].getTypeobjet()=='1'){
         System.out.println("Monstre");
         return 1;
     }
     //en bas
     else if( map[i+1][j].getTypeobjet()=='1'){
         System.out.println("Monstre");
         return 1;
         }
         //en haut
     else if(map[i-1][j].getTypeobjet()=='1'){
         System.out.println("Monstre");
         return 1;
         }

     else{
         System.out.println("il y a pas de joueur");
         
         return 2;
         }

 }
 
public boolean estDeplacementValide(int i, int j) {
	
	if(this.estCaseValide(i, j) || this.map[i][j].getTypeobjet()=='#') {
		return true;
	}
	else return false;
} 


public boolean estDeplacementValideM(int i, int j) {
	
	if(this.estCaseValide(i, j) || this.map[i][j].getTypeobjet()=='#' || this.map[i][j].getTypeobjet()=='1') {
		return true;
	}
	else return false;
} 


public boolean deplacementvalide(int i,int j){
	
	if(map[i][j].getTypeobjet() =='#' || map[i][j].getTypeobjet() == 'M'  ) {
		System.out.println("Deplacement invalide");
		return false;
	}
	else {
		return true;
	}
	
}

public int deplacementvalideM(int i,int j){
	
	if(map[i][j].getTypeobjet() =='#' || map[i][j].getTypeobjet() == '1'  ) {
		System.out.println("Deplacement invalide");
		return 2;
	}
	else {
		return 1;
	}
	
}

public int caseE(int i,int j){
    //a gauche
    if( map[i][j-1].getTypeobjet() =='E'){
        System.out.println(" potion");
        return 1;
    }
    // a droite
    else if( map[i][j+1].getTypeobjet() =='E'){
        System.out.println(" potion");
        return 1;
    }
    //en bas
    else if( map[i+1][j].getTypeobjet() =='E'){
        System.out.println(" potion");
        return 1;
        }
        //en haut
    else if(map[i-1][j].getTypeobjet() =='E'){
        System.out.println(" potion");
        return 1;
        }

    else{
        System.out.println("il y a pas de potion");
        return 2;
        }

}

public int caseS(int i,int j){
    //a gauche
    if(map[i][j-1].getTypeobjet() =='S' ){
        System.out.println(" potion");
        return 1;
    }
    // a droite
    else if(map[i][j+1].getTypeobjet() =='S' ){
        System.out.println(" potion");
        return 1;
    }
    //en bas
    else if(map[i+1][j].getTypeobjet() =='S' ){
        System.out.println(" potion");
        return 1;
        }
        //en haut
    else if(map[i-1][j].getTypeobjet() =='S' ){
        System.out.println(" potion");
        return 1;
        }

    else{
        System.out.println("il y a pas de potion");
        return 2;
        }

}



public int caseO(int i,int j){
    //a gauche
    if( map[i][j-1].getTypeobjet()=='F'){
        System.out.println("Monstre");
        return 1;
    }
    // a droite
    else if( map[i][j+1].getTypeobjet()=='F'){
        System.out.println("Monstre");
        return 1;
    }
    //en bas
    else if( map[i+1][j].getTypeobjet()=='F'){
        System.out.println("Monstre");
        return 1;
        }
        //en haut
    else if(map[i-1][j].getTypeobjet()=='F'){
        System.out.println("Monstre");
        return 1;
        }

    else{
        System.out.println("il y a pas de monstre");
        return 2;
        }

}



public void afficher() {
    System.out.println();
    for(int i=0;i<longueur;i++) {
        for(int j=0;j<largeur;j++) {
           System.out.print(" | " + map[i][j] );
        }
        System.out.println(" | ");
        
    }
    System.out.println();
}

public void setPerso(int x,int y,char t){
	map[x][y].setTypeobjet(t);
}


public void placerArmes(int x,int y,char t) {
	placerobj(x,y,t);	       
}

}


