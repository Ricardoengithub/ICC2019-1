package automatas;

public class Sismos extends Celulares{

	public int[] casillas;
	
	
	public Sismos(int umbral, int t){//Constructor
		super(umbral, t);
		casillas = new int[1200];
		for(int x = 0; x < 1200; x++){
			casillas[x] = 0;
		}
		this.casillas = casillas;
	}
	
	public int[] getCasillas(){//Obtiene todos los valors de la malla
		return casillas;
	}
	
	public int getIndex(int x){//Obtiene el valor de la celda
		return casillas[x];
	}
	
	public void setCasilla(int index, int numero){
		if(numero == umbral){
			vecinos(index);
			casillas[index] = numero -4;
		}else{
		casillas[index] = numero;
		}
	}
	public void vecinos(int index){
		casillas[index+1] = casillas.getIndex(index+1) -1;
		casillas[index-1] = casillas.getIndex(index-1) -1; 
		casillas[index+30] = casillas.getIndex(index+30) -1;
		casillas[index-30] = casillas.getIndex(index-30) -1;		
	}
	
	
	public void inicio(){//Valores aleatorios de inicio para cada celda.
		for(int i = 0; i < 1200; i++){
			int aleatorio = (int) (Math.random() * 1200);
			int inicioCelda = (int) (Math.random() * umbral);
			if(aleatorio%5 == 0){
				casillas[i] = inicioCelda;
			}
		}
	}
}
