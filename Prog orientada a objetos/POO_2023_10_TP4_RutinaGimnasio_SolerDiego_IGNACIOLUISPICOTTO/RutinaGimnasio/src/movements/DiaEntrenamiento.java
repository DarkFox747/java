package movements;
import java.util.ArrayList;

public class DiaEntrenamiento {
    public ArrayList<Ejercicio> ejercicios = new ArrayList<>();

    // Método para agregar un ejercicio al día de entrenamiento
    public void agregarEjercicio(String nombre, String repeticiones, double peso) {
        Ejercicio ejercicio = new Ejercicio(nombre, repeticiones, peso);
        ejercicios.add(ejercicio);
    }
    // Método para mostrar los ejercicios del día de entrenamiento
    public void mostrarEjercicios() {
        System.out.println("Ejercicios del día de entrenamiento:");
        int i = 0;
        for (Ejercicio ejercicio : ejercicios) {
            
            System.out.println(i+". " + ejercicio);
            i++;
        }
    }
}