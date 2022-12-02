

public class ComparatorDNI extends ComparatorElementoFacultad{
    public ComparatorDNI() {
        super();
    }

    public ComparatorDNI(ComparatorElementoFacultad nextComparator) {
        super(nextComparator);
    }

    @Override
    public int comp(ElementoFacultad alu1, ElementoFacultad alu2) {
        try {
            Alumno aux1 = (Alumno) alu1;
            Alumno aux2 = (Alumno) alu2;
            return aux1.getDni() - aux2.getDni();
        }catch (Exception e){
            return 1;
        }
    }
}
