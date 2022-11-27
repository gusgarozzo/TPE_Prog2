import java.util.ArrayList;
public class Grupo extends ElementoAbstracto implements Comparable<Grupo>{
	private ArrayList<ElementoAbstracto> elementos;

	public Grupo(String nombre) {
		super(nombre);
		this.elementos = new ArrayList<>();
	}
	
	public void agregarElemento(ElementoAbstracto e){
		if (!this.elementos.contains(e)) {
            this.elementos.add(e);
        }
	}

	@Override
	public int getCantidadAlumnos() {
		int cantidad = 0;
		for(ElementoAbstracto e:elementos)
			cantidad += e.getCantidadAlumnos();
		return cantidad;
	}

	@Override
    public boolean equals(Object o) {
        try {
            Grupo otroGrupo = (Grupo) o;
            return this.getNombre().equalsIgnoreCase(otroGrupo.getNombre());
        }
        catch(Exception exc) {
            return false;
        }
    }

	@Override
    public int compareTo(Grupo otroGrupo) {
        return this.getCantidadAlumnos() - otroGrupo.getCantidadAlumnos();
    }

}