public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer> {

    public int getSuma() {
        return sumaRecursiva(raiz);
    }

    private int sumaRecursiva(Nodo actual) {
        if (actual == null) return 0;
        return actual.dato + sumaRecursiva(actual.izquierdo) + sumaRecursiva(actual.derecho);
    }
    @Override
    public ArbolBinarioDeBusquedaEnteros getSubArbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros sub = new ArbolBinarioDeBusquedaEnteros();
        if (raiz != null) {
            // Necesitamos acceder al nodo izquierdo, que es protected y de tipo Nodo de la clase base.
            // Como estamos dentro de una subclase, podemos leer raiz y sus atributos.
            sub.raiz = this.raiz.izquierdo;
        }
        return sub;
    }

    @Override
    public ArbolBinarioDeBusquedaEnteros getSubArbolDerecha() {
        ArbolBinarioDeBusquedaEnteros sub = new ArbolBinarioDeBusquedaEnteros();
        if (raiz != null) {
            sub.raiz = this.raiz.derecho;
        }
        return sub;
    }
}