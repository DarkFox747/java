package people;

public abstract class Persona {
    public String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

