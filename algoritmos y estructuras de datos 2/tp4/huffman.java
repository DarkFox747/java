import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class huffman {

    class ArbolHuffman {
        class NodoArbol {
            char clave;
            int frecuencia;
            boolean esdato;
            NodoArbol izquierda, derecha;

            public NodoArbol(char car, int frec, boolean EsD) {
                clave = car;
                frecuencia = frec;
                esdato = EsD;
                izquierda = derecha = null;
            }
        }

        class NodoLista {
            public NodoArbol raiz;
            public NodoLista siguiente;

            public NodoLista(NodoArbol Nodo) {
                raiz = Nodo;
                siguiente = null;
            }
        }

        NodoLista NodoInicial;
        int TablaHuffman[];
        String TablaHuffmanCodigos[];
        int tamanotabla = 0;

        int ByteToUnsignedByte(byte dato) {
            int resultado = (int) dato;
            if (dato < 0) {
                resultado = (int) dato + 256;
            }
            return resultado;
        }

        void CargarTablaDeArchivo(String NombreArchivo) {
            NodoInicial = null;
            TablaHuffman = new int[256];
            TablaHuffmanCodigos = new String[256];
            for (int i = 0; i <= 255; i++) {
                TablaHuffman[i] = 0;
                TablaHuffmanCodigos[i] = "";
            }
            System.out.println("Cargar archivo: " + NombreArchivo);
            try {
                RandomAccessFile file = new RandomAccessFile(NombreArchivo, "r");
                byte dato;
                int entero;
                long cont = 0;
                long tamano = file.length();
                System.out.print("tamano: ");
                System.out.println(tamano);
                while (cont < tamano) {
                    file.seek(cont);
                    dato = file.readByte();
                    entero = ByteToUnsignedByte(dato);
                    TablaHuffman[entero]++;
                    cont++;
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= 255; i++) {
                if (TablaHuffman[i] > 0) {
                    tamanotabla++;
                }
            }
            System.out.print("Tamano de la tabla: ");
            System.out.println(tamanotabla);
        }

        void InsertarNodoLista(NodoLista NodoAinsertar) {
            NodoLista AUXposnodo, AUXposnodoant, auxnodo;
            if (NodoInicial == null) {
                NodoInicial = NodoAinsertar;
            } else {
                AUXposnodo = NodoInicial;
                AUXposnodoant = null;
                while ((NodoAinsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) && (AUXposnodo.siguiente != null)) {
                    AUXposnodoant = AUXposnodo;
                    AUXposnodo = AUXposnodo.siguiente;
                }
                if (AUXposnodoant == null) {
                    if (NodoAinsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) {
                        AUXposnodo.siguiente = NodoAinsertar;
                    } else {
                        NodoAinsertar.siguiente = NodoInicial;
                        NodoInicial = NodoAinsertar;
                    }
                } else {
                    if (NodoAinsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) {
                        auxnodo = AUXposnodo.siguiente;
                        AUXposnodo.siguiente = NodoAinsertar;
                        NodoAinsertar.siguiente = auxnodo;
                    } else {
                        AUXposnodoant.siguiente = NodoAinsertar;
                        NodoAinsertar.siguiente = AUXposnodo;
                    }
                }
            }
        }

        void MostrarListaDeArboles() {
            NodoLista AUXnodo = NodoInicial;
            int count = 0;
            System.out.print("Lista de arboles: ");
            while (AUXnodo != null) {
                count++;
                System.out.print(count);
                System.out.print("'" + AUXnodo.raiz.clave + "'");
                System.out.print("(");
                System.out.print(AUXnodo.raiz.frecuencia);
                System.out.print("), ");
                AUXnodo = AUXnodo.siguiente;
            }
            System.out.println(" ");
        }

        void CrearListaDeArboles() {
            int pos = 0;
            System.out.println("Tabla:");
            for (int i = 0; i <= 255; i++) {
                if (TablaHuffman[i] > 0) {
                    pos++;
                    NodoArbol AUXNA = new NodoArbol((char) i, TablaHuffman[i], true);
                    NodoLista AUXNL = new NodoLista(AUXNA);
                    System.out.print("Nodo ");
                    System.out.print(pos);
                    System.out.print(" " + (char) i + "(");
                    System.out.print(TablaHuffman[i]);
                    System.out.print("); ");
                    InsertarNodoLista(AUXNL);
                }
            }
            System.out.println(" ");
            MostrarListaDeArboles();
        }

        void ProcesarListaDeArboles() {
            if (NodoInicial != null) {
                NodoLista AUXRECORIDONL = NodoInicial;
                if (AUXRECORIDONL != null) {
                    while (AUXRECORIDONL.siguiente != null) {
                        NodoLista AUXNL1 = AUXRECORIDONL;
                        NodoLista AUXNL2 = AUXRECORIDONL.siguiente;
                        NodoArbol AUXNAR1 = AUXNL1.raiz;
                        NodoArbol AUXNAR2 = AUXNL2.raiz;
                        NodoInicial = AUXNL2.siguiente;
                        NodoArbol AUXNA = new NodoArbol('*', AUXNL1.raiz.frecuencia + AUXNL2.raiz.frecuencia, false);
                        AUXNA.izquierda = AUXNL1.raiz;
                        AUXNA.derecha = AUXNL2.raiz;
                        NodoLista AUXNL = new NodoLista(AUXNA);
                        InsertarNodoLista(AUXNL);
                        AUXRECORIDONL = NodoInicial;
                    }
                }
            }
        }

        void GenerarCodigosDeHuffman_recursivo(NodoArbol AUXNODORAIZ, String codigo) {
            if (AUXNODORAIZ != null) {
                if (AUXNODORAIZ.esdato) {
                    TablaHuffmanCodigos[AUXNODORAIZ.clave] = codigo;
                } else {
                    GenerarCodigosDeHuffman_recursivo(AUXNODORAIZ.izquierda, codigo + "0");
                    GenerarCodigosDeHuffman_recursivo(AUXNODORAIZ.derecha, codigo + "1");
                }
            }
        }

        byte stringbytetobyte(String strtobyte) {
            byte Byteresult = 0;
            int Intresult = 0;
            if (strtobyte.length() > 0)
                if (Integer.parseInt(strtobyte.substring(0, 1)) > 0)
                    Intresult = Intresult + 128;
            if (strtobyte.length() > 1)
                if (Integer.parseInt(strtobyte.substring(1, 2)) > 0)
                    Intresult = Intresult + 64;
            if (strtobyte.length() > 2)
                if (Integer.parseInt(strtobyte.substring(2, 3)) > 0)
                    Intresult = Intresult + 32;
            if (strtobyte.length() > 3)
                if (Integer.parseInt(strtobyte.substring(3, 4)) > 0)
                    Intresult = Intresult + 16;
            if (strtobyte.length() > 4)
                if (Integer.parseInt(strtobyte.substring(4, 5)) > 0)
                    Intresult = Intresult + 8;
            if (strtobyte.length() > 5)
                if (Integer.parseInt(strtobyte.substring(5, 6)) > 0)
                    Intresult = Intresult + 4;
            if (strtobyte.length() > 6)
                if (Integer.parseInt(strtobyte.substring(6, 7)) > 0)
                    Intresult = Intresult + 2;
            if (strtobyte.length() > 7)
                if (Integer.parseInt(strtobyte.substring(7, 8)) > 0)
                    Intresult = Intresult + 1;
            Byteresult = (byte) Intresult;
            return Byteresult;
        }

        String procesarbuffer(String STRBUFF, RandomAccessFile archivo) throws IOException {
            String Auxstr = STRBUFF, STRINGBYTE = "";
            while (Auxstr.length() >= 8) {
                STRINGBYTE = Auxstr.substring(0, 8);
                Auxstr = Auxstr.substring(8, Auxstr.length());
                archivo.writeByte(stringbytetobyte(STRINGBYTE));
            }
            return Auxstr;
        }

        void GenerarArchivoComprimido(String NombreArchivoO, String NombreArchivoD) {
            String STRBuffer = "";
            String STRBuffertmp = "";
            File arch = new File(NombreArchivoD);
            if (arch.delete())
                System.out.println("archivo borrado");
            try {
                RandomAccessFile archivoorigen = new RandomAccessFile(NombreArchivoO, "r");
                RandomAccessFile archivodestino = new RandomAccessFile(NombreArchivoD, "rw");

                // Escribir la tabla de frecuencias
                for (int i = 0; i < 256; i++) {
                    archivodestino.writeInt(TablaHuffman[i]);
                }

                // Escribir el tamaño original del archivo
                long tamanoOriginal = archivoorigen.length();
                archivodestino.writeLong(tamanoOriginal);

                int entero;
                byte dato;
                long cont = 0;
                while (cont < tamanoOriginal) {
                    archivoorigen.seek(cont);
                    dato = archivoorigen.readByte();
                    entero = ByteToUnsignedByte(dato);
                    STRBuffer = STRBuffer + TablaHuffmanCodigos[entero];
                    STRBuffertmp = STRBuffertmp + " " + TablaHuffmanCodigos[entero];
                    STRBuffer = procesarbuffer(STRBuffer, archivodestino);
                    cont++;
                }

                // Escribir los bits restantes y el padding
                if (!STRBuffer.isEmpty()) {
                    while (STRBuffer.length() < 8) {
                        STRBuffer += "0";
                    }
                    archivodestino.writeByte(stringbytetobyte(STRBuffer));
                    archivodestino.writeByte((byte) (8 - STRBuffer.length()));
                } else {
                    archivodestino.writeByte((byte) 0);
                }

                System.out.println(STRBuffertmp);
                archivoorigen.close();
                archivodestino.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArbolHuffman AH;

    void Comprimir(String NombreArchivo) {
        ArbolHuffman AH = new ArbolHuffman();
        if (AH != null) {
            AH.CargarTablaDeArchivo(NombreArchivo);
            AH.CrearListaDeArboles();
            AH.ProcesarListaDeArboles();
            AH.GenerarCodigosDeHuffman_recursivo(AH.NodoInicial.raiz, "");
            AH.GenerarArchivoComprimido(NombreArchivo, NombreArchivo + ".compress");
        }
    }

    public static void main(String[] args) {
        huffman AHuffman = new huffman();
        AHuffman.Comprimir("d:\\prueba.txt");
    }
}