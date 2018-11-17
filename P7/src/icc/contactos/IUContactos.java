package icc.contactos;

import java.util.Scanner;

/**
 * Interfaz de usuario para manejar una lista de contactos.
 * @author blackzafiro
 */
public class IUContactos {
	private Scanner scanner;
	private Contactos contactos;
    
    /**
     * Crea la interfaz de usuario para manejar un plantío con magueyes, cempohualxochitl y rosas.
     */
    public IUContactos() {
        scanner = new Scanner(System.in);
        contactos = new Contactos();
    }
	
	/**
     * Pide un número al usuario.
     * @param mensaje
     * @return 
     */
    private int leeEntero(String mensaje) {
        System.out.println(mensaje);
        boolean error = false;
        int num = 0;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num <= 0) {
                error = true;
                System.out.println("El valor más chico posible es uno.");
            }            
        } catch (NumberFormatException nfe) {
            error = true;
            System.out.print("Por favor ingresa un número válido.\n");
        }
        if (error) {
            num = leeEntero(mensaje);
        }
        return num;
    }
    
    
    
    
    
	/**
	 * Pide al usuario los datos del contacto nuevo y devuelve un registro con
	 * ellos.
	 * @return 
	 */
    private Registro solicitaDatosDeContacto() {
		System.out.println("\nDame los datos del nuevo contacto...");
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Direccion: ");
		String direccion = scanner.nextLine();
		System.out.print("Telefono: ");
		int telefono = scanner.nextInt();
		
		
		// Utiliza el scanner para leer los datos que faltan y, si es necesario,
		// conviértelos a los tipos que requiere tu clase Registro.
		// ??? direccion = ..
		// ??? telefono = ...
		
		Registro nuevo = new Registro(nombre, direccion, telefono);
		return nuevo;
    }
    
    /**
     * Método auxiliar para imprimir el menú para el usuario.
     */
    private void imprimeMenu() {
        System.out.println("\n\nOpciones:");
        System.out.println("1) Agregar contacto");
        System.out.println("2) Buscar contacto");
        System.out.println("3) Imprimir lista de contactos");
        System.out.println("4) Salir\n");
    }
    
    public void corre() {
        System.out.println("\n *** Lista de contactos *** ");
        boolean continuar = true;
        while(continuar) {
            imprimeMenu();
            int opcion = leeEntero("Selecciona una opción: ");
            switch(opcion) {
                case 1:
					Registro reg = solicitaDatosDeContacto(); 											
					contactos.insertaContacto(reg);
					break;
                case 2:
					System.out.println("\nEscribe el nombre del contacto que buscas:");
					String pista = scanner.nextLine();
					contactos.consultar(pista);
					break;
                case 3:
					contactos.imprimeContactos();
					break;
                case 4:
                    continuar = false;
					break;
                default:
                    System.out.println("Esa no es una opción válida del menú.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        IUContactos interfaz = new IUContactos();
        interfaz.corre();
    }
}
