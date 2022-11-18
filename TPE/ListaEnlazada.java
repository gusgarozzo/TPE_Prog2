package TPE;

import java.util.Comparator;
import java.util.Iterator;

public class ListaEnlazada implements Iterable<Object>{
    private Nodo cabeza;
    private int size;
    private Comparator<Object> criterio;

    public ListaEnlazada( Comparator<Object> criterio) {
        this.cabeza = null;
        this.size = 0;
        this.criterio = criterio;
    }

    
    public void agregar(Object o){
        Nodo nodo = new Nodo(o);
        if(this.cabeza == null){    
            this.cabeza =  nodo;
        }else{
            Nodo aux = this.cabeza;
            Nodo  ant = null;
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
            while (cont < index){
                aux = aux.obtenerSiguiente();
                cont++;
            }
            aux.agregarNodo(aux.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }

 
       
        
        

    public int getSize() {
        return this.size+1;
    }

    public boolean isEmpty(){
        if (this.cabeza == null){
            return true;
        }
        return false;
    }

    public boolean verificar(int index){
        return (this.isEmpty() || index < 0 || index > this.getSize() );
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

    public int buscarPos(Object o){
        Nodo actual = this.cabeza;		
        int pos = 0;
        Nodo buscado = new Nodo(o);
        while(pos < this.size+1){
            boolean i = actual.equals(o);
            if (actual.equals(buscado)){	
               
                return pos;
            }else{
                actual = actual.obtenerSiguiente();
                pos++;
            }
        }	
        return pos;
    }

    public int cantidadRepetidos(Object o){
        Nodo p = cabeza;
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
		if(this.isEmpty()) {
			return;
		}
		else {
			Nodo p = cabeza;;
			   
			    while(p!=null) {
			        while(p.obtenerSiguiente() != null) {
			            if(p.obtenerValor() == obj) {
			            	p.setSiguiente(p.obtenerSiguiente().obtenerSiguiente()); //el siguente de p es el 3ro
			              } else {
			                p = p.obtenerSiguiente();
			            }
			        }
			        p = p.obtenerSiguiente(); //ahora p es el segundo
			    }
			}
	}
    

    public Nodo buscarNodo (Object o){
        Nodo actual = this.cabeza;		
        int cont = 0;
        Nodo buscado = new Nodo(o);
        while(cont < this.size+1){
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

    public void setSize(int size){
         this.size = size;
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
