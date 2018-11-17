/* -*- jde -*- */
/* <RegistroAgenda.java> */

package icc.agenda;


/**
 * Registro para una Agenda
 */
public class RegistroAgenda {	

	// TODO: Declara aquí los atributos para almacenar
	// nombre, dirección y teléfono.
	
	private String nombre;
	private String direccion;
	private int telefono;
	

	/**
	 * Constructor.
	 */
	 
	 public RegistroAgenda(String nombre, String direccion, int telefono){
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	
	 }
	 

	/**
	 * Agrega los getters necesarios para leer la información en el registro.
	 */
	 
	 public String getNombre(){
	 	return nombre;
	 }
	 
	 public String getDireccion(){
	 	return direccion;
	 }

	public int getTelefono(){
		return telefono;
	}
	/**
	 * Agrega los setters que permitan actualizar los datos de tu contacto.
	 */

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	public void setTelefono(int telefono){
		this.telefono = telefono;
	}
	
	/**
	 * Devuelve una cadena con los datos en el registro en un formato agradable.
	 */
	public String toString() {
		return "\nNombre: " + nombre + ", Direccion: " + direccion + ", Telefono: " + telefono;
	}
}
