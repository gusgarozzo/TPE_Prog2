package TPE.comparador;

import TPE.Alumno;
public class CompDNI extends Compare{

	@Override
	public int compare(Object o1, Object o2) {
		Alumno  a = (Alumno)o1;
		Alumno b  = (Alumno)o2;
		return a.getDni() - (b.getDni());
	}
	
}

