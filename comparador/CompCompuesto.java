package TPE.comparador;

import java.util.Comparator;
import TPE.Alumno;
public class CompCompuesto implements Comparator<Alumno> {
	Comparator<Alumno> comp1;
	Comparator<Alumno> comp2;

	public CompCompuesto(Comparator<Alumno> comp1, Comparator<Alumno> comp2){
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(Alumno o1, Alumno o2) {
		// Caso ejemplo: comparar primero por nombre y luego por apellido
        Integer comparador1 = comp1.compare(o1, o2);
		if(comparador1 == 0){
			return comp2.compare(o1, o2);
		}else{
			return comparador1;
		}
	}

}