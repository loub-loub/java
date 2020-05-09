import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MAP
		

		Armes arm = new Armes();
		Personnage p = new Personnage();
		PJ j = new PJ('1',3,3,15,8,9);
	
		
		Univers m = new Univers(16,16);
	
		
		Objet o = new Objet('Z',4,5);
		Armes Pistolet = new Armes('P',5,4);
		Armes Pistolet2 = new Armes('X',5,2);
		Potions Soins = new Potions('s',20,0);
		
		ObjetP.obj.add(Pistolet);
		ObjetP.obj.add(Pistolet2);
		
		ObjetP.obj.add(Soins);
		
		Pnj ti = new Pnj('M',8,3,5,5,5);
		Pnj tz = new Pnj('C',7,10,7,6,5);
		
		PersoNJ.pnj.add(ti);
		PersoNJ.pnj.add(tz);
		
		m.placermur();
		/*m.afficher();
		m.placermur();
		m.afficher();*/
		//m.deplacementvalide(1,3);
		m.placerjoueur(j.getPosx(),j.getPosy(),j.getNom());
		Pistolet.placerArmes(6, 5, m);
		m.placerjoueur(o.getX(),o.getY(),o.getNom());
		m.placerjoueur(ti.getPosx(),ti.getPosy(),ti.getNom());
		m.placerjoueur(tz.getPosx(),tz.getPosy(),tz.getNom());
		m.placerobj(5,3,'P');
		Pistolet.placerArmes(5,3, m);
		m.placerobj(5,2,'X');
		Pistolet2.placerArmes(5,2, m);
		
		m.afficher();
		/*int i=0;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("choisir une action entre 1, 2 et 3 \n 1. se deplacer\n 2. ramasser objet \n 3.Afficher inventaire \n 4.Equiper \n 5.Utiliser");
			
			
			i = sc.nextInt();
			if(i==1) {
				p.seDeplacer(m,j);
				
			}
			else if(i==2) {
				p.ramasserObjet(m,j);
			}
			
			else if(i==3) {
				p.afficherInventaire();
			}
			
			else if(i==4) {
				p.equiper(j);
			}
			else if(i==5) {
				p.utiliserObjet(Pistolet2, j);
			}
			m.afficher();
			
		}while(i!=6);*/
		System.out.println(j);
		System.out.println(ti);
		TourParTour t = new TourParTour();
		m.afficher();
		t.tourpartour(m,j,ti);
		System.out.println(j);
		System.out.println(ti);

		
	}	
	
	
	}