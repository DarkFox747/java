public class main {
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        lista.insertarProducto(101, "Producto A", 10.99);
        lista.insertarProducto(105, "Producto B", 20.99);
        lista.insertarProducto(103, "Producto C", 30.99);
        lista.insertarProducto(102, "Producto D", 40.99);
        lista.insertarProducto(104, "Producto E", 50.99);
        lista.insertarProducto(101, "Producto F", 60.99);  // Debería generar un error

        lista.listarProductos();
    }
}