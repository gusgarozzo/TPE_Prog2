package TPE;

public class Nodo {
    Object valor;
    Nodo siguiente;

    public Nodo() {
        this.valor = null;
        this.siguiente = null;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void agregarNodo(Nodo n){
        siguiente = n;
    }

    public Nodo obtenerSiguiente(){
        return siguiente;
    }

    public Object obtenerValor(){
        return valor;
    }
}
