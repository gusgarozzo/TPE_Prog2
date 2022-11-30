package TPE.comparador;

import TPE.Alumno;

import java.util.Comparator;

public class ComparadorInverso implements Comparator<Alumno> {

    @Override
    public int compare(Alumno o1, Alumno o2) {
        String i1 = o1.getApellido();
        String i2 = o2.getApellido();
        return i2.compareTo(i1);
    }
}
