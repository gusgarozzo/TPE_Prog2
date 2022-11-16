package TPE.comparador;

import TPE.Alumno;
public class CompApellido extends Compare{

    @Override
    public int compare(Object o1, Object o2) {
        Alumno a1 = (Alumno)o1;
		Alumno a2 = (Alumno)o2;
		return a1.getApellido().compareTo(a2.getApellido());
    }
    
}
