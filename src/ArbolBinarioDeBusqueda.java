import java.util.*;
public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

    protected class Nodo {
        T dato;
        Nodo izquierdo, derecho;

        Nodo(T dato) {
            this.dato = dato;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    protected Nodo raiz;

    public ArbolBinarioDeBusqueda() {
        raiz = null;
    }

    //Añadir un nodo
    public void add(T dato) {
        raiz = addRecursivo(raiz, dato);
    }
    private Nodo addRecursivo(Nodo actual, T dato) {
        if (actual == null) {
            return new Nodo(dato);  // Cuando llegamos a un hueco dejamos el dato ahí
        }
        int comparacion = dato.compareTo(actual.dato);
        if (comparacion < 0) {
            actual.izquierdo = addRecursivo(actual.izquierdo, dato);
        } else if (comparacion > 0) {
            actual.derecho = addRecursivo(actual.derecho, dato);
        }
        // Si es igual a algún dato no podemos añadirlo así que no se añade nada
        return actual;
    }
    //Sacar altuera
    public int getAltura() {
        return alturaRecursiva(raiz);
    }
    private int alturaRecursiva(Nodo actual) {
        if (actual == null) return -1; // Por la definición que se da en el enunciado de altura, si no hay elementos es -1
        return 1 + Math.max(alturaRecursiva(actual.izquierdo), alturaRecursiva(actual.derecho));
    }

    public int getGrado() { //El grado máximo siempre es 2 por ser un árbol binario
        return 2;
    }
    public List<T> getListaDatosNivel(int nivel) {
        List<T> lista = new ArrayList<>();
        obtenerNivel(raiz, 0, nivel, lista);
        return lista;
    }

    private void obtenerNivel(Nodo actual, int nivelActual, int nivelObjetivo, List<T> lista) {
        if (actual == null) return;
        if (nivelActual == nivelObjetivo) {
            lista.add(actual.dato);
        } else {
            obtenerNivel(actual.izquierdo, nivelActual + 1, nivelObjetivo, lista);
            obtenerNivel(actual.derecho, nivelActual + 1, nivelObjetivo, lista);
        }
    }
    //Ver si es o no homogéneo
    public boolean isArbolHomogeneo() {
        return esHomogeneo(raiz);
    }
    private boolean esHomogeneo(Nodo actual) {
        if (actual == null) return true;
        if ((actual.izquierdo == null && actual.derecho != null) || (actual.izquierdo != null && actual.derecho == null)) {
            return false;
        }
        return esHomogeneo(actual.izquierdo) && esHomogeneo(actual.derecho);
    }
    //Ver si es o no completo
    public boolean isArbolCompleto() {
        int altura = getAltura();
        int totalNodos = contarNodos(raiz);
        return totalNodos == Math.pow(2, altura + 1) - 1; //Si cumple la fórmula de los árboles completos es completo
    }
    //Ver si es casi completo
    protected int contarNodos(Nodo actual) {
        if (actual == null) return 0;
        return 1 + contarNodos(actual.izquierdo) + contarNodos(actual.derecho);
    }
    public boolean isArbolCasiCompleto() {
        if (raiz == null) return true;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        boolean huecoVisto = false;

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            // Comprobamos el hijo de la izquierda
            if (actual.izquierdo != null) {
                if (huecoVisto) return false;
                cola.add(actual.izquierdo);
            } else {
                huecoVisto = true;
            }

            // Comprobamos el hijo de la derecha
            if (actual.derecho != null) {
                if (huecoVisto) return false;
                cola.add(actual.derecho);
            } else {
                huecoVisto = true;
            }
        }
        return true;
    }
    public List<T> getCamino(T valor) {
        List<T> camino = new ArrayList<>();
        buscarCamino(raiz, valor, camino);
        return camino;
    }

    private boolean buscarCamino(Nodo actual, T valor, List<T> camino) {
        if (actual == null) return false;
        camino.add(actual.dato);
        int cmp = valor.compareTo(actual.dato);
        if (cmp == 0) return true;
        if (cmp < 0) return buscarCamino(actual.izquierdo, valor, camino);
        else return buscarCamino(actual.derecho, valor, camino);
    }
    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<T> sub = new ArbolBinarioDeBusqueda<>();
        if (raiz != null) sub.raiz = raiz.izquierdo;
        return sub;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<T> sub = new ArbolBinarioDeBusqueda<>();
        if (raiz != null) sub.raiz = raiz.derecho;
        return sub;
    }
    public List<T> getListaPreOrden() {
        List<T> lista = new ArrayList<>();
        preOrden(raiz, lista);
        return lista;
    }

    private void preOrden(Nodo actual, List<T> lista) {
        if (actual != null) {
            lista.add(actual.dato);
            preOrden(actual.izquierdo, lista);
            preOrden(actual.derecho, lista);
        }
    }
    public List<T> getListaPostOrden() {
        List<T> lista = new ArrayList<>();
        postOrden(raiz, lista);
        return lista;
    }

    private void postOrden(Nodo actual, List<T> lista) {
        if (actual != null) {
            postOrden(actual.izquierdo, lista);
            postOrden(actual.derecho, lista);
            lista.add(actual.dato);
        }
    }
    public List<T> getListaOrdenCentral() {
        List<T> lista = new ArrayList<>();
        inOrden(raiz, lista);
        return lista;
    }

    private void inOrden(Nodo actual, List<T> lista) {
        if (actual != null) {
            inOrden(actual.izquierdo, lista);
            lista.add(actual.dato);
            inOrden(actual.derecho, lista);
        }
    }
    public T getValorRaiz() {
        if (raiz == null) return null;
        return raiz.dato;
    }
    
}
