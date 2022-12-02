

import java.util.ArrayList;

public class Alumno extends ElementoFacultad{

    private String apellido;
    private int dni;
    private int edad;
    private ArrayList<String> intereses;

    public Alumno(String nombre, String apellido, int dni, int edad) {
        super(nombre);
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.intereses = new ArrayList<>();
    }

    public int getDni() {
        return this.dni;
    }

    public ArrayList<String> getIntereses() {
        return new ArrayList<>(this.intereses);
    }

    public void addIntereses(String palabra){
        if(!this.intereses.contains(palabra)){
            this.intereses.add(palabra);
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.apellido + ", " + this.nombre + ". DNI:" + this.dni;
    }

    @Override
    public int getCantidadAlumnos() {
        return 1;
    }
}
