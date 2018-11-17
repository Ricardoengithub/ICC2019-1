/* -*- jde -*- */
/* <BaseDeDatosAgenda.java> */

package icc.agenda;

import icc.agenda.RegistroAgenda;
import icc.util.ManejadorDeLista;

/**
 * Clase para representar una Base de Datos de agenda.
 *
 * Una base de datos debe ser capaz de obtener registros, y campos
 * de sus registros, y debe ser capaz de reconocer si un campo o registro
 * solicitado no existe, y dar una respuesta coherente.
 */
public class BaseDeDatosAgenda {	

	/**
	 * Este objeto llevará el control de los registros guardados en la lista.
	 */
	private ManejadorDeLista tabla = new ManejadorDeLista();
	

	/**
	 * Constructor.
	 * @param datos Una cadena con el formato requerido por esta base
	 *        con los registros de nombres, direcciones y teléfonos.
	 * @param tam_nombre 
	 */
	
	public BaseDeDatosAgenda(String datos,
				 int tam_nombre,
				 int tam_direccion,
				 int tam_telefono) {
		int tam_registro = tam_nombre + tam_direccion + tam_telefono;
		// TODO: Crear el ManejadorDeLista para almacenar ahí los registros.0
		int largo = datos.length();		
		
		
		
		int x = 0;
		while (largo > 0) { // Separamos las cadenas respecto al largo de cada registro y agregamos los datos a tabla;
		   String nombre, direccion;
		   int telefono;
		   nombre = datos.substring(0+x,20+x);
		   direccion = datos.substring(20+x,50+x);
		   telefono = Integer.parseInt(datos.substring(50+x,58+x));
	   		   		   		   		   		   
		   RegistroAgenda nuevo = new RegistroAgenda(nombre, direccion, telefono);

		   tabla.agrega(nuevo);	//Agregamos el nuevo registro.	   
		   
		   x += 58;
		   largo = largo - tam_registro;
		   
		   if(largo == 0){
		   		break;
		   }
		}
		this.tabla = tabla;
	}
	
	public ManejadorDeLista getTabla(){
		return tabla;
	}

	public RegistroAgenda dameRegistroPorNombre (String nombre) {
		// TODO: Usa BuscadorPorNombre y el método encuentra de ManejadorDeLista
		// para encontrar el registro correcto dentro de la lista.
		
			BuscadorPorNombre reg = new BuscadorPorNombre(nombre);
			RegistroAgenda reg2; 				
			reg2 = tabla.encuentra(reg);
			return reg2;
	}

	public RegistroAgenda dameRegistroPorTelefono (int tel) {
		// TODO: Crea la clase BuscadorPorTelefono en forma similar a BuscadorPorNombre
		// Usa BuscadorPorTelefono y el método encuentra de ManejadorDeLista
		// para encontrar el registro correcto dentro de la lista.

			BuscadorPorTelefono reg = new BuscadorPorTelefono(tel);
			RegistroAgenda reg2; 			
			reg2 = tabla.encuentra(reg);
			return reg2;
	}
}
