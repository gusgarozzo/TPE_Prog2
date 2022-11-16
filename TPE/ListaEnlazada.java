package TPE;

import java.util.Comparator;
import java.util.Iterator;

public class ListaEnlazada implements Iterable<Object>{
    private Nodo cabeza;
    private int size;
    private Comparator<Object> criterio;

    public ListaEnlazada( Comparator<Object> criterio, int size) {
        this.cabeza = null;
        this.size = size;
        this.criterio = criterio;
    }

    
    public void agregar(Object o){
        Nodo nodo = new Nodo(o);
        if(this.cabeza == null){
            this.cabeza =  nodo;
        }else{
            Nodo aux = this.cabeza;
            Nodo  ant = null;
            while (aux != null && criterio.compare(aux.obtenerValor(), nodo.obtenerValor()) < 0){
                ant = aux;
                aux = aux.obtenerSiguiente();
                
            }
            if (aux == null){
                ant.agregarNodo(nodo);
            }else{
                nodo.agregarNodo(aux);
                if (aux == this.cabeza){
                    this.cabeza = nodo;
                }
                else{
                    ant.setSiguiente(nodo);
                }
            }
            this.size++;
        }
    }
    
    public void eliminarCabeza(){
        if (isEmpty()){
            return;
        }
        else{
            this.cabeza = cabeza.obtenerSiguiente();
        }
    }
    
    public void eliminar(int index){
        if (verificar(index)){
            return;
        }else if(index == 0){
            this.eliminarCabeza();
            return;
        }
        else{
            int cont = 0;
            Nodo aux = cabeza;
            while (cont < index-1){
                aux = aux.obtenerSiguiente();
                cont++;
            }
            aux.agregarNodo(aux.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }

    public void eliminarOcurrencias(Object o){
        if (this.isEmpty()){
            return;
        }
        else{
            Nodo aux = this.cabeza;
    

            while (aux != null){
                while(aux.obtenerSiguiente() != null){
                    if(aux.obtenerValor() == o){
                        aux.setSiguiente(aux.obtenerSiguiente().obtenerSiguiente());
                    }else{
                        aux = aux.obtenerSiguiente();
                    }
                }
                aux = aux.obtenerSiguiente();
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        if (this.cabeza == null){
            return true;
        }
        return false;
    }

    public boolean verificar(int index){
        return (this.isEmpty() || index < 0 || index >= this.getSize() );
    }

    public Nodo obtenerNodo (int index){
        if (verificar(index)){
            return null;
        }
        else{
            int cont = 0;
            Nodo buscado = this.cabeza;
            while(cont < index){
                buscado = buscado.obtenerSiguiente();
                cont++;
            }
            return buscado;
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorNodos();
    }

        private class IteratorNodos  implements Iterator<Object>{
    		private int siguiente; //Indica el siguiente elemento 
        @Override
        public boolean hasNext() {
            return obtenerNodo(siguiente)!=null;
        }

        @Override
        public Object next() {
            Object obj = obtenerNodo(siguiente).obtenerValor();
            siguiente++;
            return obj;
        }
    }

}
