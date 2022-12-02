
public class ComparatorCantAlumnos extends ComparatorElementoFacultad{

    public ComparatorCantAlumnos(){
        super();
    }

    public ComparatorCantAlumnos(ComparatorElementoFacultad nextComparator){
        super(nextComparator);
    }

    @Override
    public int comp(ElementoFacultad o1, ElementoFacultad o2) {
        return o1.getCantidadAlumnos() - o2.getCantidadAlumnos();
    }
}
