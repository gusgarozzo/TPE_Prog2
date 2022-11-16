package TPE;


import java.util.ArrayList;

public class Grupo extends ElementoAbstracto{
	private ArrayList<ElementoAbstracto> elementos;

	public Grupo(String nombre) {
		super(nombre);
		this.elementos = new ArrayList<>();
	}
	
	public void agregarElemento(ElementoAbstracto e){
		this.elementos.add(e);
	}

	@Override
	public int getCantidadAlumnos() {
		int cantidad = 0;
		for(ElementoAbstracto e:elementos)
			cantidad += e.getCantidadAlumnos();
		return cantidad;
	}

}