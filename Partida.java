package uno;

import uno.interficie.UI;
import uno.logica.Jugador;
import uno.logica.Mazo;
import uno.logica.OrdreJugadors;
import uno.logica.Pilo;

import java.util.ArrayList;

public class Partida {
    Mazo mazo = new Mazo();
    Pilo pilo = new Pilo();
    OrdreJugadors ordreJugadors = new OrdreJugadors();
    int quantitatJugadors;
    int quantitatCartesMa;

    public void iniciar(){
        preparar();
        boolean partidaAcabada = false;
        while(!partidaAcabada){
            torn();
        }
    }

    private void preparar(){
        //barrejar
        mazo.barrejarCartes();
        //Crear jugadors
        ArrayList<String> nomsJugadors = UI.getNomsJugadors();
        ordreJugadors.crearJugador();

        quantitatJugadors = nomsJugadors.size();

        //Barrejar ordre
        ordreJugadors.barrejarOrdre();

        //Repartir cartes
        repartirCartes();

        mazo.tirarCartaPilo(pilo);
    }

    private boolean torn(){
        ordreJugadors.getJugadorActiu();
        
    }

    private void repartirCartes(){
        for (int i = 0; i < quantitatJugadors*quantitatCartesMa; i++){  //reparteix per tots els jugadors
            ordreJugadors.getJugadorActiu().robarCarta(mazo);           //una mateixa quantitat de cartes
            ordreJugadors.passarTorn();
        }
    }
}
