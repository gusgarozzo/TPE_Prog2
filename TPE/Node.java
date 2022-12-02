

public class Node<T>{
    T valor;
    Node<T> siguiente;

    public Node(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public T obtenerValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Node<T> obterSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }
}
