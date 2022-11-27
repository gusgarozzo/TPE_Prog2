

public class Nodo  {
    private Comparable comparar;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Comparable objeto_comparable) {
        this.comparar = objeto_comparable;
    }

     
    //Funcionalidades
    public void invertirSiguienteAnterior() {
        Nodo aux = this.siguiente;
        this.setSiguienteNodo(this.anterior);
        this.setAnteriorNodo(aux);
    }

    public void removeNodoPorValor(Comparable objeto_comparable) {
        if (this.comparar.compareTo(objeto_comparable) == 0) { 
            if (this.siguiente != null) { 
                this.anterior.setSiguienteNodo(this.siguiente); 
                this.anterior.removeNodoPorValor(objeto_comparable); 
                this.siguiente.setAnteriorNodo(this.anterior); 
            } else {
                this.anterior.setSiguienteNodo(null); 
            }
        } else if (this.siguiente != null) {
            this.siguiente.removeNodoPorValor(objeto_comparable);
        }
    }

    public void removeNodoPorPosicion(int posicion_nodo, int posicion) {
        if (posicion_nodo == posicion) { 
            if (this.siguiente != null) {
                this.anterior.setSiguienteNodo(this.siguiente); 
                this.siguiente.setAnteriorNodo(this.anterior);
            } else {
                this.anterior.setSiguienteNodo(null);
            }
        } else if (this.siguiente != null) {
            posicion_nodo++;
            this.siguiente.removeNodoPorPosicion(posicion_nodo, posicion);
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

    public int getPosicionNodo(Comparable objeto_comparable, int posicion_nodo) {
        if (this.comparar.compareTo(objeto_comparable) == 0) {
            return posicion_nodo;
        }
        posicion_nodo++;
        if (this.siguiente != null) {
            return this.siguiente.getPosicionNodo(objeto_comparable, posicion_nodo);
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

     public void setSiguienteNodo(Nodo siguiente_nodo) {
        this.siguiente = siguiente_nodo;
    }

    public void setAnteriorNodo(Nodo anterior_nodo) {
        this.anterior = anterior_nodo;
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
