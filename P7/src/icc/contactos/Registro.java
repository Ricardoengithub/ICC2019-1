package icc.contactos;

public class Registro{
	
	private String nombre;
	private String direccion;
	private int telefono;
	Registro siguiente;
	
	
	public Registro(String nombre, String direccion, int telefono){//Constructor de Registro

	if (nombre != null) { // 
	   this.nombre = nombre;
	}
	else this.nombre = "";
	if (direccion != null) { // 
	   this.direccion = direccion;	 
	}
	else this.direccion = "";	
	if (telefono == 0) { // 
	   this.telefono = 0;
	}
	else this.telefono = telefono;
	this.siguiente = null;
	}
	
	/* Getters*/
	public String getNombre(){
		return nombre;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public int getTelefono(){
		return telefono;
	}
	
	public Registro getSiguiente(){
		return siguiente;
	}	
	

	/* Setters*/
	public void setNombre(String nombre){
		if (nombre != null) { // 
		   this.nombre = nombre;
		}
		else System.out.println("Error, imposible asignar null");
 	}
 	
 	public void setDireccion(String direccion){
 		if (direccion != null) { // 
 		   this.direccion = direccion;
 		}else System.out.println("Error, imposible asignar null"); 		 	
 	}
 	
 	public void setTelefono(int telefono){
		this.telefono = telefono; 			
 	}
 	
 	public void setSiguiente(Registro siguiente){
 		if (siguiente != null) { // 
 			this.siguiente = siguiente;
 		} 				 		
 	}
 	
 	
 	/* Imprime datos de registro*/ 
 	public String toString(){ 		
 		return "\nNombre: " + nombre + ", Direccion: " + direccion + ", Telefono: " + telefono ; 
 	} 	 	
}
