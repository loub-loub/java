import java.util.Scanner;

public class Menu{

//constructeur
	public Menu(){

	}

//methodes
	public void Start(){
		Scanner sc = new Scanner(System.in);
		int str;
		System.out.println("Monutyhall");
		do{
			str = sc.nextInt();
			System.out.println("Appuyez sur 1 ");
			if( str == 1 ){
				System.out.println("menu suivant");
			}
			else{
				System.out.println("Appuyez sur 1 ");
			}
		}while(str != 1);
		sc.close();

	}

	public void menu(){
		Scanner sc = new Scanner(System.in);
		int str;
		System.out.println("Monutyhall");
		do{
			str = sc.nextInt();
			System.out.println("Appuyez sur 1 - Jouer \n Appuyez sur 2 - Crédits ");
			if( str == 1 ){
				System.out.println("menu jouer");
			}
			else if(str == 2){
				System.out.println("menu crédits ");
			}
		}while(str != 1);
		sc.close();


	}

	public void crédits(){
		System.out.println("Lionel Ngolo & Houda Hajji ");
	}
	
	

}