public abstract class ElementoAbstracto {
	private String nombre;
	
	public ElementoAbstracto(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
    public String toString() {
        return "ElementoEstudiantil nombre=" + this.nombre;
    }

	public abstract int getCantidadAlumnos();
}