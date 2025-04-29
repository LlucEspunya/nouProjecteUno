package uno.logica;

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

    public void tirarCarta(Pilo pilo){
        if (!cartes.isEmpty()){
            Carta carta = cartes.remove(0);
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
}

