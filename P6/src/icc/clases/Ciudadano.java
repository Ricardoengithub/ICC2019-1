package icc.clases;

public class Ciudadano {

	private String nombre;
	String apellidoPaterno;
	String apellidoMaterno;
	private String nacimiento;

	public Ciudadano(String nombre, String apellidoPaterno, String apellidoMaterno, String nacimiento) {//Las variables que necesitamos para el Ciudadano.
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nacimiento = nacimiento;
	}

	public String calculaRFC(){//Con ayuda de substring tomamos las cadenas que nos interesan y las concatenamos.
		String rfc;
		rfc = apellidoPaterno.substring(0,2) + apellidoMaterno.substring(0,1) + nombre.substring(0,1) + nacimiento.substring(8,10) + nacimiento.substring(3,5) + nacimiento.substring(0,2);		
		return rfc;
	}
	
	public String toString(){//Imprimimos en pantallo los datos del Ciudadano.
		return "Nombre: " + nombre +  ", Cumpleaños: " + nacimiento + ", Nacimiento: " +  calculaRFC();
	}
}
