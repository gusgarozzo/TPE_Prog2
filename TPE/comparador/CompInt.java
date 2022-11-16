package TPE.comparador;

import java.util.Comparator;

public class CompInt implements Comparator<Object>{
    
    public int compare(Object a,Object b) {
    	Integer aux = (Integer)a;
    	Integer baux = (Integer)b;
    	return aux.compareTo(baux);    	
    }
}
