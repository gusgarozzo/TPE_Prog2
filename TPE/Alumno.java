import java.util.ArrayList;
public class Alumno extends ElementoAbstracto implements Comparable<Alumno>{
	private String apellido;
	private String dni;
	private int edad;
	private ArrayList<String> intereses;

	public Alumno(String nombre, String apellido, String dni, int edad) {
		super(nombre);
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.intereses = new ArrayList<>();
	}
	
	public void agregarIntereses(String interes){
		if (!this.intereses.contains(interes)) {
            this.intereses.add(interes);
        }
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int getCantidadAlumnos() {
		return 1;
	}

    @Override
    public String toString() {
        return "Alumno nombre=" + this.getNombre() + ", apellido=" + this.apellido;
    }

	 
    @Override
    public boolean equals(Object o) {
        try {
            Alumno otroAlumno = (Alumno) o;
            return this.getNombre().equalsIgnoreCase(otroAlumno.getNombre()) && this.getApellido().equalsIgnoreCase(otroAlumno.getApellido()) && this.getDni().equalsIgnoreCase(otroAlumno.getDni());
        }
        catch(Exception exc) {
            return false;
        }
    }

	@Override
    public int compareTo(Alumno otroAlumno) {
        int resultado = this.getApellido().compareToIgnoreCase(otroAlumno.getApellido());
        if (resultado == 0) {
            resultado = this.getNombre().compareToIgnoreCase(otroAlumno.getNombre());
        }
        if (resultado == 0) {
            resultado = this.getDni().compareToIgnoreCase(otroAlumno.getDni());
        }
        return resultado;
    }
}