package TPE.comparador;

import java.util.Comparator;

import TPE.Alumno;
public class CompDNI implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		Alumno  a = (Alumno)o1;
		Alumno b  = (Alumno)o2;
		return a.getDni() - b.getDni();
	}
	
}

