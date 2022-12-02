
import java.util.Comparator;

public class OrdenAscendente<T> extends Orden<T>{
    @Override
    public boolean menor(Node<T> newNode, Node<T> existingNode, Comparator<T> comparator) {
        return comparator.compare(newNode.obtenerValor(), existingNode.obtenerValor()) < 0;
    }
}
