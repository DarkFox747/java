//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522

import java.util.Scanner;


public class Consigna3 
{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Frecuencia frecuenciaLetras = new Frecuencia();
        boolean continuar = true;

        while (continuar) {
            try {
                // Definir el tamaño del arreglo
                System.out.print("Ingrese el numero de palabras que desea almacenar: ");
                int n = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer

                String[] palabras = new String[n];

                // Almacenar palabras ingresadas por teclado
                for (int i = 0; i < n; i++) {
                    System.out.print("Ingrese la palabra " + (i + 1) + ": ");
                    palabras[i] = teclado.nextLine();
                }

                // Listar todas las palabras almacenadas
                System.out.println("\nPalabras almacenadas:");
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + ": " + palabras[i]);
                }

                // Elegir una palabra para contar la frecuencia de letras
                int index = -1;
                while (true) {
                    System.out.print("\nIngrese el numero de la palabra para contar la frecuencia de letras: ");
                    try {
                        index = teclado.nextInt() - 1; // Ajuste para indice basado en 0
                        if (index >= 0 && index < n) {
                            break;
                        } else {
                            System.out.println("Indice fuera de rango. Intente de nuevo.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error de entrada: " + e.getMessage());
                        teclado.nextLine(); // Limpiar el buffer en caso de error
                    }
                }

                int[] conteos = frecuenciaLetras.contarFrecuencia(palabras[index]);
                System.out.println("\nFrecuencia de letras en la palabra \"" + palabras[index] + "\":");
                for (int i = 0; i < conteos.length; i++) {
                    if (conteos[i] != 0) {
                        System.out.println((char)(i + 'A') + ": " + conteos[i]); 
                    }
                }

                // Preguntar si el usuario quiere repetir la operacion
                System.out.print("\n¿Desea repetir el programa? (y/n): ");
                char respuesta = teclado.next().charAt(0);
                teclado.nextLine(); // Limpiar el buffer

                if (respuesta == 'n' || respuesta == 'N') {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Error de entrada: " + e.getMessage());
                teclado.nextLine(); // Limpiar el buffer en caso de error
            }
        }

        teclado.close();
    }
}
