package TPE.comparador;

import TPE.Nodo;
public class CompString extends Compare{
    
    public int compare(Object a,Object b) {
    	String aux = (String)((Nodo)a).obtenerValor();
    	String baux = (String)((Nodo)b).obtenerValor();
    	return aux.compareTo(baux);    	
    }

}
