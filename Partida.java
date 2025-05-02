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
//            torn();
        }
    }

    private void preparar(){

        mazo.barrejarCartes();        //barrejar

        ordreJugadors.crearJugador();                           //crear jugadors
        quantitatJugadors = ordreJugadors.getNombreJugadors();

        ordreJugadors.barrejarOrdre();        //Barrejar ordre

        repartirCartes();           //Repartir cartes

        mazo.tirarCartaPilo(pilo);
    }


    private void repartirCartes(){
        for (int i = 0; i < quantitatJugadors*quantitatCartesMa; i++){  //reparteix per tots els jugadors
            ordreJugadors.getJugadorActiu().robarCarta(mazo);           //una mateixa quantitat de cartes
            ordreJugadors.passarTorn();
        }
    }
}
