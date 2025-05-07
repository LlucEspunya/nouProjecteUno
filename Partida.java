package uno;
import uno.interficie.UI;
import uno.logica.Jugador;
import uno.logica.Mazo;
import uno.logica.OrdreJugadors;
import uno.logica.Pilo;

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

            while(!cartaValida){
                System.out.println("Última carta: ");
                UI.mostrarCarta(pilo.consultarCarta());

                tensCartaValida();
                while(!tensCartaValida()){
                    System.out.println("Robant cartes...");
                    jugadorActiu.robarCarta(mazo);
                    if (mazo.getCartes().isEmpty()){
                        mazo.reiniciarMazo(pilo);
                    }
                }
                System.out.println("Cartes a la mà:");
                UI.mostrarCartesJugador(ordreJugadors);
                int cartaTirar = UI.triarCartaTirar(jugadorActiu.getCartes());

                if(jugadorActiu.potTirarCarta(pilo, cartaTirar)){
                    jugadorActiu.tirarCarta(pilo, cartaTirar);
                    cartaValida = true;
                }
                else{
                    System.out.println("La carta no és vàlida!");
                }
            }

            ordreJugadors.passarTorn();

            if (jugadorActiu.getCartes().isEmpty()){
                System.out.println("Jugador " + jugadorActiu.getNomJugador() + " has guanyat la partida!");
                jugarPartida = false;
            }
        }
        return jugarPartida;
    }

    private boolean tensCartaValida(){
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
