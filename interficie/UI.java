
package uno.interficie;
import uno.logica.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static Scanner object = new Scanner(System.in);
    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    private static String pintarCarta(CartesNormals cartaNormal) {
        String color = "";
        switch (cartaNormal.getColor()) {
            case CartesNormals.Color.groc:
                color = YELLOW;
                break;
            case CartesNormals.Color.vermell:
                color = RED;
                break;
            case CartesNormals.Color.blau:
                color = BLUE;
                break;
            case CartesNormals.Color.verd:
                color = GREEN;
                break;
            default:
                break;
        }

        String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %d       │%s
            %s│         │%s
            %s│   UNO   │%s
            %s│         │%s
            %s│       %d │%s
            %s└─────────┘%s""",
                color, RESET,
                color, cartaNormal.getNumero(), RESET,
                color, RESET,
                color, RESET,
                color, RESET,
                color, cartaNormal.getNumero(), RESET,
                color, RESET);


        return cartaPintada;
    }

    private static String pintarCartaEspecial(CartesEspecials cartesEspecials){
        String color = "";
        switch (cartesEspecials.getColor()) {
            case CartesNormals.Color.groc:
                color = YELLOW;
                break;
            case CartesNormals.Color.vermell:
                color = RED;
                break;
            case CartesNormals.Color.blau:
                color = BLUE;
                break;
            case CartesNormals.Color.verd:
                color = GREEN;
                break;
            default:
                break;
        }

        String cartaPintada = String.format("""
            %s┌─────────┐%s
            %s│ %s      │%s
            %s│         │%s
            %s│   UNO   │%s
            %s│         │%s
            %s│      %s │%s
            %s└─────────┘%s""",
                color, RESET,
                color, cartesEspecials.getSimbol(), RESET,
                color, RESET,
                color, RESET,
                color, RESET,
                color, cartesEspecials.getSimbol(), RESET,
                color, RESET);

        return cartaPintada;
    }

    private static String pintarCarta(Carta carta) {
        if (carta instanceof CartesNormals) {
            return pintarCarta((CartesNormals) carta);
        } else if (carta instanceof CartesEspecials) {
            return pintarCartaEspecial((CartesEspecials) carta);
        }
        return "No s'ha trobat cap carta";
    }

    public static void mostrarCarta(Carta carta) {
        if (carta instanceof CartesNormals) {
            System.out.println(pintarCarta((CartesNormals) carta));
        } else if (carta instanceof CartesEspecials) {
            System.out.println(pintarCartaEspecial((CartesEspecials) carta));
        } else {
            System.out.println("Tipo de carta no reconocido");
        }
    }
    public static void mostrarCartes(ArrayList<Carta> cartes) {
        int quantitat = cartes.size();
        String[][] cartesPintades = new String[quantitat][];

        for (int i = 0; i < quantitat; i++) {
            cartesPintades[i] = pintarCarta(cartes.get(i)).split("\n");
        }

        int altura = cartesPintades[0].length;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < quantitat; j++) {
                System.out.print(cartesPintades[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.print("    ");
        for (int j = 0; j < quantitat; j++) {
            if(j + 1 < 10){
                System.out.printf("(" + (j+1) + ")          ");
            }
            else{
                System.out.printf("(" + (j+1) + ")         ");
            }
        }
        System.out.println();
    }

    public static ArrayList<String> getNomsJugadors(){
        ArrayList<String> noms = new ArrayList<>();

        System.out.println("Quants jugadors hi haurà?: ");
        int quantitatJugadors = object.nextInt();
        object.nextLine();

        for (int i = 0; i < quantitatJugadors; i++){
            System.out.println("Nom del jugador:");
            String nomJugador = object.nextLine();
            if (nomJugador.length() > 7){
                while(nomJugador.length() > 7){
                    System.out.println("El màxim de caracteres per el nom és 7");
                    System.out.println("Torna a introduir el nom:");
                    nomJugador = object.nextLine();
                }
            }
            noms.add(nomJugador);
        }
        return noms;
    }

    public static void mostrarCartesJugador(OrdreJugadors ordreJugadors){
        Jugador jugadorActiu = ordreJugadors.getJugadorActiu();
        System.out.println();
        System.out.println(jugadorActiu.getNomJugador() + ": Cartes a la mà:");
        mostrarCartes(jugadorActiu.getCartes());
    }

    public static int triarCartaTirar(ArrayList<Carta> cartes) {
        System.out.println("Quina carta vols jugar?: ");
        int numCarta = object.nextInt();
        return numCarta - 1;
    }
}
