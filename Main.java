package TPE;
import java.util.Comparator;

import TPE.comparador.*;

public class Main {

	public static void main(String[] args) {
		Comparator <Object> criterio = new CompInt();

		ListaEnlazada lista = new ListaEnlazada( criterio);
		//	listaString.setSize(5);

		Nodo a1 = new Nodo("10");
		Nodo a2 = new Nodo("21");
		Nodo a3 = new Nodo("1");
		Nodo a4 = new Nodo("5");
		Nodo a5 = new Nodo("11");

		lista.agregar(a2);
		lista.agregar(a3);
		lista.agregar(a4);
		lista.agregar(a5);
		lista.agregar(a1);
		lista.agregar(a1);
		lista.agregar(a4);

		lista.iterator();

		lista.eliminar(0);
		lista.eliminarTodasLasOcurrencias("5");
		lista.eliminarTodasLasOcurrencias("11");

		lista.iterator();

	}
}
