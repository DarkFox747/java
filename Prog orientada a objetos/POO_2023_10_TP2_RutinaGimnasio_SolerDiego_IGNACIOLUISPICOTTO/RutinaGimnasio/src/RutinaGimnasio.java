import java.util.ArrayList;
import java.util.Scanner;


class Alumno {
    String nombre;
    int numDiasRutina;

    public Alumno(String nombre, int numDiasRutina) {
        this.nombre = nombre;
        this.numDiasRutina = numDiasRutina;
    }
    public String getNombre() {
        return nombre;}
    public int getNumDias(){
        return numDiasRutina;
    }
}


class Ejercicio {
    String nombre;
    String repeticiones;
    double peso;

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


class DiaEntrenamiento {
    ArrayList<Ejercicio> ejercicios = new ArrayList<>();

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

class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y obtener la opción del usuario
    public int mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Editar nombre del alumno");
        System.out.println("2. Rehacer rutina");
        System.out.println("3. Cambiar cantidad de días");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }
}

public class RutinaGimnasio {
    private Scanner scanner;
    private Alumno alumno;
    private ArrayList<DiaEntrenamiento> rutina;

    public RutinaGimnasio(String nombreAlumno, int numDias) {
        alumno = new Alumno(nombreAlumno, numDias);
        rutina = new ArrayList<>();
    }
    // Método para crear la rutina de entrenamiento
    public void creadorDeRutina(){
        scanner = new Scanner(System.in);
        for (int i = 1; i <= alumno.numDiasRutina; i++) {
            DiaEntrenamiento dia = new DiaEntrenamiento();
            System.out.println("Día de entrenamiento #" + i);

            boolean agregarEjercicio = true;
            while (agregarEjercicio) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Día de entrenamiento #" + i);
                dia.mostrarEjercicios();
                System.out.print("Nombre del ejercicio: ");
                String nombreEjercicio = scanner.nextLine();

                System.out.print("Repeticiones: ");
                String repeticiones = scanner.nextLine();

                System.out.print("Peso (kg): ");
                double peso = scanner.nextDouble();
                scanner.nextLine(); 

                dia.agregarEjercicio(nombreEjercicio, repeticiones, peso);

                System.out.print("¿Agregar otro ejercicio? (Sí/No): ");
                String respuesta = scanner.nextLine().toLowerCase();
                agregarEjercicio = respuesta.equals("sí") || respuesta.equals("si");
            }

            rutina.add(dia);
        }
    }
    // Método para imprimir la rutina de entrenamiento
    public void imprimir(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nRutina de entrenamiento");
        System.out.println("Alumno: "+alumno.getNombre());
        System.out.println("Dias de entrenamieto: "+alumno.getNumDias());
        System.out.println("-----------------------------------");
        for (int i = 0; i < rutina.size(); i++) {
            System.out.println("\nDía de entrenamiento #" + (i + 1));
            rutina.get(i).mostrarEjercicios();
        }
        System.out.println("-----------------------------------");
    }
    
    // Método principal que ejecuta el programa
    public void ejecutar() {
        scanner = new Scanner(System.in);
        Menu menu = new Menu();
        boolean salir = false;
        
        while (!salir) {
            imprimir();
            int opcion = menu.mostrarMenu();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre del alumno: ");
                    String nuevoNombre = new Scanner(System.in).nextLine();
                    alumno.nombre = nuevoNombre;
                    break;
                case 2:
                    rutina.clear();
                    creadorDeRutina();                  
                    break;
                case 3:
                    System.out.print("Nueva cantidad de días: ");
                    int nuevaCantidadDias = new Scanner(System.in).nextInt();
                    alumno.numDiasRutina = nuevaCantidadDias;
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nombre del alumno: ");
        String nombreAlumno = scanner.nextLine();

        System.out.print("¿Cuántos días quieres entrenar?: ");
        int numDias = scanner.nextInt();
        scanner.nextLine();        
        
        RutinaGimnasio rutinaGimnasio = new RutinaGimnasio(nombreAlumno, numDias);
        rutinaGimnasio.creadorDeRutina();
        rutinaGimnasio.ejecutar();
        scanner.close();
        
    }
}
