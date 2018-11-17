/* -*- jde -*- */
/* <ManejadorDeLista.java> */

package icc.util;


import icc.agenda.RegistroAgenda;

/**
 * Clase para proveer los servicios de un contenedor tipo Lista.
 */
public class ManejadorDeLista {	

	/**
	 * Primer elemento de la lista.
	 */
	private ListaAgenda cabeza;

	/**
	 * Número de elementos en la lista.
	 */
	private int longitud;
	

	/**
	 * Agrega un registro agenda al final de la lista.
	 */
	public void agrega(RegistroAgenda elemento) {
		// Crea el nuevo elemento y lo cuenta.			
		ListaAgenda nuevo = new ListaAgenda(elemento);
		longitud++;
					
		// Si la lista está vacía añade al primer elemento y termina.
		if (cabeza == null) {
			this.cabeza = nuevo;
			return;
		}

		// Si no, hay que recorrer la lista para formar al nuevo
		// elemento detrás del último.
		ListaAgenda anterior = cabeza;
		while(anterior.getSiguiente() != null) {
			anterior = anterior.getSiguiente();
		}
		anterior.setSiguiente(nuevo); 
	}
	
	/* Imprime los elementos dentro de la base de datos.*/
	public void imprime(){
		ListaAgenda anterior = cabeza;
		while(anterior != null){
			System.out.println(anterior.getRegistro().toString());
			anterior = anterior.getSiguiente();
		}
	}

	/**
	 * Devuelve el número de elementos en esta lista.
	 */
	public int longitud() {
		return longitud;
	}

	/**
	 * Por ahora utilizaremos este método para poder
	 * programar la búsqueda en la base de datos.
	 */
	public RegistroAgenda encuentra(IBuscador buscador) {
		// TODO: Utiliza al objeto buscador para encontrar
		// al registro agenda con el dato solicitado.
	
			ListaAgenda head = cabeza;
			while(head != null){			
				//head.getRegistro().getNombre().equals(buscador.toString())
				if(buscador.esEste(head.getRegistro()) ||  buscador.esEste(head.getRegistro())) {// Para regresar el resultado sin importar si buscamos por nombre o por telefono.
					return head.getRegistro();
				}else{
					head = head.getSiguiente();
				}
			}
							
		return null;
	}
	
}
