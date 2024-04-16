package menus;
import java.util.Scanner;

public class Menu {
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
        System.out.println("4. Agregar un dia de ejercicio");
        System.out.println("10. Salir");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }
}