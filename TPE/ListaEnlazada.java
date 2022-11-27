
import java.util.Iterator;

public class ListaEnlazada implements Iterable<Nodo> {
    
    private Nodo cabeza;
    private Comparador comportamiento;

    public ListaEnlazada(Comparador comportamiento) {
        this.comportamiento = comportamiento;
    }
    public ListaEnlazada(Nodo cabeza, Comparador comportamiento) {
        this.cabeza = cabeza;
        this.comportamiento = comportamiento;
    }

    //Funcionalidades
    @Override
    public Iterator<Nodo> iterator() {
        return new IteradorNodos();
    }

    public void removeNodoPorValor(Comparable objComparable) {
        Nodo siguiente_cabeza = this.cabeza.getSiguienteNodo();
        if (this.cabeza.getObjetoAcomparar().compareTo(objComparable) == 0) { 
            if (siguiente_cabeza != null) {
                this.setNodoRaiz(siguiente_cabeza);
                this.cabeza.setAnteriorNodo(null);
                this.removeNodoPorValor(objComparable);
            } else { 
                this.setNodoRaiz(null);
            }
        } else if (siguiente_cabeza != null) { 
            siguiente_cabeza.removeNodoPorValor(objComparable);
        }
    }

    public void removeNodoPorPosicion(int posicion) {
        int posicion_nodo = 0;
        Nodo siguiente_cabeza = this.cabeza.getSiguienteNodo();
        if (posicion_nodo == posicion) {
            if (siguiente_cabeza != null) {
                this.setNodoRaiz(siguiente_cabeza); 
                this.cabeza.setAnteriorNodo(null);
            } else { 
                this.setNodoRaiz(null);
            }
        } else if (siguiente_cabeza != null) { 
            posicion_nodo++;
            siguiente_cabeza.removeNodoPorPosicion(posicion_nodo, posicion); 
        }
    }

    public void addNodo(Comparable objComparable) {
        Nodo nodo_nuevo = new Nodo(objComparable);
        if (this.cabeza != null) { 
            boolean seAgregaComoSiguiente = this.comportamiento.add(this.cabeza, nodo_nuevo); 
            if (!seAgregaComoSiguiente) {
                this.setNodoRaiz(this.cabeza.getAnteriorNodo());
            }
        } else {
            this.setNodoRaiz(nodo_nuevo);
        }
    }

    //Getters
    public Nodo getNodoPorPosicion(int posicion_param) {
        int posicion = 0;
        if (this.getPosicionNodo(this.cabeza.getObjetoAcomparar()) == posicion_param) { 
            return this.cabeza;
        }
        posicion++;
        Nodo siguiente_nodo = this.cabeza.getSiguienteNodo();
        if (siguiente_nodo != null) {
            return siguiente_nodo.getNodoPorPosicion(posicion_param, posicion);
        }
        return null; 
    }

    public int getCantidadNodos() {
        int contador = 0;
        if (this.cabeza != null) {
            contador++;
            Nodo siguiente_nodo = this.cabeza.getSiguienteNodo();
            if (siguiente_nodo != null) {
                contador += siguiente_nodo.getCantidadNodos();
            }
        }
        return contador;
    }

    public int getPosicionNodo(Comparable objComparable) {

        int posicion_nodo = 0; 
        if (this.cabeza.getObjetoAcomparar().compareTo(objComparable) == 0) {
            return posicion_nodo;
        }
        posicion_nodo++;
        Nodo siguiente_nodo = this.cabeza.getSiguienteNodo();
        if (siguiente_nodo != null) { 
            return siguiente_nodo.getPosicionNodo(objComparable, posicion_nodo);
        }
        return -1;
    }

    public Nodo getNodoRaiz() {
        return this.cabeza;
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

    public void setNodoRaiz(Nodo cabeza) {
        this.cabeza = cabeza;
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