package icc.estadisticas;
import java.io.*;
import java.util.*;
    
public class Estadisticas{
	double[] a;
	

	public double[] cargaArreglo(){//Leemos los archivos y creamos el arreglo.
    	try{
    	    FileReader fr  = new FileReader("datos.txt");
	        BufferedReader br =  new BufferedReader(fr);
    	    String linea = "";
	        int x;
	        linea  = br.readLine();
	        x = Integer.parseInt(linea);
	        a = new double[x];
	        int contador = 0;
	        while((linea  = br.readLine()) != null){ 
	           if (contador == 0) { 
                  a[contador] = Double.parseDouble(linea);	              
	              contador++;
	              continue;
	              
	           }else{
	                
	                a[contador] = Double.parseDouble(linea);
	                contador++;
	            }
    	    }
    	    
    	    return a;   	
		}catch(IOException e){
		    System.out.println("No se pudo leer del archivo");
		 
		    return a;
		}
	}
	
	public double media(double[] a){//Calcula media
		double media = 0.0;
		
		if(a == null){
			return 0.0;
		}
		
		for(int i = 0; i < a.length; i++){//Sumamos los numeros
			media+=a[i];
		}
		media/=a.length; //Dividimos para sacar la media
		return media;
	}
	
	public double varianza(double[] a, double media){//Calcula la varianza
	    double resultado = 0;
		if(a == null){
			System.out.println("No hay arreglo");
			return 0.0;			
		}else{
            for(int i=0; i<a.length ; i++){
                resultado+=(a[i]-media)*(a[i]-media);//Sumamos el cuadrado de la resta con la media.
            }
		}
		return resultado;
	}
}
