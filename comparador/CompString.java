package TPE.comparador;

import TPE.Nodo;

import java.util.Comparator;

public class CompString implements Comparator<Object> {
    
    public int compare(Object a,Object b) {
    	String aux = (String)((Nodo)a).obtenerValor();
    	String baux = (String)((Nodo)b).obtenerValor();
    	return aux.compareTo(baux);    	
    }

}
