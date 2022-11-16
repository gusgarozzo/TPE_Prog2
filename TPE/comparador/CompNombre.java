package TPE.comparador;

import TPE.Alumno;
public class CompNombre  extends Compare{

    @Override
	public int compare(Object o1, Object o2) {
		Alumno a = (Alumno)o1;
		Alumno b = (Alumno)o2;
		return a.getNombre().compareTo(b.getNombre());
	}
}
