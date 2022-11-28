package TPE.comparador;

import TPE.Alumno;

import java.util.Comparator;

public class CompApellido implements Comparator<Alumno> {
    public int compare(Alumno o1, Alumno o2) {
        String s1 = o1.getApellido();
        String s2 = o2.getApellido();
        return s1.compareTo(s1);
    }
}
