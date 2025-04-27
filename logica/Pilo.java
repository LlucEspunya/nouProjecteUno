package uno.logica;

import java.util.Stack;

public class Pilo {
    private Stack<Carta> cartes;

    public Pilo() {
        this.cartes = new Stack<>();
    }

    public Carta agafarCarta(){
        return cartes.pop();
    }

    public void addCarta(Carta carta) {
        cartes.push(carta);
    }

    public Stack<Carta> getCartes() {
        return cartes;
    }

    public Carta consultarCarta(){
        return cartes.peek();
    }
}


