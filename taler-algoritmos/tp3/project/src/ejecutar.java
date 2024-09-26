//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522

import java.util.Scanner;

//Clase para testear la lista enlazada
public class ejecutar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            ListaDobleEnlazada lista = new ListaDobleEnlazada();

            //Insertar productos de prueba
            lista.insertarProducto(1023, "Papitas", 10);
            lista.insertarProducto(2345, "Mani", 20);
            lista.insertarProducto(3245, "Conitos", 30);
            lista.insertarProducto(9592, "Yerba", 40);
            lista.insertarProducto(9323, "Naftalina", 50);

            //Ultimo producto para generar un error por insertar 2 productos con el mismo codigo
            lista.insertarProducto(1023, "Ajo", 60);  

            //Listar todos los productos
            System.out.println("Lista de productos:");
            lista.listarProductos();

            //Buscar un producto por codigo
            int codigoBuscar = 1023;
            Producto encontrado = lista.buscarProducto(codigoBuscar);
            if (encontrado != null) {
                System.out.println("\nProducto encontrado por codigo " + codigoBuscar + ":");
                System.out.println(encontrado);
            } else {
                System.out.println("\nNo se encontro ningun producto con codigo " + codigoBuscar);
            }

            //Eliminar un producto por codigo
            int codigoEliminar = 2345;
            lista.eliminarProducto(codigoEliminar);

            //Listar productos despues de eliminar uno
            System.out.println("\nLista de productos despues de eliminar el producto con codigo " + codigoEliminar + ":");
            lista.listarProductos();

            //Preguntar si quiere crear otra lista
            System.out.print("¿Quieres crear otra lista ? (y/n): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("y"));

        scanner.close();
    }
}
