package TablaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Diccionario {

    private HashMap<Character, LinkedList<String>> tablaHash;

    public Diccionario() {
        tablaHash = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            tablaHash.put(c, new LinkedList<String>());
        }
    }

    public void agregarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        palabrasConLetra.add(palabra);
    }

    public boolean buscarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        return palabrasConLetra.contains(palabra);
    }


    public BufferedReader leerDiccionario(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jorge\\Tec. Programacion\\Palabras-TablasHash\\src\\main\\resources\\palabras.csv"));
         return br;
    }


    public void imprimir() {
        try {
            leerDiccionario("C:\\Users\\Jorge\\Tec. Programacion\\Palabras-TablasHash\\src\\main\\resources\\palabras.csv");
            agregarPalabra("hola");
            agregarPalabra("adios");
            agregarPalabra("perro");
            buscarPalabra("hola");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Diccionario:\n"+ tablaHash );
    }

}
