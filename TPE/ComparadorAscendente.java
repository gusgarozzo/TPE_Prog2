
public class ComparadorAscendente extends Comparador{
    // si el nodo nuevo se setea como anterior al nodo actual devuelve false, sino true
    @Override
    public boolean add(Nodo nodo, Nodo nuevo) {
        int resultado = nodo.getObjetoAcomparar().compareTo(nuevo.getObjetoAcomparar());
        if (resultado <= 0 ) {
            Nodo siguiente = nodo.getSiguienteNodo();
            if (siguiente != null) {
                int resultado2 = siguiente.getObjetoAcomparar().compareTo(nuevo.getObjetoAcomparar());
                if (resultado2 <= 0) { 
                    this.add(siguiente, nuevo);
                    return true;
                }
            }
            nodo.setSiguienteNodo(nuevo); 
            nuevo.setAnteriorNodo(nodo);
            if (siguiente != null) {
                nuevo.setSiguienteNodo(siguiente);
            }
            return true;
        } else {
            nodo.setAnteriorNodo(nuevo);
            nuevo.setSiguienteNodo(nodo);
            return false;
        }
    }
}