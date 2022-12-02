


public abstract class ElementoFacultad implements Comparable<ElementoFacultad>{
    protected String nombre;
    protected ComparatorElementoFacultad comparator;

    public ElementoFacultad(String nombre) {
        this.comparator = new ComparatorCantAlumnos(
                            new ComparatorApellido(
                                new ComparatorNombre(
                                    new ComparatorDNI()
                                )
                            )
                        );
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public abstract int getCantidadAlumnos();

    @Override
    public int compareTo(ElementoFacultad elem) {
        return this.getCantidadAlumnos() - elem.getCantidadAlumnos();
    }
}
