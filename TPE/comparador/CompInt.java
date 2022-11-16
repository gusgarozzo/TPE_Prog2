package TPE.comparador;
public class CompInt extends Compare{
    
    public int compare(Object a,Object b) {
    	Integer aux = (Integer)a;
    	Integer baux = (Integer)b;
    	return aux.compareTo(baux);    	
    }
}
