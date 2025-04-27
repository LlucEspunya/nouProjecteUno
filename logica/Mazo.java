package uno.logica;

import java.util.Stack;
import java.util.Collections;

public class Mazo {
    private Stack<Carta> cartes = new Stack<>();

    public Mazo() {
        for (Carta.Color color : Carta.Color.values()) {
            cartes.push(new Carta(0, color));
            for (int i = 1; i <= 9; i++) {
                cartes.push(new Carta(i, color));
                cartes.push(new Carta(i, color));
            }
        }
    }

    public void addCarta(Carta carta) {
        cartes.push(carta);
    }

    public Stack<Carta> getCartes() {
        return cartes;
    }

    public void tirarCartaPilo(Pilo pilo) {
        Carta carta = cartes.remove(0);
        pilo.addCarta(carta);
    }

    public void barrejarCartes() {
        Collections.shuffle(cartes);
    }

    public void reiniciarMazo(Pilo pilo){
        Carta ultimaCarta;
        ultimaCarta = pilo.agafarCarta();

        while(!pilo.getCartes().isEmpty()){
            cartes.push(pilo.agafarCarta());
        }

        pilo.addCarta(ultimaCarta);
    }
}
