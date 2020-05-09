
public class TourParTour {
	
	public TourParTour() {
		
	}
	
	public void tourpartour(Univers m,PJ a,Pnj b){
	int i=0;
	int j=0;
		/**/do {
			
			a.tourJ(m,a,b);
			while(j<10){
				System.out.println("");
				j++;
			}
			a.tourM(m,a,b);
			a.mortPnj(m,b);
			
			
			
			i++;
	}while(i<10);
		
			
	
		
	}

}
