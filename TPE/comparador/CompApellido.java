package TPE.comparador;

import java.util.Comparator;

import TPE.Alumno;

public class CompApellido implements  Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
        Alumno a1 = (Alumno)o1;
		Alumno a2 = (Alumno)o2;
		return a1.getApellido().compareTo(a2.getApellido());
    }
    
}
