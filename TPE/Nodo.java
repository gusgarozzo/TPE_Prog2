
public class Nodo  {
    private Comparable comparar;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Comparable objComparable) {
        this.comparar = objComparable;
    }

    public void invertirSiguienteAnterior() {
        Nodo aux = this.siguiente;
        this.setSiguienteNodo(this.anterior);
        this.setAnteriorNodo(aux);
    }

    public void eliminarNodoElement(Comparable objComparable) {
        if (this.comparar.compareTo(objComparable) == 0) { 
            if (this.siguiente != null) { 
                this.anterior.setSiguienteNodo(this.siguiente); 
                this.anterior.eliminarNodoElement(objComparable); 
                this.siguiente.setAnteriorNodo(this.anterior); 
            } else {
                this.anterior.setSiguienteNodo(null); 
            }
        } else if (this.siguiente != null) {
            this.siguiente.eliminarNodoElement(objComparable);
        }
    }

    public void eliminarNodoPos(int posicion_nodo, int posicion) {
        if (posicion_nodo == posicion) { 
            if (this.siguiente != null) {
                this.anterior.setSiguienteNodo(this.siguiente); 
                this.siguiente.setAnteriorNodo(this.anterior);
            } else {
                this.anterior.setSiguienteNodo(null);
            }
        } else if (this.siguiente != null) {
            posicion_nodo++;
            this.siguiente.eliminarNodoPos(posicion_nodo, posicion);
        }
    }

    public Nodo getNodoPorPosicion(int posicion_param, int posicion_nodo) {
        if (posicion_nodo == posicion_param) {
            return this;
        }
        posicion_nodo++;
        if (this.siguiente != null) {
            return this.siguiente.getNodoPorPosicion(posicion_param, posicion_nodo);
        }
        return null;
    }

    public int getCantidadNodos() {
        int contador = 1;
        if (this.siguiente != null) {
            contador += this.siguiente.getCantidadNodos();
        }
        return contador;
    }

    public int getPosicionNodo(Comparable objComparable, int posicion_nodo) {
        if (this.comparar.compareTo(objComparable) == 0) {
            return posicion_nodo;
        }
        posicion_nodo++;
        if (this.siguiente != null) {
            return this.siguiente.getPosicionNodo(objComparable, posicion_nodo);
        }
        return -1;
    }

    public Comparable getObjetoAcomparar() {
        return this.comparar;
    }

    public Nodo getSiguienteNodo() {
        return this.siguiente;
    }

    public Nodo getAnteriorNodo() {
        return this.anterior;
    }

     public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguiente = siguienteNodo;
    }

    public void setAnteriorNodo(Nodo anteriorNodo) {
        this.anterior = anteriorNodo;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Nodo otroNodo = (Nodo) o;
            return this.getObjetoAcomparar().equals(otroNodo.getObjetoAcomparar());
        }
        catch(Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.comparar + "";
    }
}
