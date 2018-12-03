package automatas;


public abstract class Celulares{
	
	public int umbral;
	public int[] celdas;
	private int t;
    
    	
	public Celulares(int umbral, int t){
		this.umbral = umbral;
		this.t = t;
	}
	
	public int getUmbral(){
		return umbral;
	}


}
