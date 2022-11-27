package TPE.comparador;

import java.util.Comparator;
import TPE.Alumno;
public class CompCompuesto implements Comparator<Alumno>{
    
	Comparator<Alumno> comp1;
	Comparator<Alumno> comp2;
	
	public CompCompuesto(Comparator<Alumno> comp1, Comparator<Alumno> comp2){
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(Alumno o1, Alumno o2) {
	
        Alumno a = (Alumno)o1;
        Alumno b = (Alumno)o2;
	    int	resultado = comp1.compare(a, b);
			if(resultado == 0)
				resultado = comp2.compare(a, b);
			return resultado;
	}
    
}