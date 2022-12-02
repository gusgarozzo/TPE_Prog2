
import java.util.Comparator;

public abstract class ComparatorAlumno implements Comparator<Alumno> {

    protected ComparatorAlumno nextComparator;

    public ComparatorAlumno() {
        this.nextComparator = null;
    }

    public ComparatorAlumno(ComparatorAlumno nextComparator) {
        this.nextComparator = nextComparator;
    }

    public abstract int comp(Alumno alu1, Alumno alu2);

    @Override
    public int compare(Alumno alu1, Alumno alu2) {
        int result = this.comp(alu1, alu2);
        if (result == 0 && this.nextComparator != null){
            return this.nextComparator.compare(alu1, alu2);
        }
        return result;
    }
}
