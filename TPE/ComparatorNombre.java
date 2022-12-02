
public class ComparatorNombre extends ComparatorElementoFacultad{
    public ComparatorNombre() {
        super();
    }

    public ComparatorNombre(ComparatorElementoFacultad nextComparator) {
        super(nextComparator);
    }

    @Override
    public int comp(ElementoFacultad alu1, ElementoFacultad alu2) {
        try {
            Alumno aux1 = (Alumno) alu1;
            Alumno aux2 = (Alumno) alu2;
            return aux1.getNombre().compareTo(aux2.getNombre());
        }catch (Exception e){
            return 1;
        }
    }
}
