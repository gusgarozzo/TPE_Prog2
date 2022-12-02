

public class ComparatorApellido extends ComparatorElementoFacultad{
    public ComparatorApellido() {
        super();
    }

    public ComparatorApellido(ComparatorElementoFacultad nextComparator) {
        super(nextComparator);
    }

    @Override
    public int comp(ElementoFacultad alu1, ElementoFacultad alu2) {
        try {
            Alumno aux1 = (Alumno) alu1;
            Alumno aux2 = (Alumno) alu2;
            return aux1.getApellido().compareTo(aux2.getApellido());
        }catch (Exception e){
            return 1;
        }
    }
}
