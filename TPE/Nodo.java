package TPE;

public class Nodo {
    private Object valor;
    private Nodo siguiente;

    public Nodo(Object valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Object obtenerValor(){
        return valor;
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

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }


    public String toString(){
        return this.valor.toString();
    }
}
