//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522

//clase producto que almacena los atributos del producto de cada elemento a atilizar en la lista enlazada
class Producto {
    int codigo;
    String descripcion;
    double precio;
    Producto anterior;
    Producto siguiente;

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String toString() {
        return "Codigo: " + codigo + ", Descripcion: " + descripcion + ", Precio: " + precio;
    }
}