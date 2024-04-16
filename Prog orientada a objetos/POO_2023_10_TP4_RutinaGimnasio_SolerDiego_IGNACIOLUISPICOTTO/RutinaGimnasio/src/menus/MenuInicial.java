package menus;
import java.util.Scanner;

public class MenuInicial implements iMenuPrincipal {
    private Scanner scanner;

    public MenuInicial() {
        scanner = new Scanner(System.in);
    }
    @Override
    public int mostrarMenu(){
        System.out.println("Bienvenido a la app de rutinas de gimnasio:");
        System.out.println("Elige una opcion");
        System.out.println("1. Lista de alumnos");
        System.out.println("2. Lista de profesores");
        System.out.println("3. Ver rutina de un alumno");
        System.out.println("4. Crear una rutina nueva");
        System.out.println("10. Salir");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }
}
