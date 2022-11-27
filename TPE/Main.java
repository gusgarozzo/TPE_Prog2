package TPE;
import java.util.Comparator;

import TPE.comparador.CompApellido;
import TPE.comparador.CompCompuesto;
import TPE.comparador.CompDNI;
import TPE.comparador.CompInt;
import TPE.comparador.CompNombre;

public class Main {

	public static void main(String[] args) {
	
		
		Comparator <Alumno> compNombre = new CompNombre();	
        Comparator <Alumno> compDNI = new CompDNI();	
        Comparator <Alumno> CompApellido = new CompApellido();	
        Comparator <Alumno> comparatorCompuesto = new CompCompuesto(compNombre,CompApellido);

        Comparator <Alumno> comparatorCompuesto2 = new CompCompuesto(comparatorCompuesto,compDNI);

		Comparator<Object> comparadorInt = new CompInt();



	

		ListaEnlazada listaString = new ListaEnlazada( comparadorInt);	






	//	listaString.setSize(5);

         Alumno aa1 = new Alumno("Alex", "farias", 1, 27);
        // Alumno a2 = new Alumno("Gustavo", "Garozzo", 2, 28);
		// Alumno a3 = new Alumno("Mauro", "Orellano", 3, 29);
		// Alumno a4 = new Alumno("Manu", "Gosende", 4, 30);
		// Alumno a5 = new Alumno("Marcelo", "Limideiro", 5, 31);

		

		// System.out.println("Esta vacía " + listaString.isEmpty());		
        // listaString.agregar(a1);
		// listaString.agregar(a2);
		// listaString.agregar(a3);
		// listaString.agregar(a4);
		// listaString.agregar(a5);

		ListaEnlazada lista = new ListaEnlazada(comparadorInt);	

		Nodo a1 = new  Nodo(new Integer (10));
		Nodo a2 = new  Nodo(new Integer (20));

		lista.agregar(aa1);
		lista.agregar(a1);
		lista.agregar(a2);


	
		

		
	

		
	
		
//		System.out.println("Esta vacía " + listaString.getSize()	);	
		//System.out.println("Obtener la posición de la primera ocurrencia de un elemento dado. " + listaString.obtenerNodo(a5));	
	
	
		
		
	//	for (int i = 0; i < listaString.getSize();i++) {

	
		

	//	System.out.println("Elemento en pos 0 "  + " "+ lista.obtenerNodo(0));
		
	System.out.println("wewefwe " + lista);

		System.out.println("Elemento en " +  lista.buscarNodo(aa1));
		
		
	// 	System.out.println(listaString.buscarNodo(a3));

	// 	System.out.println("-------------------------------------------------------------------------------");

	// 	listaString.eliminar(0);

	// //	for (int i = 0; i < listaString.getSize();i++) {

				
			
	// 		System.out.println("Elemento en pos 0 "  + " "+ listaString.obtenerNodo(0).obtenerValor().toString());
	// 		System.out.println("Elemento en pos 1 "  + " "+ listaString.obtenerNodo(1).obtenerValor().toString());
	// 		System.out.println("Elemento en pos 2 "  + " "+ listaString.obtenerNodo(2).obtenerValor().toString());
		




















	    }
	}