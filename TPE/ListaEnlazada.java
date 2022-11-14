package TPE;

public class ListaEnlazada {
    Nodo cabeza;
    int size;

    public ListaEnlazada(Nodo cabeza) {
        this.cabeza = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void agregar(Object o){
        if(cabeza == null){
            cabeza = new Nodo ();
            cabeza.setValor(o);
        }else{
            Nodo aux = cabeza;
            Nodo nuevo = new Nodo();
            nuevo.agregarNodo(aux);
            nuevo.setValor(o);
            cabeza = nuevo;
        }
    }

    public void eliminar(int index){
        int cont = 0;
        Nodo aux = cabeza;
        if(index == 0){
            cabeza = cabeza.obtenerSiguiente();
        }else{
            while (cont < index-1){
                aux = aux.obtenerSiguiente();
                cont++;
            }
            aux.agregarNodo(aux.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }

    public void eliminarOcurrencias(Object o){
        Nodo aux = new Nodo();
        Nodo anterior = new Nodo();

        aux = cabeza;
        anterior = null;

        while (aux != null){
            while(aux.obtenerValor() == o){
                if(aux == cabeza){
                    cabeza = cabeza.obtenerSiguiente();
                }else{
                    anterior.siguiente = cabeza.obtenerSiguiente();
                }
            }
            anterior = aux;
            aux = aux.obtenerSiguiente();
        }
    }
}
