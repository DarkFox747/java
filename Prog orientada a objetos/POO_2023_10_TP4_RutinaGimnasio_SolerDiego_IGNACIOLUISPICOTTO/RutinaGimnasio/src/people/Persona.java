package people;

public abstract class Persona {
    private String nombre;
    private static int cantidadPersonas = 0;

    public Persona(String nombre) {
        this.nombre = nombre;
        cantidadPersonas++;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public static int getCantidadPersonas() {
        return cantidadPersonas;
    }
}

