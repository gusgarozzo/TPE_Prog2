package TPE.comparador;

import java.util.Comparator;

import TPE.Nodo;

public class CompInt implements Comparator<Object>{
    
	@Override
    public int compare(Object n1,Object n2) {
    	Integer a = (Integer) ((Nodo) n1).obtenerValor();
    	Integer b = (Integer) ((Nodo) n2).obtenerValor();
    	return a.compareTo(b);    	
    }

}
