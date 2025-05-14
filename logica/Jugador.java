package uno.logica;

import uno.interficie.UI;

import java.util.ArrayList;

public class Jugador {

    private String nomJugador;
    private ArrayList<Carta> cartes;

    public Jugador(String nom) {
        nomJugador = nom;
        cartes = new ArrayList<>();
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public ArrayList<Carta> getCartes() {
        return cartes;
    }

    public void tirarCarta(Pilo pilo, int cartaTirar){
        if (!cartes.isEmpty()){
            Carta carta = cartes.remove(cartaTirar);
            pilo.addCarta(carta);
        }
    }

    public void robarCarta(Mazo mazo){
        if(!mazo.getCartes().isEmpty()){
            Carta carta = mazo.getCartes().pop();
            cartes.add(carta);
        }
    }

    public int nombreDeCartes(){
        return cartes.size();
    }

    public boolean potTirarCarta(Pilo pilo, int cartaTirar){
        boolean potTirar = false;
        Carta ultimaCarta = pilo.consultarCarta();
        Carta cartaComprovar = cartes.get(cartaTirar);
        if(Carta.sonCompatibles(cartaComprovar, ultimaCarta)){
            potTirar = true;
        }
        return potTirar;
    }
}

