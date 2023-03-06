package TablaHash;

import java.util.ArrayList;
import java.util.LinkedList;

public class TablaHash {

    private ArrayList<LinkedList<String>> tabla;
    private int tamaño = 93000;

    public TablaHash() {
        this.tamaño = tamaño;
        tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            tabla.add(new LinkedList<>());
        }
    }

    public void agregar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            return;
        }
        lista.add(dato);
    }

    public String quitar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            lista.remove(dato);
            return dato;
        }
        return null;
    }

    public int buscar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            return posicion;
        }
        return -1;
    }

    private int funcion_hash(String dato, int tamaño_tabla) {
        int ascii = (int) dato.charAt(0);
        return ascii % tamaño_tabla;
    }

    private int sondeo(int posicion, int tamaño_tabla) {
        return (posicion + 1) % tamaño_tabla;
    }

    public int cantidad_elementos() {
        int contador = 0;
        for (LinkedList<String> lista : tabla) {
            contador += lista.size();
        }
        return contador;
    }

    public void imprimir(){
        agregarPalabra();
        buscar("Perro");
        quitar("Perro");
        sondeo(1, 93000);
        cantidad_elementos();
        System.out.println("TablaHash:\n" + tabla );
    }


    public void agregarPalabra() {
        agregar("Hola");
        agregar("Sandia");
        agregar("Cielo");
        agregar("Aguacate");
        agregar("Perro");
        agregar("Gato");
    }
}

