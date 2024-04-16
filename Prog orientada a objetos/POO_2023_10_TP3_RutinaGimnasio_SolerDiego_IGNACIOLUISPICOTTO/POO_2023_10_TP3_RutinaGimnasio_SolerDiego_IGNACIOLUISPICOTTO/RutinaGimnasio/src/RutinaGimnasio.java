import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import people.*;
import movements.*;
import menus.*;



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
        for (int i = 1; i <= alumno.getNumDias(); i++) {
            agregarDiaDeEjercicio();
            
        }
    }
    public void agregarDiaDeEjercicio(){
        scanner = new Scanner(System.in);
        DiaEntrenamiento dia = new DiaEntrenamiento();
        boolean agregarEjercicio = true;
            while (agregarEjercicio) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                int longitud = rutina.size() + 1 ;
                System.out.println("Día de entrenamiento #" + longitud);
                dia.mostrarEjercicios();
                System.out.print("Nombre del ejercicio: ");
                String nombreEjercicio = scanner.nextLine();
                System.out.print("Repeticiones: ");
                String repeticiones = scanner.nextLine();

                //bucle para asegurarno que el peso es correcto.
                boolean entradaValida = false;
                double peso = 0;
                while (!entradaValida){
                    try{
                        System.out.print("Peso (kg):(10,20,10,5,...) ");
                        peso = scanner.nextDouble();
                        scanner.nextLine();
                        entradaValida = true;}
                    catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un número válido para el peso.(10,20,10,5,...)");
                        scanner.next(); // Consumir la entrada inválida
                }}


                dia.agregarEjercicio(nombreEjercicio, repeticiones, peso);

                System.out.print("¿Agregar otro ejercicio? (Sí/No): ");
                String respuesta = scanner.nextLine().toLowerCase();
                agregarEjercicio = respuesta.equals("sí") || respuesta.equals("si");
            }
            rutina.add(dia);
    }


    public void editarRutina(){

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
                    alumno.setNombre(nuevoNombre); // este metodo esta definido en la clase persona
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
                case 10:
                    salir = true;
                    break;
                case 4:
                    agregarDiaDeEjercicio();
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

        //loop para evitar valores erroneos en los dias.
        int numDias = 0;
        boolean a = false;
        while (!a){
            try {
                System.out.print("¿Cuántos días quieres entrenar?(1,2,3,...): ");
                numDias = scanner.nextInt();
                scanner.nextLine();
                a = true;
            }catch (InputMismatchException e){
                System.out.println("Por favor ingrese un numero valido para los dias a entrenar.(1,2,3,...)");
                scanner.next();
            }
        }          
        
        RutinaGimnasio rutinaGimnasio = new RutinaGimnasio(nombreAlumno, numDias);
        rutinaGimnasio.creadorDeRutina();
        rutinaGimnasio.ejecutar();
        scanner.close();        
    }
}



