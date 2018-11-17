package icc.matriz;
import java.util.Scanner;

public class Matriz2D{
	
	private double[][] a;
	private int renglones;
	private int columnas;
	
	/* Constructor */ 
	public Matriz2D(int n, int m){
		this.a = new double[3][3];
		this.renglones = n;
		this.columnas = m;
	}
	
	/* Imprimir datos en pantalla*/
	public String toString(){//Como veremos a la matriz.
		for(int i = 0; i<3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(a[i][j] + " ");				
			}
			System.out.print("\n");						
		}
		return "";
	}
	
	/* Getters*/
	public double[][] getMatriz(){
		return a;
	}
	
	public int getRenglones(){
		return renglones;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	/* Setters */
	public static Matriz2D setMatriz(double[][] ar){
		if(ar.length == 3){//Verificamos que sea una matriz 3x3
			for(int x = 0; x<3;x++){
				if(ar[x].length == 3){
					continue;
				}
				else{
					System.out.println("Datos no corresponden a un arreglo[5][5]");			
					return null;	
				}
			}
		}
		
		double[][] g; 
		
		Matriz2D h = new Matriz2D(3,3);
		g = new double[3][3];			
		g = h.getMatriz();
		
		for(int i = 0; i<3; i++){//Asignamos los valores a cada celda
			for(int j = 0; j < 3; j++){
				g[i][j] = ar[i][j];
			}
		}

		return h;
	}
	
	
	public Matriz2D sumaMatriz(Matriz2D x, Matriz2D y){//Suma dos matrices.
		double[][] w = x.getMatriz();
		double[][] z = y.getMatriz();
		
		if(w.length == 3 && z.length == 3){//Verificamos que sean una matriz 3x3
			for(int i = 0; i<3;i++){
				if(w[i].length == 3 && z[i].length == 3){
					continue;
				}
				else{
					System.out.println("Datos no corresponden a un arreglo[5][5]");			
					return null;	
				}
			}
		}
		
		double[][] g;
		
		Matriz2D suma = new Matriz2D(3,3);
		g = new double[3][3];			
		g = suma.getMatriz();
		
		for(int i = 0; i<3; i++){//Asignamos los valores a cada celda
			for(int j = 0; j < 3; j++){
				g[i][j] = w[i][j] + z[i][j]; //Sumamos ambos valores en una misma celda.
			}
		}

		return suma;				
	}
	
	
	
	public Matriz2D restaMatriz(Matriz2D x, Matriz2D y){//Resta dos matrices
		double[][] w = x.getMatriz();
		double[][] z = y.getMatriz();
		
		if(w.length == 3 && z.length == 3){//Verificamos que sean una matriz 3x3
			for(int i = 0; i<3;i++){
				if(w[i].length == 3 && z[i].length == 3){
					continue;
				}
				else{
					System.out.println("Datos no corresponden a un arreglo[5][5]");			
					return null;	
				}
			}
		}
		
		double[][] g;
		
		Matriz2D resta = new Matriz2D(3,3);
		g = new double[3][3];			
		g = resta.getMatriz();
		
		for(int i = 0; i<3; i++){//Asignamos los valores a cada celda
			for(int j = 0; j < 3; j++){
				g[i][j] = w[i][j] - z[i][j]; //Restamos ambos valores en una misma celda.
			}
		}

		return resta;				
	}
	
	
	
	public Matriz2D multiplicaEscalar(Matriz2D x, double numero){//Multiplica por un escalar una matriz
		double[][] w = x.getMatriz();
		
		if(w.length == 3){//Verificamos que sean una matriz 3x3
			for(int i = 0; i<3;i++){
				if(w[i].length == 3){
					continue;
				}
				else{
					System.out.println("Datos no corresponden a un arreglo[3][3]");			
					return null;	
				}
			}
		}
		
		double[][] g;
		
		Matriz2D mult = new Matriz2D(3,3);
		g = new double[3][3];			
		g = mult.getMatriz();
		
		for(int i = 0; i<3; i++){//Asignamos los valores a cada celda
			for(int j = 0; j < 3; j++){
				g[i][j] = w[i][j] * numero; //Multiplicamos por el escalar.
			}
		}

		return mult;				
	}
	
	
	public Matriz2D multiplicaMatriz(Matriz2D x, Matriz2D y){//Multiplica dos matrices
		double[][] w = x.getMatriz();
		double[][] z = y.getMatriz();
		
		if(w.length == 3 && z.length == 3){//Verificamos que sean una matriz 3x3
			for(int i = 0; i<3;i++){
				if(w[i].length == 3 && z[i].length == 3){
					continue;
				}
				else{
					System.out.println("Datos no corresponden a un arreglo[3][3]");			
					return null;	
				}
			}
		}
		
		double[][] g;
		
		Matriz2D mult = new Matriz2D(3,3);
		g = new double[3][3];			
		g = mult.getMatriz();
		
		for(int i = 0; i<3; i++){//Asignamos los valores a cada celda
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3 ; k++){//Recorremos para hacer la suma de los tres sumandos
					g[i][j]+= w[i][k] * z[k][j];
				}
			}
			
		}

		return mult;				
	}	
	
}
