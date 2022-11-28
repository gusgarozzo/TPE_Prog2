package TPE.comparador;

import TPE.Alumno;

import java.util.Comparator;

public class CompDNI implements Comparator<Alumno> {

	public int compare(Alumno o1, Alumno o2) {
		Integer i1 = o1.getDni();
		Integer i2 = o2.getDni();
		return i1.compareTo(i2);
	}
}

