//Nombre: Soler Diego Francisco
//Legajo: INF014301
//DNI: 41656522

public class Cola {
    private Nodo frente;
    private Nodo fin;

    //Clase Nodo interna para almacenar los datos del cliente
    private class Nodo {
        String cliente;
        int codigo;        
        int cantidad;
        Nodo siguiente;

        public Nodo(int codigo, String cliente, int cantidad) {
            this.codigo = codigo;
            this.cliente = cliente;
            this.cantidad = cantidad;
            this.siguiente = null;
        }
    }

    //Estructura de la cola
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    //Verificar si la cola esta vacia
    public boolean estaVacia() {
        return (frente == null);
    }

    //Agregar elementos a la cola
    public void encolar(int codigo, String cliente, int cantidad) {
        Nodo nuevoNodo = new Nodo(codigo, cliente, cantidad);
        if (estaVacia()) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        System.out.println("Pedido agregado: " + codigo + ", " + cliente + ", " + cantidad);
    }

    //Eliminar elementos de la cola
    public Nodo desencolar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia.");
            return null;
        } else {
            Nodo temp = frente;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            return temp;
        }
    }

    //Mostrar todos los elementos en la cola
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia.");
        } else {
            Nodo temp = frente;
            while (temp != null) {
                System.out.println("Codigo: " + temp.codigo + ", Cliente: " + temp.cliente + ", Cantidad: " + temp.cantidad);
                temp = temp.siguiente;
            }
        }
    }

    //Run para testear el script con 3 clientes
    public static void main(String[] args) {
        Cola colaPedidos = new Cola();

        //Generar pedidos de prueba
        colaPedidos.encolar(1123, "Papitas SA", 145);
        colaPedidos.encolar(232, "Patos SA", 5032);
        colaPedidos.encolar(345, "Chispas SA", 387);

        //Mostrar la cola de pedidos
        System.out.println("\nPedidos en cola:");
        colaPedidos.mostrarCola();

        //Procesar pedidos
        System.out.println("\nProcesando pedidos:");
        while (!colaPedidos.estaVacia()) {
            Nodo pedidoProcesado = colaPedidos.desencolar();
            if (pedidoProcesado != null) {
                System.out.println("Codigo: " + pedidoProcesado.codigo + ", Cliente: " + pedidoProcesado.cliente + ", Cantidad: " + pedidoProcesado.cantidad);
            }
        }

        //Mostrar la cola vacia
        System.out.println("\nPedidos en cola despues de procesar:");
        colaPedidos.mostrarCola();
    }
}
