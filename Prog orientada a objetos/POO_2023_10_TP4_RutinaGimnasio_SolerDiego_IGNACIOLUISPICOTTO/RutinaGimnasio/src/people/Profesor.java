package people;
import java.util.ArrayList;
import java.util.Arrays;

public class Profesor extends Persona{
    //array para almacernar la cantidad de alumnos cereados.
    private ArrayList<Alumno> alumnosACargo;
    private static ArrayList<String> nombresProfesores = new ArrayList<>(Arrays.asList("Alejandro", "Pepe", "Marcelo"));
    private static int cantidadProfesores = 0;
    public Profesor(String nombre) {
        super(nombre);
        this.alumnosACargo = new ArrayList<>();
        cantidadProfesores++;
        nombresProfesores.add(nombre);               
    }

    //devuelve la cantidad de profesores
    public static int cantidadProfesores() {
        return cantidadProfesores;
    }
    public void agregarAlumno(Alumno alumno) {
        alumnosACargo.add(alumno);
    }
    public void getListaAlumnosACargo() {
        System.out.println("Alumnos a cargo del profesor " + getNombre() + ":");
        for (Alumno alumno : alumnosACargo) {
            System.out.println("- " + alumno.getNombre());
        }
    }
    public static void getNombresProfesores() {
        System.out.println("Lista de Profes: " + String.join(", ", nombresProfesores));
    }

    public static ArrayList<String> profeEnLista() {
        return nombresProfesores;
    }
}
