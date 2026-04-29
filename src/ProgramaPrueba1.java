import java.util.*;

public class ProgramaPrueba1 {
    public static void main(String[] args) {
        //1) Añadir los números de 0 a 128 en orden.
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        System.out.println("Insertando números de 0 a 128 en orden...");
        for (int i = 0; i <= 128; i++) {
            arbol.add(i);
        }
        //2) Calcular la suma (getSuma())
        int suma = arbol.getSuma();
        System.out.println("Suma total: " + suma);
        //3) Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
        int sumaPre  = arbol.getListaPreOrden().stream().mapToInt(Integer::intValue).sum();
        int sumaPost = arbol.getListaPostOrden().stream().mapToInt(Integer::intValue).sum();
        int sumaIn   = arbol.getListaOrdenCentral().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma PreOrden: " + sumaPre);
        System.out.println("Suma PostOrden: " + sumaPost);
        System.out.println("Suma OrdenCentral: " + sumaIn);
        System.out.println("¿Coinciden? " + (sumaPre == sumaPost && sumaPost == sumaIn));
        /* 4)
        Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué?

        Los árboles se separan en tres conjuntos disjuntos, la ráiz, y los subárboles derecho e izquierdo. Como entre
        todos ellos cubren todo el árbol, la suma de los tres tiene que ser igual a la suma de todos los nodos del árbol
         */
        int sumaIzq = arbol.getSubArbolIzquierda().getSuma();
        int sumaDer = arbol.getSubArbolDerecha().getSuma();
        System.out.println("Suma subárbol izquierdo: " + sumaIzq);
        System.out.println("Suma subárbol derecho: " + sumaDer);
        System.out.println("Suma (izq + der + raíz): " + (sumaIzq + sumaDer + arbol.getValorRaiz()));
        // 5) ¿Cuál es la altura del árbol?
        System.out.println("Altura del árbol: " + arbol.getAltura());
        // 6) ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?
        List<Integer> camino = arbol.getCamino(110);
        System.out.println("Camino a 110: " + camino);
        System.out.println("Longitud del camino (número de aristas): " + (camino.size() - 1));
    }
}