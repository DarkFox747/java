package people;

import java.util.ArrayList;

import movements.DiaEntrenamiento;



public class Alumno extends Persona{
    public int numDiasRutina;
    private static int cantidadAlumnos = 0; 
    private ArrayList<DiaEntrenamiento> rutinas;
    private static ArrayList<String> nombresAlumnos = new ArrayList<>();
    private static ArrayList<Alumno> listaAlumnosObjetos = new ArrayList<>();

    public Alumno(String nombre, int numDiasRutina) {
        super(nombre);
        this.numDiasRutina = numDiasRutina;
        cantidadAlumnos++;
        this.rutinas = new ArrayList<>();
        if (nombre != "NombreDeAlumnoEjemplo" ){
            nombresAlumnos.add(nombre);
            listaAlumnosObjetos.add(this);
        }
        

    }
    public int getNumDias(){
        return numDiasRutina;
    }
    public static int gatcantidadAlumnos() {
        return cantidadAlumnos;
    }
    public static void listaAlumnos(){
        System.out.println("Lista de Alumnos: " + String.join(", ", nombresAlumnos));
    }
    public void agregarRutina(DiaEntrenamiento rutina) {
        rutinas.add(rutina);
    }
    

    public void imprimir(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nRutina de entrenamiento");
        System.out.println("Alumno: "+ getNombre());
        System.out.println("Dias de entrenamieto: "+ getNumDias());
        System.out.println("-----------------------------------");
        for (int i = 0; i < rutinas.size(); i++) {
            System.out.println("\nDía de entrenamiento #" + (i + 1));
            rutinas.get(i).mostrarEjercicios();
        }
        System.out.println("-----------------------------------");
    }

    public static ArrayList<String> alumnoEnLista() {
        return nombresAlumnos;
    }
    public static ArrayList<Alumno> getListaAlumnosObjetos() {
        return listaAlumnosObjetos;
    }


}
