package TPE.comparador;

import TPE.Alumno;
public class CompCantAlumnos extends Compare{
    
    
	@Override
	public int compare(Object o1, Object o2) {
		Alumno a = (Alumno)o1;
		Alumno b = (Alumno)o2;
		return a.getCantidadAlumnos() - (b.getCantidadAlumnos());
	}
}

