//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522


//Clase principal de la lista enlazada 
class ListaDobleEnlazada {
    private Producto cabeza;

    //Metodo para insertar un elemento en la lista enlazada
    public void insertarProducto(int codigo, String descripcion, double precio) {
        Producto nuevoProducto = new Producto(codigo, descripcion, precio);

        if (cabeza == null) {
            cabeza = nuevoProducto;
        } else {
            Producto actual = cabeza;
            Producto anterior = null;

            while (actual != null && actual.codigo < codigo) {
                anterior = actual;
                actual = actual.siguiente;
            }

            if (actual != null && actual.codigo == codigo) {
                System.out.println("Error: El codigo " + codigo + " ya existe. No se puede insertar el producto.");
                return;
            }

            if (anterior == null) {
                nuevoProducto.siguiente = cabeza;
                if (cabeza != null) {
                    cabeza.anterior = nuevoProducto;
                }
                cabeza = nuevoProducto;
            } else {
                nuevoProducto.siguiente = actual;
                nuevoProducto.anterior = anterior;
                anterior.siguiente = nuevoProducto;
                if (actual != null) {
                    actual.anterior = nuevoProducto;
                }
            }
        }
    }

    //Metodo para listar los elementos de la lista
    public void listarProductos() {
        Producto actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

    //Metodo para buscar un producto por su codigo
    public Producto buscarProducto(int codigo) {
        Producto actual = cabeza;

        while (actual != null) {
            if (actual.codigo == codigo) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null; // Si no se encuentra el producto
    }

    //Metodo para eliminar un producto por su codigo
    public void eliminarProducto(int codigo) {
        Producto actual = cabeza;
        Producto anterior = null;

        while (actual != null && actual.codigo != codigo) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("No se encontro un producto con codigo " + codigo);
            return;
        }

        if (anterior == null) {
            cabeza = actual.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
        } else {
            anterior.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = anterior;
            }
        }

        System.out.println("Producto con codigo " + codigo + " eliminado correctamente.");
    }
}
