package uno;
import uno.interficie.UI;
import uno.logica.*;

public class Partida {
    Mazo mazo = new Mazo();
    Pilo pilo = new Pilo();
    OrdreJugadors ordreJugadors = new OrdreJugadors();
    int quantitatJugadors;
    int quantitatCartesMa = 7;

    public void iniciar(){
        preparar();
        torn();
    }

    private void preparar(){

        mazo.barrejarCartes();                                  //barrejar

        ordreJugadors.crearJugador();                           //crear jugadors
        quantitatJugadors = ordreJugadors.getNombreJugadors();

        ordreJugadors.barrejarOrdre();                          //Barrejar ordre

        repartirCartes();                                       //Repartir cartes

        mazo.tirarCartaPilo(pilo);
    }

    private boolean torn(){
        boolean jugarPartida = true;
        while(jugarPartida){
            Jugador jugadorActiu = ordreJugadors.getJugadorActiu();
            System.out.println("Jugador " + jugadorActiu.getNomJugador() + " és el teu torn!");

            boolean cartaValida = false;
            boolean esCartaEspecial = false;

            while(!cartaValida){
                System.out.println("Última carta: ");
                UI.mostrarCarta(pilo.consultarCarta());                 //mostra la carta del pilo

                tensCartaValida();                                      //abans de mostrar les cartes de la ma crido la funció "tensCartaValida"
                while(!tensCartaValida()){                              //per comprovar si pot jugar amb les cartes de la ma, en cas de que no entre en el bucle
                    System.out.println("Robant cartes...");
                    jugadorActiu.robarCarta(mazo);
                    if (mazo.getCartes().isEmpty()){                    //si el mazo està bui crida la funció "reiniciarMazo"
                        mazo.reiniciarMazo(pilo);
                    }
                }

                UI.mostrarCartesJugador(ordreJugadors);
                int cartaTirar = UI.triarCartaTirar(jugadorActiu.getCartes());      //crida la funció de la UI que demana la carta al jugador

                if(jugadorActiu.potTirarCarta(pilo, cartaTirar)){                   //crida la funció "potTirarCarta" per validar la carta que es vol jugar

                    Carta cartaAJugar = jugadorActiu.getCartes().get(cartaTirar);

                    esCartaEspecial = cartaAJugar instanceof CartesEspecials;

                    jugadorActiu.tirarCarta(pilo, cartaTirar);
                    cartaValida = true;

                    if (esCartaEspecial){
                        ((CartesEspecials) cartaAJugar).activar(ordreJugadors, mazo, pilo);
                    }
                }
                else{
                    System.out.println(jugadorActiu.getNomJugador() + ": La carta no és vàlida!");
                }
            }

            if (!esCartaEspecial){
                ordreJugadors.passarTorn();
            }

            if (jugadorActiu.getCartes().isEmpty()){
                System.out.println("Jugador " + jugadorActiu.getNomJugador() + " has guanyat la partida!");
                jugarPartida = false;
            }
        }
        return jugarPartida;
    }

    private boolean tensCartaValida(){                  //comprova totes les cartes de la teva ma
        boolean cartesValides = false;
        for (int i = 0; i < ordreJugadors.getJugadorActiu().nombreDeCartes() && !cartesValides; i++){
            if (ordreJugadors.getJugadorActiu().potTirarCarta(pilo, i)){
                cartesValides = true;
            }
        }
        return cartesValides;
    }


    private void repartirCartes(){
        for (int i = 0; i < quantitatJugadors*quantitatCartesMa; i++){  //reparteix per tots els jugadors
            ordreJugadors.getJugadorActiu().robarCarta(mazo);           //una mateixa quantitat de cartes
            ordreJugadors.passarTorn();
        }
    }
}
