package TPE.comparador;

import TPE.Alumno;

import java.util.Comparator;

public class CompCantAlumnos implements Comparator<Alumno> {
	public int compare(Alumno o1, Alumno o2) {
		Integer i1 = o1.getCantidadAlumnos();
		Integer i2 = o2.getCantidadAlumnos();
		return i1.compareTo(i2);
	}
}

