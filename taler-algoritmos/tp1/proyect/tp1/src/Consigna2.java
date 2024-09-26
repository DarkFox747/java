//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522

import java.util.Scanner;

public class Consigna2 
{
    public static void main(String[] args) { 
    int[] conteos = new int[26]; 
    Scanner teclado = new Scanner(System.in);  
    
    //Leer palabra del usuario
    System.out.print("Ingrese una palabra (por favor, solo letras): "); 

    String palabra = teclado.nextLine();
    //se agrega un cierre del scaner    
    teclado.close();
    //Convierte a mayusc. 
    palabra = palabra.toUpperCase();     

    //Cuenta la frecuencia de cada letra...
    for (int i = 0; i < palabra.length(); i++) {
        // agregando un try-catch nos permite omitir los caracteres no deseados. 
        try {
            conteos[palabra.charAt(i) - 'A']++; 
        } catch (ArrayIndexOutOfBoundsException e) {
             //este catch no hace nada
             System.out.println("No es una letra: " + palabra.charAt(i));
        }
    }
    
    //imprimir frecuencias...
    System.out.println();     
    for (int i=0; i < conteos.length; i++) 
        if (conteos [i] != 0) 
        System.out.println((char)(i +'A') + ": " + conteos[i]); 
    }      
}   
