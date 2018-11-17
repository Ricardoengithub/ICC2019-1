package icc.matriz;

import java.util.Scanner;

public class UsoMatriz{

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Matriz2D p, q, resultado;
		p = new Matriz2D(3,3);
		q = new Matriz2D(3,3);
		resultado = new Matriz2D(3,3);
		double[][] uno = {{1,2,3},{4,5,6},{7,8,9}};//Aqui podemos modificar las matrices.
		double[][] dos = {{1,2,3},{3,2,1},{8,7,9}};
		
		p = p.setMatriz(uno);
		q = q.setMatriz(dos);

		System.out.println("Matriz1: ");
		System.out.println(p.toString());
		System.out.println("Matriz2: ");
		System.out.println(q.toString());
		
		
		
		
				
		
		System.out.println("Suma: \n");						
		resultado = resultado.sumaMatriz(p,q);
		System.out.println(resultado.toString());
		
		System.out.println("Resta: \n");				
		resultado = resultado.restaMatriz(p,q);
		System.out.println(resultado.toString());
		
		System.out.println("Multiplicar por un escalar la Matriz1(Ingresa número)");
		String numero = in.nextLine();
		double numeros = Double.parseDouble(numero);		
		
		resultado = resultado.multiplicaEscalar(p, numeros);
		System.out.println(resultado.toString());
		
		System.out.println("Multiplicar por un escalar la Matriz2(Ingresa número)");
		numero = in.nextLine();
		numeros = Double.parseDouble(numero);
		resultado = resultado.multiplicaEscalar(q, numeros);
		System.out.println(resultado.toString());
		
		
		System.out.println("Multiplicacion de Matrices(Matriz1, Matriz2)");
		resultado = resultado.multiplicaMatriz(p,q);
		System.out.println(resultado.toString());
										
	}
}
