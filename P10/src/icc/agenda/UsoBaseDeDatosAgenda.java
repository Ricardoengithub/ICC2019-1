/* -*- jde -*- */
/* <UsoBaseDeDatosAgenda.java> */

package icc.agenda;


import java.util.Scanner;
/**
 * Clase de uso donde se pueden crear un par de bases de datos y
 * realizar consultas.
 */
public class UsoBaseDeDatosAgenda {

	private Scanner scanner;
	/*  Número de caracteres que debe tener el registro nombre. */
	private static final int TAM_NOMBRE    = 20;
	/*  Número de caracteres que debe tener el registro dirección. */
	private static final int TAM_DIRECCION = 30;
	/*  Número de caracteres que debe tener el registro teléfono. */
	private static final int TAM_TELEFONO  = 8;
	
	public UsoBaseDeDatosAgenda(){
		scanner = new Scanner(System.in);
	}

	private static final String tabla1 =
	/* Nombre (20) */      /* Dirección (30) */             /* Teléfono (8) */
	"Juan Pérez García   "+"Avenida Siempre Viva # 40     "+"55554466"+
	"Arturo López Estrada"+"Calle de la abundancia # 12   "+"55557733"+
	"Edgar Hernández Levi"+"Oriente 110 # 14              "+"55512112"+
	"María García Sánchez"+"Avenida Insurgentes Sur # 512 "+"56742391"+
	"Pedro Páramo Rulfo  "+"Avenida Méxio Lindo # 23      "+"54471499"+
	"José Arcadio Buendía"+"Macondo # 30                  "+"56230190"+
	"Florentino Ariza    "+"Calle de la Cólera # 11       "+"55551221";

	private static final String tabla2 =
	/* Nombre (20) */      /* Dirección (30) */             /* Teléfono (8) */
	"Galio Bermúdez      "+"Sótanos de México # 45        "+"55552112"+
	"Carlos García Vigil "+"La República # 1              "+"55554332"+
	"Eligio García Agusto"+"Ciudades Desiertas # 90       "+"56344325";




    private int leeEntero(String mensaje) {//Agregué esto de una practica pasada para leer numeros en el menú.
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
    
    
    public void corre() {//Corremos la interfaz
        System.out.println("\n *** Lista de contactos *** ");
		BaseDeDatosAgenda uno = new BaseDeDatosAgenda(tabla1 + tabla2, TAM_NOMBRE, TAM_DIRECCION, TAM_TELEFONO);
	    //uno.getTabla().imprime();// Por si se quiere ver los datos en la agenda
	    System.out.println("************************"); 
        boolean continuar = true;
        
        while (continuar) { //            
	    	System.out.println("\n1) Buscar por nombre");
	    	System.out.println("2) Buscar por telefono");
	    	System.out.println("3) Salir");
            int opcion = leeEntero("Selecciona una opción: ");
            
            switch(opcion) {
                case 1://Busqueda por nombre.
					System.out.println("\nDame el nombre a buscar: ");
					String nombre = scanner.nextLine();
					RegistroAgenda resultad = uno.dameRegistroPorNombre(nombre);										
										
					if (resultad == null) { // 
					   System.out.println("No hubo coincidencias");					   					   
					}else{
						System.out.println("\n******Resultados******");					
						System.out.println(resultad.toString());
						System.out.println("\n**********************");
					}					
					break;
					
                case 2://Busqueda por telefono.
					System.out.println("Dame el telefono a buscar:");
					int telefono = scanner.nextInt();
					Object resultad2 = uno.dameRegistroPorTelefono(telefono);
					if(resultad2 == null){
						System.out.println("No hubo coincidencias");												
					}else{
						System.out.println("\n******Resultados******");
						System.out.println(resultad2.toString());
						System.out.println("\n**********************");
					}
					break;
                case 3:
                    continuar = false;
					break;
                default:
                    System.out.println("Esa no es una opción válida del menú.");
                    break;
            }  
		}              
    }    


	public static void main(String[] args) {// Utilicé esta interfaz de la practica pasada.
		// TODO: Crear un par de BaseDeDatosAgenda y realizar algunas consultas.
	    		
		UsoBaseDeDatosAgenda interfaz = new UsoBaseDeDatosAgenda();
		interfaz.corre();
	}
}

/* </UsoBaseDeDatosAgenda.java> */
