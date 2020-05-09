import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Personnage {
    
    //attribut
    public int level;
    public String nom;
    public boolean type;
    public int force;
    public int adresse=100;
    public int endurence=100;
    public Armes a;
    public Armures b;
    public int objetArmure;
    public int pa;
    public String blessure; 
    private ArrayList<Objet> inventaire;
    
//0625637615

    /*
    public String initiative;
    public String attaque;
    public String defense;
    public String degats;
    
*/


    //constructeur

    public Personnage() {
    	this.pa=30;
    	this.inventaire= new ArrayList<Objet>();
    }

    
    public ArrayList<Objet> getInventaire(){
    	return inventaire;
    }
    
    public void setInventaire(ArrayList<Objet> inventaire){
    	this.inventaire= inventaire;
    }
    
    public void afficherInventaire() {
    	if(inventaire.size()==0) 
    		System.out.println("L'inventaire est vide !");
    	else { for(int i=0; i<inventaire.size();i++) {
    		if(inventaire.get(i) instanceof Armes)
    			System.out.println(i+1+"-Armes");
    			
    		if(inventaire.get(i) instanceof Armures)
    			System.out.println(i+1+"-Armures");
    		
    	
    			
    			
    	}	
      
      }
    	
    }
    
    
    public int tirage(){
        int x;
        Random r = new Random();
        x =r.nextInt(6)+1;
        return x;
    }

 
 //methodes
    
    //blessure
    
    public void niveauxblessure(PJ j,Pnj pnj){
        if(j.getPv()< 90 || pnj.getPv() < 90) {
            j.setBlessure("Blessures superficielles");
        }
        else if(j.getPv()< 70 || pnj.getPv() < 70){
            j.setBlessure("Légèrement blessé");
        }
        else if(j.getPv()< 55 || pnj.getPv() < 55) {
            j.setBlessure("Blessé");
        }
        else if(j.getPv()< 25 || pnj.getPv() < 25) {
            j.setBlessure("Gravement blessé");
        }
        else if(j.getPv()< 0 || pnj.getPv() < 0) {
            j.setBlessure("Mort");
        }
        else {
            
        }
    }
 
 //methodes

    
    //Actions
    public void attaquer(Univers m,PJ j,Pnj M) {
    	
    	System.out.println("Voulez vous attaquer : 1 - Oui \n 2 - Non ");
    	Scanner sc = new Scanner(System.in);
    	int n;
    	boolean attval = false;
    	do {
    		n = sc.nextInt();
    		if( n == 1 && m.caseM(j.getPosx(),j.getPosy())==1  ){
    			if(j.attaque() > M.esquiver()) {
    				//determination des blessures
    				M.setPv(M.getPv()-20);
    			}
    			else {
    				
    			}
    			
    		attval =true;	
    		}
    		
    		
    	}while(attval == false);
    
    }

   
    
    public void seDeplacer(Univers m,PJ j) {
    	//Attention x = position d'avant
    	
    	System.out.println("Vous etes a la position :  x : " + j.getPosx() + " y : " + j.getPosy() );
    	Scanner sc = new Scanner(System.in);
    	int n;
    	boolean dval = false;
    	System.out.println(" Déplacer vous : \n 1 - à gauche \n 2 - à droite \n 3 - en bas \n 4 - en haut");
    	do {
    		
    		n = sc.nextInt();		
    		
    		if(n == 1 && m.deplacementvalide(j.getPosx(),j.getPosy()-1) ){  
    				System.out.println("Deplacement correct");
    				m.setPerso(j.getPosx(),j.getPosy(),'x');
    				j.setPosx(j.getPosx());
    				j.setPosy(j.getPosy()-1);
    				m.setPerso(j.getPosx(),j.getPosy(),j.getNom());
    				dval=true;
    				break;
    
    		}
    		
    		else if(n == 2 && m.deplacementvalide(j.getPosx(),j.getPosy()+1) ){  
				System.out.println("Deplacement correct");
				m.setPerso(j.getPosx(),j.getPosy(),'x');
				j.setPosx(j.getPosx());
				j.setPosy(j.getPosy()+1);
				m.setPerso(j.getPosx(),j.getPosy(),j.getNom());
				dval=true;
				break;

		}
    		
    		else if(n == 3 && m.deplacementvalide(j.getPosx()+1,j.getPosy()) ){  
				System.out.println("Deplacement correct");
				m.setPerso(j.getPosx(),j.getPosy(),'x');
				j.setPosx(j.getPosx()+1);
				j.setPosy(j.getPosy());
				m.setPerso(j.getPosx(),j.getPosy(),j.getNom());
				dval=true;
				break;

		}
    		
    		
    		else if(n == 4 && m.deplacementvalide(j.getPosx()-1,j.getPosy()) ){  
				System.out.println("Deplacement correct");
				m.setPerso(j.getPosx(),j.getPosy(),'x');
				j.setPosx(j.getPosx()-1);
				j.setPosy(j.getPosy());
				m.setPerso(j.getPosx(),j.getPosy(),j.getNom());
				dval=true;
				break;

		}
		else {
			System.out.println("Votre joueur n'a pas été deplacé");
			break;
		}
    	}while(dval == false);
    	
        
        
        }
     
    public void ramasserObjet(Univers m, PJ p) {
    	if(m.getCase(p.getPosx(), p.getPosy()).getC().size()==0) //verifier si il y a un objet a cote du joueur
    		System.out.println("Il n'y a pas d'objets dans cette case");
    	
    	else {
    		System.out.println("Il y a un objet");
    		for(int i=0;i<m.getCase(p.getPosx(),p.getPosy()).getC().size();i++) {
    			
    			if(m.getCase(p.getPosx(),p.getPosy()).getC().get(i) instanceof Armes) {
    				Objet o=m.getCase(p.getPosx(), p.getPosy()).getC().get(i);
    				this.inventaire.add(o);
    				System.out.println("Vous avez ramassé une arme");
    				m.getCase(p.getPosx(),p.getPosy()).getC().remove(i);
    			}
    			else if(m.getCase(p.getPosx(),p.getPosy()).getC().get(i) instanceof Armures){
    				Objet o=m.getCase(p.getPosx(), p.getPosy()).getC().get(i);
    				this.inventaire.add(o);
    				System.out.println("Vous avez ramassé une armures");
    				m.getCase(p.getPosx(),p.getPosy()).getC().remove(i);
    				
    			}
    			else if(m.getCase(p.getPosx(),p.getPosy()).getC().get(i) instanceof Potions){
    				Objet o=m.getCase(p.getPosx(), p.getPosy()).getC().get(i);
    				this.inventaire.add(o);
    				System.out.println("Vous avez ramassé une Potion");
    				m.getCase(p.getPosx(),p.getPosy()).getC().remove(i);
    				
    			}
    			
    			
    		}
    	}
    	
    	
    	if(inventaire.size()!=0) {
    		System.out.println("inventaire non vide");
    	}
    	
    }
    
    public void mortPnj(Univers m,Pnj b){
    	if(b.getPv()<0){
			PersoNJ.pnj.remove(b);
			m.setPerso(b.getPosx(),b.getPosy(),' ');
		}
    }

    public void creerPersonnage(PJ j) {
        
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir le nom du personnage : \n");
        String str = sc.nextLine();
        
        //Armure personnage

        Scanner sc1 = new Scanner(System.in);
        int str1;
        System.out.println("Choisir une armure : 1 pour kimono \n 2 pour cape \n 3 pour armure");
            do{
             str1 = sc.nextInt();
                if(str1 == 1){
                    System.out.println("Vous avez choisi le kimono ");
                    //ajouter l'armure...;
                }

                else if( str1 == 2){
                    System.out.println("Vous avez choisi la cape ");
                    //ajouter l'armure...;
                }
                else if(str1 == 3){
                    System.out.println("Vous avez choisi la cape ");
                    //ajouter l'armure...;
                }

                else if( str1 != 1 && str1 != 2 && str1 != 3){
                    System.out.println("Erreur !!! \n Choisir une armure : 1 pour kimono \n 2 pour cape \n 3 pour armure");    
                }

        }while(str1 != 1 && str1 != 2 && str1 !=3);
        
        //Armes personnage

        System.out.println("Choisir une arme : 1 pour Shuriken \n 2 pour pistolet \n 3 pour epée");
            do{
             str1 = sc.nextInt();
                if(str1 == 1){
                    System.out.println("Vous avez choisi les Shuriken ");
                    //ajouter une arme...;
                }

                else if( str1 == 2){
                    System.out.println("Vous avez choisi le pistolet ");
                    //ajouter une arme...;
                }
                else if(str1 == 3){
                    System.out.println("Vous avez choisi l'epée ");
                    //ajouter une arme...;
                }
                
                else if( str1 != 1 && str1 != 2 && str1 != 3){
                    System.out.println("Erreur !!! \n Choisir une arme : 1 pour Shuriken \n 2 pour pistolet \n 3 pour epée");
                    
                }

        }while(str1 != 1 && str1 != 2 && str1 !=3);
        //    j.repartirDegres(j);
            
        sc1.close();

        //repartir degres personnage
        
        

        //Sauvegarder personnage dans un fichier

    }
    //
    public void utiliserObjet() {
    }
    
    public void tourJ(Univers m,PJ j,Pnj b) {
   	 int i;
   		Scanner sc = new Scanner(System.in);
   		do {
   			
   			System.out.println("choisir une action entre 1, 2 et 3 \n 1. se deplacer\n 2. ramasser objet \n 3.Afficher inventaire \n 4.Equiper \n 5.Attaquer");
   			
   			
   			i = sc.nextInt();
   			if(i==1) {
   				seDeplacer(m,j);
   				
   			}
   			else if(i==2) {
   				ramasserObjet(m,j);
   			}
   			
   			else if(i==3) {
   				afficherInventaire();
   			}
   			
   			else if(i==4) {
   				equiper(j);
   			}
   			else if(i==5) {
   				attaquer(m,j,b);
   			}
   			m.afficher();
   			break;
   		}while(i != 1 || i != 2 || i != 3 || i != 4 || i != 5);
   		
   	}	
   	

    public void tourM(Univers m,PJ j,Pnj a1) {
   	 int i=0;
   	 do{
   		
   				a1.seDeplacerPnj(m,j,a1);
   				a1.attaquerPnj(m,j,a1);
   		m.afficher();
   		 i++;
   	 }while(i<1);
   }
   	


    //
    public void deposerObjet() {
    	
    	
    }
    
    public void equiper(PJ pj) {
    	this.afficherInventaire();
    	Scanner sc = new Scanner(System.in);
    	int c;
    	do { System.out.println("Veuillez choisir un objet entre 1 et "+ this.inventaire.size());
    	c= sc.nextInt();
    	}while(c<1 || c>this.inventaire.size());
    	this.utiliserObjet(this.inventaire.get(c-1), pj);
    }
    
    
    public void utiliserObjet(Objet o, PJ pj) {
    	Scanner sc = new Scanner(System.in);
    	int c;
    	if(o instanceof Armes ) {
    		do {
    			System.out.println("Mettre dans la main droite 1 , gauche 2");
    			c=sc.nextInt();
    			if(c==1) {
    				if(pj.getMainDroite()==null){
    					pj.setMainDroite(o);
    					this.inventaire.remove(o);
    				}
    				else {
    					this.inventaire.add(pj.getMainDroite());
    					pj.setMainDroite(o);
    					this.inventaire.remove(o);
    					}
    				}
    		
    			else if(c==2) {
    				if(pj.getMainGauche()==null) {
    					pj.setMainGauche(o);
    					this.inventaire.remove(o);
    				}
    				else {
    					this.inventaire.add(pj.getMainGauche());
    					pj.setMainGauche(o);
    					this.inventaire.remove(o);
    				}
    			}
    	}while(c!=1 && c!=2);
    	}else if (o instanceof Armures) {
    		if(pj.getArmures()!=null)
    			pj.setArmures((Armures)o);
    		else {
    			this.inventaire.add(pj.getArmures());
    			pj.setArmures((Armures)o);
    		}
    	}
    	else if(o instanceof Potions) {
    		if(pj.getPv()<18) {
    			int a=pj.getPv();
    			Potions p=(Potions)o;
    			a=a+p.getSante();
    			if(a>18)
    				pj.setPv(18);
    			else
    				pj.setPv(a);
    		}
    	}
    }

    //
    public void passerSonTour() { 
      System.out.println("Vous passez votre tour");
    }


    
    
    
    
    
	public String getBlessure() {
		return blessure;
	}


	public void setBlessure(String blessure) {
		this.blessure = blessure;
	}


	@Override
	public String toString() {
		return "Personnage [pa=" + pa + ", blessure=" + blessure + ", inventaire=" + inventaire + "]";
	}






//getter setter





}
