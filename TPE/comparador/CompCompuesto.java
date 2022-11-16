package TPE.comparador;

import java.util.Comparator;

import TPE.Alumno;

public class CompCompuesto implements Comparator<Object> {
    
	Comparator<Object> comp1;
	Comparator<Object> comp2;
	
	public CompCompuesto(Comparator<Object> comp1, Comparator<Object> comp2){
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(Object o1, Object o2) {
	
        Alumno a = (Alumno)o1;
        Alumno b = (Alumno)o1;
	    int	resultado = comp1.compare(a, b);
        System.out.println(resultado);	
			if(resultado == 0);
				comp2.compare(a, b);
                System.out.println("2 " + resultado);	
			return resultado;
	}
    
}