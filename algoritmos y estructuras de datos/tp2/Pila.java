public class Pila 
{
//Nombre: Soler Diego Francisco

    class Nodo 
    {
        int info;
        Nodo sig;
        }
        private Nodo raiz;
        public Pila () 
        {
        raiz=null;        
        }
        public void apilar(int x) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;

        if (raiz==null)
        {
        nuevo.sig = null;
        raiz = nuevo;
        }
        else
        {
        nuevo.sig = raiz;
        raiz = nuevo;
        }
        }
        
        public int desapilar()
        {
            //con este detectamos si la pila no esta vacia
            if ( raiz!=null )
            {
                //le asignamos el valor del tope de pila a una variable
                int elemnto = raiz.info;
                //hacemos que el tope de pila sea el siguiente nodo
                raiz= raiz.sig;
                //return del tope de pila
                return elemnto;
            }
            //return de -1 si la pila esta vacia
            return -1;
        }
        public void vercontenido()         
        {            
            // variable temporal para recorrer la pila
            Nodo temp = raiz;
            //utilizamos la clase stringbuilder para crear en un string con todos los elementos de la pila
            StringBuilder contenidoPila = new StringBuilder();
            
            //if para detectar si la pila esta vacia y asi crear un string al respecto
            if (raiz != null)
            {
                contenidoPila.append("La pila contiene los siguientes elementos: ");
                while (temp != null) 
                {
                    if(temp.sig!=null)
                    {
                    contenidoPila.append(temp.info).append(", ");
                    // Mover al siguiente nodo
                    temp = temp.sig; 
                    }
                    else
                    {
                        contenidoPila.append(temp.info);
                        temp = temp.sig;
                    }                
                }
            }
            else
            {
                contenidoPila.append("La pila se encuentra vacia");
            } 
            
            System.out.println(contenidoPila);
        }
        public static void main(String[] ar)
        {
        Pila pila1=new Pila();
        pila1.apilar(10);
        pila1.apilar(40);
        pila1.apilar(3);
        pila1. vercontenido ();
        System.out.println("Cima de la pila: "+pila1.desapilar());
        pila1. vercontenido ();
        }
}
