package TPE.comparador;

import TPE.Alumno;

import java.util.Comparator;

public class CompNombre implements Comparator<Alumno> {

	public int compare(Alumno o1, Alumno o2) {
		String s1 = o1.getNombre();
		String s2 = o2.getNombre();
		return s1.compareTo(s2);
	}
}
