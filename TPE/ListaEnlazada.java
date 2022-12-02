

import java.util.Comparator;
import java.util.Iterator;

public class ListaEnlazada<T> implements Iterable<T>{

    private Node<T> nodoInicial;
    private Node<T> puntero;
    private Orden<T> orden;
    private Comparator<T> comparator;

    public ListaEnlazada(Comparator<T> comparator){
        this(new OrdenAscendente<>(), comparator);
    }

    public ListaEnlazada(){
        this.orden = new OrdenAscendente<>();
        this.comparator = new ComparatorGenerico<>();
    }

    public ListaEnlazada(Orden<T> orden, Comparator<T> comparator){
        this.nodoInicial = null;
        this.puntero = null;
        this.orden = orden;
        this.comparator = comparator;
    }

    public void agregar(Node<T> node){
        if (this.nodoInicial == null){
            this.nodoInicial = node;
        }else if(this.orden.menor(node, this.nodoInicial, this.comparator)){
            node.setSiguiente(this.nodoInicial);
            this.nodoInicial = node;
        } else {
            this.puntero = this.nodoInicial;
            boolean found = false;
            while (!found && (this.puntero.obterSiguiente() != null)) {
                if (this.orden.menor(node, this.puntero.obterSiguiente(), this.comparator)){
                    found = true;
                } else {
                    this.puntero = this.puntero.obterSiguiente();
                }
            }
            node.setSiguiente(this.puntero.obterSiguiente());
            this.puntero.setSiguiente(node);
        }
    }

    public void eliminarNodo(int position){
        if(position < 0)
            return;
        if(this.nodoInicial == null)
            return;
        if (position == 0) {
            this.nodoInicial = this.nodoInicial.obterSiguiente();
            return;
        }
        this.puntero = this.nodoInicial;
        int punteroPosition = 0;
        while (this.puntero != null && punteroPosition < (position-1)){
            this.puntero = this.puntero.obterSiguiente();
            punteroPosition++;
        }
        if(this.puntero != null){
            Node<T> toDelete = this.puntero.obterSiguiente();
            if(toDelete != null){
                this.puntero.setSiguiente(toDelete.obterSiguiente());
            }
        }
    }

    public void eliminarNodo(Node<T> node){
        if(this.nodoInicial == null)
            return;
        this.puntero = this.nodoInicial;
        while (this.puntero.obterSiguiente() != null){
            if (this.puntero == this.nodoInicial && this.comparator.compare(this.puntero.obtenerValor(), node.obtenerValor()) == 0){
                this.nodoInicial = this.nodoInicial.obterSiguiente();
                this.puntero = this.nodoInicial;
            }else if(this.comparator.compare(this.puntero.obterSiguiente().obtenerValor(), node.obtenerValor()) == 0){
                Node<T> toDelete = this.puntero.obterSiguiente();
                this.puntero.setSiguiente(toDelete.obterSiguiente());
            }else{
                this.puntero = this.puntero.obterSiguiente();
            }
        }
        if(this.comparator.compare(this.nodoInicial.obtenerValor(), node.obtenerValor()) == 0){
            this.nodoInicial = null;
        }
    }

    public int obtenerValorPorPos(Node<T> node){
        this.puntero = this.nodoInicial;
        int punteroPosition = 0;
        while (this.puntero != null){
            if(this.comparator.compare(this.puntero.obtenerValor(),node.obtenerValor()) == 0){
                return punteroPosition;
            }else{
                this.puntero = this.puntero.obterSiguiente();
                punteroPosition++;
            }
        }
        return -1;
    }

    private Node<T> getNodoInicial(){
        return this.nodoInicial;
    }

    public void setorden(Orden<T> orden){
        ListaEnlazada<T> aux = new ListaEnlazada<>(orden, this.comparator);
        this.puntero = this.nodoInicial;
        while (this.puntero != null){
            Node<T> auxNode = new Node<>(this.puntero.obtenerValor());
            aux.agregar(auxNode);
            this.puntero = this.puntero.obterSiguiente();
        }
        this.nodoInicial = aux.getNodoInicial();
    }

    public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
        this.setorden(this.orden);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorNodo<>(this.nodoInicial);
    }


    public class IteratorNodo<T> implements Iterator<T> {

        private Node<T> pointer;
    
        public IteratorNodo(Node<T> pointer) {
            this.pointer = pointer;
        }
    
        @Override
        public boolean hasNext() {
            return this.pointer != null;
        }
    
        @Override
        public T next() {
            T value = this.pointer.obtenerValor();
            this.pointer = this.pointer.obterSiguiente();
            return value;
        }
    }



}
