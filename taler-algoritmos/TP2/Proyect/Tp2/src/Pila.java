//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522


import java.util.InputMismatchException;
import java.util.Scanner;

//Clase pila solicida de enteros
public class Pila {
    private int maxSize;
    private int[] stackArray;
    private int top;

    //Determinacion del tamaño de la pila
    public Pila(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    //Agregar un elemento a la pila
    public void push() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un valor a apilar: ");
        //Un validador para evitar errores dado que la pila solo acepta enteros
        try {
            int value = scanner.nextInt();
            if (top == maxSize - 1) {
                System.out.println("La pila esta llena.");
            } else {
                stackArray[++top] = value;
                System.out.println("Elemento " + value + " apilado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no valida. Por favor, ingresa un numero.");
            scanner.next(); 
        }
        scanner.close();
    }

    //Aliminar un elemento de la pila
    public int pop() {
        if (top == -1) {
            System.out.println("La pila esta vacia.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }

    //Mostrar los elementos que se encuentran en la pila
    public void display() {
        if (top == -1) {
            System.out.println("La pila esta vacia.");
        } else {
            System.out.print("Elementos en la pila: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    //Run de la pila, con un menu que le permite al usuario manipular tanto el tamaño de la pila como sus elementos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el tamano de la pila: ");
        int size = scanner.nextInt();
        Pila pila = new Pila(size);
    
        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Apilar");
            System.out.println("2. Retirar elementos");
            System.out.println("3. Verificar si la pila esta vacia");
            System.out.println("4. Mostrar elementos de la pila");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            option = scanner.nextInt();
    
            switch (option) {
                case 1:
                    pila.push();
                    break;
                case 2:
                    int poppedValue = pila.pop();
                    if (poppedValue != -1) {
                        System.out.println("Elemento retirado: " + poppedValue);
                    }
                    break;
                case 3:
                    if (pila.isEmpty()) {
                        System.out.println("La pila esta vacia.");
                    } else {
                        System.out.println("La pila no esta vacia.");
                    }
                    break;
                case 4:
                    pila.display();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta nuevamente.");
                    break;
            }
        } while (option != 5);
        scanner.close();
    }}
