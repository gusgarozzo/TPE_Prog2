package TPE.comparador;

import java.util.Comparator;

import TPE.Alumno;
public class CompApellido implements Comparator<Alumno>{

    @Override
    public int compare(Alumno a1, Alumno a2) {
		return a1.getApellido().compareTo(a2.getApellido());
    }
    
}
