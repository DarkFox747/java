package movements;

public class Ejercicio {
    public String nombre;
    public String repeticiones;
    public double peso;

    public Ejercicio(String nombre, String repeticiones, double peso) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.peso = peso;
    }
    // Método para mostrar el ejercicio en formato legible
    @Override
    public String toString() {
        return nombre + " - Repeticiones: " + repeticiones + " - Peso: " + peso + " kg";
    }
}
