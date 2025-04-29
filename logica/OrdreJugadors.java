package uno.logica;

import uno.interficie.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class OrdreJugadors {

    private LinkedList<Jugador> jugadors;
    ArrayList<String> noms = UI.getNomsJugadors();
    private int jugadorActiu;

    public OrdreJugadors(){
        jugadors = new LinkedList<>();
        this.jugadorActiu = 0;
    }

    public void crearJugador(){
        for (int i = 0; i < noms.toArray().length; i++){
            String nom = noms.get(i);
            Jugador jugadorCreat = new Jugador(nom);
            jugadors.add(jugadorCreat);
        }
    }

    public void barrejarOrdre(){
        Collections.shuffle(jugadors);
    }

    public Jugador getJugadorActiu(){
        return jugadors.get(jugadorActiu);
    }

    public void passarTorn(){
        if(jugadorActiu < jugadors.size() - 1){
            jugadorActiu++;
        }
        else{
            jugadorActiu = 0;
        }
    }
}

