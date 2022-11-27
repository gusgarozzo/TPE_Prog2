package TPE.comparador;

import java.util.Comparator;

import TPE.Nodo;

public class CompString implements Comparator<Nodo> {

   
    public int compare(Nodo n1,Nodo n2) {
    	String a = (String) n1.obtenerValor();
    	String b = (String) n2.obtenerValor();
    	return a.compareTo(b);    	
    }
   }