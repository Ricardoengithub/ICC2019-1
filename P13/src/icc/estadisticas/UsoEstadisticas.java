package icc.estadisticas;

public class UsoEstadisticas{
	
	public static void main(String[] args) {
		Estadisticas nuevo  = new Estadisticas();
		 double [] a = nuevo.cargaArreglo();
	     double media = nuevo.media(a);
	     System.out.println("Media: " + media);
	     double varianza = nuevo.varianza(a, media);
	     System.out.println("Varianza: " + varianza);
	     	   
	}
}
