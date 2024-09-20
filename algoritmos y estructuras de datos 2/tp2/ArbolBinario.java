
import java.io.*;

// Definicion de la clase NodoBinario
class NodoBinario {
    int dato;
    NodoBinario Hizq, Hder;

    // Constructor
    NodoBinario(int Elem) {
        // Dato a almacenar
        dato = Elem;
        // Definicion de hijos
        NodoBinario Hizq, Hder = null;
    }
}

// Definicion de la clase Arbol
class Arbol {
    NodoBinario Padre;
    public NodoBinario Raiz;

    // Constructor
    public Arbol() {
        Raiz = null;
    }

    // Se codificaron 2 metodos y en caso de que el nodo padre de referencia sea nulo se asume que es la raiz
    // Insercion de un hijo izquierdo
    public NodoBinario InsertaNodoHIzq(NodoBinario Nodo, int Elem) {
        NodoBinario result = null;
        Integer Elemento = Integer.valueOf(Elem);
        if (Nodo == null) {
            NodoBinario NodoAux = new NodoBinario(Elem);
            result = NodoAux;
            Raiz = NodoAux;
        } else {
            if (Nodo.Hizq == null) {
                NodoBinario NodoAux = new NodoBinario(Elem);
                Nodo.Hizq = NodoAux;
                result = NodoAux;
            } else
                System.out.print("ERR- Hijo izquierdo de " + Elemento.toString() + " no es nulo");
        }
        return result;
    }

    // Insercion de un hijo derecho
    public NodoBinario InsertaNodoHDer(NodoBinario Nodo, int Elem) {
        NodoBinario result = null;
        Integer Elemento = Integer.valueOf(Elem);
        if (Nodo == null) {
            NodoBinario NodoAux = new NodoBinario(Elem);
            result = NodoAux;
            Raiz = NodoAux;
        } else {
            if (Nodo.Hder == null) {
                NodoBinario NodoAux = new NodoBinario(Elem);
                Nodo.Hder = NodoAux;
                result = NodoAux;
            } else
                System.out.print("ERR- Hijo Derecho de " + Elemento.toString() + " no es nulo");
        }
        return result;
    }

    // Inorden Recursivo del arbol
    public void Inorden(NodoBinario Nodo) {
        if (Nodo != null) {
            Inorden(Nodo.Hizq);
            System.out.print(Nodo.dato + " ");
            Inorden(Nodo.Hder);
        }
    }

    // Altura del arbol
    public int Altura(NodoBinario Nodo) {
        if (Nodo == null) {
            return 0;
        } else {
            int alturaIzq = Altura(Nodo.Hizq);
            int alturaDer = Altura(Nodo.Hder);
            return Math.max(alturaIzq, alturaDer) + 1;
        }
    }
}

class ArbolBinario {
    public static void main(String[] ar) {
        Arbol A = new Arbol();
        System.out.print("Agregando la raiz 30 \n");
        NodoBinario NodoAux = null, NodoAux2 = null, NodoAux3 = null, NodoAux4 = null;
        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 30);
        NodoAux = NodoAux2;
        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 25);
        NodoAux3 = A.InsertaNodoHDer(NodoAux, 45);
        NodoAux = NodoAux2;
        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 20);
        NodoAux4 = A.InsertaNodoHDer(NodoAux, 27);
        System.out.print("\n El arbol binario en In orden es: \n");
        A.Inorden(A.Raiz);
        Integer Altura = Integer.valueOf(A.Altura(A.Raiz));
        System.out.print("\n La altura del arbol es: " + Altura.toString() + "\n");
    }
}