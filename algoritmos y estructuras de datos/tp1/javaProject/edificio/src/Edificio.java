
//archivo edificio
public class Edificio 
{
    private int numOficinas;
    private int numPisos;
    
    public Edificio(int numPisos, int numOficinas) 
    {
        this.numOficinas = numOficinas;
        this.numPisos = numPisos;
    }

    // funcion obtener sensor
    public boolean obtenersensor(int piso, int oficina)
    {
        // creamos unas matriz de 10x9 para probar el algoritmo
        int[][] matriz = {
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1}
        };

        return matriz[piso][oficina] == 1;
        }

    //funcion para contar la cantidad de oficinas activas
    public int cantidadOficinasActivas()
    {
        //loop anidado que cuenta la cantidad de oficinas activas
        int activas = 0;
        for (int i = 0; i< (numPisos); i++)
        {
            for (int j = 0; j< (numOficinas); j++)
            {
                if (obtenersensor(i, j) == true) {
                    activas++;                    
                }                
            }
        }
        return activas;
    }
    //funcion para obtener la primera oficina activa
    public Oficina encontrarPrimerOficinaActiva() {
        //loop anidado para encontrar la primera oficina
        for (int i = 1; i <= numPisos; i++) {
            for (int j = 1; j <= numOficinas; j++) {
                if (obtenersensor(i, j)) {
                    return new Oficina(i, j); 
                }
            }
        }
        //si no hay oficinas activas devolver null
        return null; 
    }
    public static void main(String[] args) throws Exception 
    {
        Edificio edificio = new Edificio(10, 9);
        System.out.println("La cantidad de oficinas activas es de: "+edificio.cantidadOficinasActivas());
        Oficina primeraOficina = edificio.encontrarPrimerOficinaActiva();
        if (primeraOficina != null) {
            System.out.println("La primera oficina activa encontrada está en el piso " + primeraOficina.piso + ", número de oficina " + primeraOficina.numero);
        } else {
            System.out.println("No se encontraron oficinas activas.");
        }
    }
}
