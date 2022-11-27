package TPE.comparador;

import java.util.Comparator;

import TPE.Alumno;
public class CompCantAlumnos implements Comparator<Alumno>{
    
	@Override
	public int compare(Alumno a1, Alumno a2) {
		return a1.getCantidadAlumnos() - (a2.getCantidadAlumnos());
	}
}

