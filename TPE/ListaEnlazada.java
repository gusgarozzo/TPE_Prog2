
import java.util.Iterator;

public class ListaEnlazada implements Iterable<Nodo> {
    
    private Nodo nodo_raiz;
    private Comparador comportamiento;

    public ListaEnlazada(Comparador comportamiento) {
        this.comportamiento = comportamiento;
    }
    public ListaEnlazada(Nodo nodo_raiz, Comparador comportamiento) {
        this.nodo_raiz = nodo_raiz;
        this.comportamiento = comportamiento;
    }

    //Funcionalidades
    @Override
    public Iterator<Nodo> iterator() {
        return new IteradorNodos();
    }

    public void removeNodoPorValor(Comparable objeto_comparable) {
        Nodo siguiente_nodo_raiz = this.nodo_raiz.getSiguienteNodo();
        if (this.nodo_raiz.getObjetoAcomparar().compareTo(objeto_comparable) == 0) { 
            if (siguiente_nodo_raiz != null) {
                this.setNodoRaiz(siguiente_nodo_raiz);
                this.nodo_raiz.setAnteriorNodo(null);
                this.removeNodoPorValor(objeto_comparable);
            } else { 
                this.setNodoRaiz(null);
            }
        } else if (siguiente_nodo_raiz != null) { 
            siguiente_nodo_raiz.removeNodoPorValor(objeto_comparable);
        }
    }

    public void removeNodoPorPosicion(int posicion) {
        int posicion_nodo = 0;
        Nodo siguiente_nodo_raiz = this.nodo_raiz.getSiguienteNodo();
        if (posicion_nodo == posicion) {
            if (siguiente_nodo_raiz != null) {
                this.setNodoRaiz(siguiente_nodo_raiz); 
                this.nodo_raiz.setAnteriorNodo(null);
            } else { 
                this.setNodoRaiz(null);
            }
        } else if (siguiente_nodo_raiz != null) { 
            posicion_nodo++;
            siguiente_nodo_raiz.removeNodoPorPosicion(posicion_nodo, posicion); 
        }
    }

    public void addNodo(Comparable objeto_comparable) {
        Nodo nodo_nuevo = new Nodo(objeto_comparable);
        if (this.nodo_raiz != null) { 
            boolean seAgregaComoSiguiente = this.comportamiento.add(this.nodo_raiz, nodo_nuevo); 
            if (!seAgregaComoSiguiente) {
                this.setNodoRaiz(this.nodo_raiz.getAnteriorNodo());
            }
        } else {
            this.setNodoRaiz(nodo_nuevo);
        }
    }

    //Getters
    public Nodo getNodoPorPosicion(int posicion_param) {
        int posicion = 0;
        if (this.getPosicionNodo(this.nodo_raiz.getObjetoAcomparar()) == posicion_param) { 
            return this.nodo_raiz;
        }
        posicion++;
        Nodo siguiente_nodo = this.nodo_raiz.getSiguienteNodo();
        if (siguiente_nodo != null) {
            return siguiente_nodo.getNodoPorPosicion(posicion_param, posicion);
        }
        return null; 
    }

    public int getCantidadNodos() {
        int contador = 0;
        if (this.nodo_raiz != null) {
            contador++;
            Nodo siguiente_nodo = this.nodo_raiz.getSiguienteNodo();
            if (siguiente_nodo != null) {
                contador += siguiente_nodo.getCantidadNodos();
            }
        }
        return contador;
    }

    public int getPosicionNodo(Comparable objeto_comparable) {

        int posicion_nodo = 0; 
        if (this.nodo_raiz.getObjetoAcomparar().compareTo(objeto_comparable) == 0) {
            return posicion_nodo;
        }
        posicion_nodo++;
        Nodo siguiente_nodo = this.nodo_raiz.getSiguienteNodo();
        if (siguiente_nodo != null) { 
            return siguiente_nodo.getPosicionNodo(objeto_comparable, posicion_nodo);
        }
        return -1;
    }

    public Nodo getNodoRaiz() {
        return this.nodo_raiz;
    }

    public Comparador getComportamientoAdd() {
        return this.comportamiento;
    }

    public void setComportamientoAdd(Comparador comportamiento_add) { 
        this.comportamiento = comportamiento_add;
        this.invertirLista();
    }

    private void invertirLista() {
        int cantidad_nodos = this.getCantidadNodos();
        int posicion_final = cantidad_nodos - 1;
        Nodo ultimo_nodo = null;
        if (cantidad_nodos > 0) { 
            ultimo_nodo = this.getNodoPorPosicion(posicion_final);
        }
        while (posicion_final >= 0) {
            Nodo nodo_actual = this.getNodoPorPosicion(posicion_final);
            nodo_actual.invertirSiguienteAnterior();
            posicion_final--;
        }
        if (ultimo_nodo != null) {
            this.setNodoRaiz(ultimo_nodo);
        }
    }

    public void setNodoRaiz(Nodo nodo_raiz) {
        this.nodo_raiz = nodo_raiz;
    }
    private class IteradorNodos implements Iterator<Nodo> {

        private int posicion;

        public IteradorNodos() {
            this.posicion = 0;
        }

        @Override
        public boolean hasNext() {
            return this.posicion < getCantidadNodos();
        }

        @Override
        public Nodo next() {
            this.posicion++;
            return getNodoPorPosicion(this.posicion-1);
        }
    }
}