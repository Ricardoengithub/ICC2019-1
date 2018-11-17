package icc.contactos;

public class Contactos{
	
	int x = 0;
	Registro cabeza;
	Registro previo;
	Registro proximo;
	
	public void Contactos (){
		
	}
	
	public void insertaContacto(Registro reg){
				Registro nuevo = new Registro(reg.getNombre(), reg.getDireccion(), reg.getTelefono());

		if(x == 0){//Cuando no hay nada, simplemente agregamos al registro.
			cabeza = nuevo;
			x++;
		}else{
			if(x ==1){//Cuando existe un registro dentro.
				if(nuevo.getNombre().compareTo(cabeza.getNombre()) <= 0){// Si va antes lo ponemos como cabeza.
					nuevo.setSiguiente(cabeza);		
					cabeza = nuevo;
				}else{//En caso de que vaya despues de la cabeza.
					cabeza.setSiguiente(nuevo);
				}x++;				
			}else{//Cuando existen al menos dos elementos en la agenda.
				proximo = cabeza.getSiguiente();
				previo = cabeza;
				if(x > 1){
					if(nuevo.getNombre().compareTo(cabeza.getNombre()) <=0){//Si es mas "chico", le asignamos la cabeza al nuevo registro que acababa de entrar.
						nuevo.setSiguiente(cabeza);
						cabeza = nuevo;
					}
					while(proximo != null){//Para recorrer la lista de registros.
						if(nuevo.getNombre().compareTo(previo.getNombre()) <= 0){//Cuando el nuevo regitro va antes de todos.
							nuevo.setSiguiente(previo);
							break;
						}
						if(nuevo.getNombre().compareTo(proximo.getNombre()) <= 0){//Cuando el nuevo registro va entre dos registros.												
						nuevo.setSiguiente(proximo);
						previo.setSiguiente(nuevo);
						break;
						}
						if(nuevo.getNombre().compareTo(proximo.getNombre()) > 0 && proximo.getSiguiente() == null){//Cuando el nuevo registro resulta ser mayor a todos.
							proximo.setSiguiente(nuevo);
							break;
						}
						if(nuevo.getNombre().compareTo(proximo.getNombre()) > 0 && proximo.getSiguiente() != null){//Asignaciones para seguir buscando en la lista.
							previo = proximo;
							proximo = proximo.getSiguiente();
						}
					}
				}
			}
		}
	}
	
			
	public void imprimeContactos(){//Imprime los contactos que tenemos registrados
		Registro head;
		head = cabeza;//para recorrer la lista sin afectar a la cabeza.
		int z = 0;
		System.out.println("\n*****Resultados:*****");		
		while(head  != null){
			System.out.print(head.toString());
			head = head.getSiguiente();
			z++;
		}
		if(z == 0){
				System.out.println("\nNo hay contactos");								
		}
		System.out.println("\n*****Resultados:*****");			
	}
	
	public void consultar(String nombre){//Busca todos los registros que coincidan con la palabra buscada.
		Registro heads;
		heads = cabeza;//para recorrer la lista sin afectar a la cabeza.
		int z = 0;
		System.out.println("\n*****Resultados:*****");
		
		
		while(heads != null){
			if(heads.getNombre().contains(nombre)){
				System.out.print(heads.toString());
				heads = heads.getSiguiente();			
				z++;
			}else{
			heads = heads.getSiguiente();
			}
		}
		if(z == 0){
			System.out.println("\nNo hubo coincidencias con ese nombre.");						
		}
		System.out.println("\n*****Resultados:*****");
		
	}

}
