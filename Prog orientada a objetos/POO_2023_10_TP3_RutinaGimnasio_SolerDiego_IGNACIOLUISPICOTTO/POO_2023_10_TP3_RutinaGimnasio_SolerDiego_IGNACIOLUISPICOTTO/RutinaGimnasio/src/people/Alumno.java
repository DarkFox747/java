package people;

public class Alumno extends Persona{
    public int numDiasRutina;

    public Alumno(String nombre, int numDiasRutina) {
        super(nombre);
        this.numDiasRutina = numDiasRutina;
    }
    public int getNumDias(){
        return numDiasRutina;
    }
}
