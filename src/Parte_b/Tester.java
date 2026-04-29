import Listas.*;

public class Tester {
    public static void main(String args[]) {
        //Prueba 1
        System.out.println("prueba 1: cargar y mostrar");
        GestorGrafo gEinstein = new GestorGrafo();
        gEinstein.cargarDesdeJSON("datos.json");//leemos el archivo
        gEinstein.mostrarGrafo();
        System.out.println();

        //Prueba 2
        System.out.println("prueba 2:fisico misma ciudad");
        String resultado = gEinstein.consultarFisicoMismaCiudad("persona:Albert Einstein");
        if (resultado != null) {
            System.out.println("Respuesta: El fisico es: " + resultado);
        } else {
            System.out.println("No se ha encontrado a nadie.");
        }
        System.out.println();

        //Prueba 3
        System.out.println("prueba 3: camino minimo");
        ListaSimplementeEnlazada<String> camino = gEinstein.obtenerCaminoMinimo("persona:Albert Einstein", "lugar:Ulm");
        if (camino != null) {
            System.out.print("Camino: ");
            camino.imprimir();
        } else {
            System.out.println("No hay conexion entre esos nodos.");
        }
        System.out.println("\n");

        //Prueba 4
        System.out.println("prueba 4: grafo conexo");
        GestorGrafo gConexo = new GestorGrafo();
        gConexo.cargarDesdeJSON("grafo_conexo.json");
        System.out.println("Es disjunto?: " + gConexo.esDisjunto());//sale false porque estan unidos
        System.out.println();

        //Prueba 5
        System.out.println("prueba 5: grafo disjunto");
        GestorGrafo gDisjunto = new GestorGrafo();
        gDisjunto.cargarDesdeJSON("grafo_disjunto.json");
        System.out.println("Es disjunto?: " + gDisjunto.esDisjunto());//sale true porque hay islas
    }
}