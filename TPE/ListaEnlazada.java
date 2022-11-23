package TPE;

import java.util.Comparator;
import java.util.Iterator;

public class ListaEnlazada implements Iterable<Object>{
    private Nodo cabeza;
    private Comparator<Object> criterio;

    public ListaEnlazada( Comparator<Object> criterio) {
        this.cabeza = null;
        this.criterio = criterio;
    }


    public void agregar(Object o){
        TPE.Nodo nodo = new Nodo(o);
        if(this.cabeza == null){    
            this.cabeza =  nodo;
        }else{
            TPE.Nodo aux = this.cabeza;
            TPE.Nodo ant = null;
            while (aux != null && criterio.compare(aux.obtenerValor(), nodo.obtenerValor()) < 0 ){
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
        }
    }
    
    public void eliminarCabeza(){
        if (!isEmpty()){
            this.cabeza = cabeza.obtenerSiguiente();
        }
    }
    
    public void eliminar(int index){
        if (!verificar(index)){
            if(index == 0){
                this.eliminarCabeza();
            }
            else{
                int cont = 0;
                TPE.Nodo aux = cabeza;
                while (cont < index){
                    aux = aux.obtenerSiguiente();
                    cont++;
                }
                aux.agregarNodo(aux.obtenerSiguiente().obtenerSiguiente());
            }
        }
    }

    public boolean isEmpty(){
        if (this.cabeza == null){
            return true;
        }
        return false;
    }

    public boolean verificar(int index){
        return (this.isEmpty() || index < 0);
    }

    public TPE.Nodo obtenerNodo (int index){
        if (verificar(index)){
            return null;
        }
        else{
            int cont = 0;
            TPE.Nodo buscado = this.cabeza;
            while(cont < index){
                buscado = buscado.obtenerSiguiente();
                cont++;
            }
            return buscado;
        }
    }

    public int buscarPos(Object o){
        TPE.Nodo actual = this.cabeza;
        Integer pos = 0;
        while(pos != null){
            if (actual.obtenerValor() == o){
                return pos;
            }else{
                actual = actual.obtenerSiguiente();
                pos++;
            }
        }
        return -1;
    }

    public int cantidadRepetidos(Object o){
        TPE.Nodo p = cabeza;
        int cant = 0;
        while(p!=null) {
            if (p.obtenerValor() == o){
                cant++;
            }else{
            }
            p =  p.obtenerSiguiente();
        }
return cant;
    }

    public void eliminarTodasLasOcurrencias(Object obj) {
		if(!this.isEmpty()) {
            TPE.Nodo p = cabeza;
            while(p!=null) {
                while(p.obtenerSiguiente() != null) {
                    if(p.obtenerValor() == obj) {
                        if (p.obtenerValor() == this.cabeza){
                            this.eliminarCabeza();
                        }else{
                            p.setSiguiente(p.obtenerSiguiente().obtenerSiguiente());
                        }

                    } else {
                        p = p.obtenerSiguiente();
                    }
                }
                p = p.obtenerSiguiente();
            }
		}
	}
    

    public Nodo buscarNodo (Object o){
        TPE.Nodo actual = this.cabeza;
        Integer cont = 0;
        TPE.Nodo buscado = new Nodo(o);
        while(cont != null){
            if (actual.equals(buscado)){
                System.out.println("Elemento encontrado en la pos "+ cont);		
            return buscado;
            }else{
                actual = actual.obtenerSiguiente();
            }
            cont++;
        }
        System.out.println("No se encontro el elemento ");		
        return buscado;
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
