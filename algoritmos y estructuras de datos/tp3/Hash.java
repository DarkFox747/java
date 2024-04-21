public class Hash {
    //Nombre: Soler Diego Francisco
    int dato;
    int estado; // 0 = Vacío, 1 = Eliminado, 2 = Ocupado

    static int FuncionHash(int n, int m) {
        // n es el valor original
        // m es el tamaño de la tabla
        // y debe devolver una posición int dentro del tamaño m
        return n%m;
    }

    static void insertaHash(Hash[] h, int m, int n) {
        boolean i = false;
        int j = FuncionHash(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);

        if (i) {
            System.out.print("Elemento insertado con Éxito! "+"Se inserto el numero: "+h[j].dato+" en la posicion:"+j+"\n");
        } else {
            System.out.print("Tabla llena!!! \n");
        }
    }

    static int buscaHash(Hash[] h, int m, int n) {
        // h es la tabla hash
        // m es el tamaño de la tabla
        // n es el valor buscado
        // y debe devolver el valor mismo que busca n si lo encuentra y -1 si no encuentra nada
        int j = FuncionHash(n,m);
        if (h[j].estado == 2 && h[j].dato == n) {
            return j;
        }
        while (j < (m+1) && (h[j].estado == 2 || (h[j].estado == 1 && h[j].dato != n))) {
        if (h[j].estado == 2 && h[j].dato == n) {
            return j; // Si encuentra el elemento en esta posición, lo encontró
        }
        j++; // Incrementar el número de intentos
        }
     return -1;   
              
    }

    static int eliminaHash(Hash[] h, int m, int n) {
        int i = buscaHash(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            System.out.print("Elemento " +h[i].dato+" Borrado! \n");
            return 1;
        }
    }

    public static void main(String[] args) {
        int i, elemento;
        // Tabla Definida de 15
        int m = 15;
        Hash[] h = new Hash[m];
        for (i = 0; i < m; i++) {
            h[i] = new Hash();
            h[i].estado = 0;
        }
    
        // Insertar elemento
        Hash.insertaHash(h, m, 15);
        Hash.insertaHash(h, m, 130);
        Hash.insertaHash(h, m, 7);
        Hash.insertaHash(h, m, 32);       
        // Buscando un elemento
        elemento = 7;
        i = Hash.buscaHash(h, m, elemento);
        System.out.println(i + "\n");
        i = Hash.eliminaHash(h, m, 130);
        i = Hash.buscaHash(h, m, 33);
        System.out.println(i + "\n");
    }


}


