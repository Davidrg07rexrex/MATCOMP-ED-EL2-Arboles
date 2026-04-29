import java.util.*;

public class ProgramaPrueba2 {
    public static void main(String[] args) {

        // 1)
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        // Creamos una lista con todos los números y la desordenamos
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= 128; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);   // desordena aleatoriamente
        for (int num : numeros) {
            arbol.add(num);
        }

        // 2) Calcula la suma (getSuma())
        int suma = arbol.getSuma();
        System.out.println("Suma total: " + suma);

        // 3) Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
        int sumaPre  = arbol.getListaPreOrden().stream().mapToInt(Integer::intValue).sum();
        int sumaPost = arbol.getListaPostOrden().stream().mapToInt(Integer::intValue).sum();
        int sumaIn   = arbol.getListaOrdenCentral().stream().mapToInt(Integer::intValue).sum();

        System.out.println("Suma PreOrden: " + sumaPre);
        System.out.println("Suma PostOrden: " + sumaPost);
        System.out.println("Suma OrdenCentral: " + sumaIn);
        System.out.println("¿Coinciden? " + (sumaPre == sumaPost && sumaPost == sumaIn));

        // 4) Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué?
        // Por el mismo motivo que en ProgramaPrueba1, es una condición que se cumple en todos los árboles.
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
        System.out.println("Longitud del camino: " + (camino.size() - 1));
    }
}
/*
Explique las diferencias (si las ha habido) de los resultados obtenidos entre los dos programas de prueba.

Hay varias diferencias entre ambos probadores.
En primer lugar, el probador 1 siempre da la misma respuesta mientras que en el 2 va variando. En el 1 la suma del subarbol
izquiero es cero y el del derecho es igual a la suma total. Mientras que en el segundo probador la suma de izquierdo, y la
suma de derecho no tienen un patrón fijo. En él primero la áltura es 128, es decir que de cada vértice del
árbol sale una única arista hacia un hijo. Mientras que en el segundo la altura va variando. Estas diferencias se deben a
cómo se han construido los árboles. Para el primero se ha seguido un orden fijo dónde cada nodo tiene como mucho un hijo.
Mientras que en el segundo se han ido añadiendo aleatoriamente, de forma que el grado máximo de los nodos fuera 2 y que
cumplieran los criterios de ordenación mencionados en el enunciado. Por ello la altura del segundo probador no baja de 7
puesto que con altura 7 se pueden guardar hasta 255 nodos.


¿Qué sucede con los resultados si ejecuta los programas de prueba varias veces?
En el primero no ocurre nada puesto que al ser el orden fijo siempre saca los mismos resultados.
En el segundo varían los subárboles izquierdo y derecho, la altura del árbol, el camino para llegar a 110 y
la longitud del camino. Cómo se mencionó en la anterior pregunta, estos cambios son debidos a la construcción aleatoria
que es usa para crear el árbol de la segunda prueba.
 */