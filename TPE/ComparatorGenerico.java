
import java.util.Comparator;

public class ComparatorGenerico<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        try{
            return ((Comparable<T>) o1).compareTo(o2);
        }catch (Exception e){
            return 1;
        }
    }
}
