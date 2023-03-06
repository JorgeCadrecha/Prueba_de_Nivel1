package TablaHash;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Diccionario diccionario = new Diccionario();

        diccionario.imprimir();
        System.out.println("--------------------------------------------------");
        TablaHash tabla = new TablaHash();
        tabla.imprimir();

    }


}