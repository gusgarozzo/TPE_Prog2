

import java.util.Comparator;

public abstract class Orden<T>{
    public abstract boolean menor(Node<T> newNode, Node<T> existingNode, Comparator<T> comparator);
}
