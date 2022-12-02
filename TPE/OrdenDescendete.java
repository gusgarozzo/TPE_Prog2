

import java.util.Comparator;

public class OrdenDescendete<T> extends Orden<T>{

    @Override
    public boolean menor(Node<T> newNode, Node<T> existingNode, Comparator<T> comparator) {
        return -1 * comparator.compare(newNode.obtenerValor(), existingNode.obtenerValor()) < 0;
    }
}
