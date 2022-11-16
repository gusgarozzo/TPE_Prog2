package TPE;
import java.util.Comparator;

import TPE.comparador.CompApellido;
import TPE.comparador.CompCompuesto;
import TPE.comparador.CompDNI;
import TPE.comparador.CompNombre;

public class Main {

	public static void main(String[] args) {
	
		
		Comparator <Object> compNombre = new CompNombre();	
        Comparator <Object> compDNI = new CompDNI();	
        Comparator <Object> CompApellido = new CompApellido();	
        Comparator <Object> comparatorCompuesto = new CompCompuesto(compNombre,compDNI);

        Comparator <Object> comparatorCompuesto2 = new CompCompuesto(compDNI,comparatorCompuesto);

		ListaEnlazada listaString = new ListaEnlazada( comparatorCompuesto, 2);	

        Alumno a1 = new Alumno("Alexx", "Farias", 122222, 234234234);
        Alumno a2 = new Alumno("Blexx", "Farias", 1111122, 234234234);


		System.out.println("Esta vacía " + listaString.isEmpty());		
		listaString.agregar(a1);
        listaString.agregar(a2);
		
		System.out.println("Esta vacía " + listaString.isEmpty());	
		System.out.println("Primer elemento " + listaString.obtenerNodo(0).obtenerValor().toString());
        System.out.println("Primer elemento " + listaString.obtenerNodo(1).obtenerValor().toString());
		
     
		
		

	    }
	}