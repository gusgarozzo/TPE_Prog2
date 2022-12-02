

import java.util.Comparator;

public abstract class ComparatorElementoFacultad implements Comparator<ElementoFacultad> {
    ComparatorElementoFacultad nextComparator;

    public ComparatorElementoFacultad() {
        this.nextComparator = null;
    }

    public ComparatorElementoFacultad(ComparatorElementoFacultad nextComparator) {
        this.nextComparator = nextComparator;
    }

    public abstract int comp(ElementoFacultad o1, ElementoFacultad o2);

    @Override
    public int compare(ElementoFacultad o1, ElementoFacultad o2) {
        int result = this.comp(o1, o2);
        if (result == 0 && this.nextComparator != null){
            return this.nextComparator.compare(o1, o2);
        }
        return result;
    }
}
