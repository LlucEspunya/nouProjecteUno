package uno.logica;

import uno.interficie.UI;

public class CartesEspecials extends Carta{

    private String simbol;

    public CartesEspecials(Color color, String simbol) {
        super(color);
        this.simbol = simbol;
    }

    public String getSimbol(){
        return simbol;
    }

    public void activar(OrdreJugadors ordreJugadors, Mazo mazo, Pilo pilo){}
}


//Carta especial +2

class mesDos extends CartesEspecials{
    public mesDos(Color color, String simbol){
        super(color, "+2");
    }

    @Override
    public void activar(OrdreJugadors ordreJugadors, Mazo mazo, Pilo pilo) {
        int voltes = 2;
        String jugadorTiraCarta = ordreJugadors.getJugadorActiu().getNomJugador();
        ordreJugadors.passarTorn();
        System.out.println("Jugador " + ordreJugadors.getJugadorActiu().getNomJugador() + " és el teu torn!");
        System.out.println("El jugador " + jugadorTiraCarta + " et fa robar dos cartes i perds el torn");
        System.out.println("Robant cartes...");
        while(voltes > 0){
            ordreJugadors.getJugadorActiu().robarCarta(mazo);
            voltes--;
        }

        if (mazo.getCartes().isEmpty()){
            mazo.reiniciarMazo(pilo);
        }

        UI.mostrarCartesJugador(ordreJugadors);
        ordreJugadors.passarTorn();
    }
}

class prohibit extends CartesEspecials{
    public prohibit(Color color, String simbol){
        super(color, "\uD83D\uDEC7");
    }

    @Override
    public void activar(OrdreJugadors ordreJugadors, Mazo mazo, Pilo pilo) {
        ordreJugadors.passarTorn();
        System.out.println("El jugador " + ordreJugadors.getJugadorActiu().getNomJugador() + " perd el seu torn");
        ordreJugadors.passarTorn();
    }
}

class canviSentit extends CartesEspecials{
    public canviSentit(Color color, String simbol){
        super(color, "↺");
    }

    @Override
    public void activar(OrdreJugadors ordreJugadors, Mazo mazo, Pilo pilo) {
        ordreJugadors.invertirSentit();
    }
}

class mesQuatre extends CartesEspecials{
    public mesQuatre(Color color, String simbol){
        super(color, "+4");
    }
    @Override
    public void activar(OrdreJugadors ordreJugadors, Mazo mazo, Pilo pilo) {
        int voltes = 4;
        String jugadorTiraCarta = ordreJugadors.getJugadorActiu().getNomJugador();
        ordreJugadors.passarTorn();
        System.out.println("Jugador " + ordreJugadors.getJugadorActiu().getNomJugador() + " és el teu torn!");
        System.out.println("El jugador " + jugadorTiraCarta + " et fa robar quatre cartes i perds el torn");
        System.out.println("Robant cartes...");
        while(voltes > 0){
            ordreJugadors.getJugadorActiu().robarCarta(mazo);
            voltes--;
        }

        if (mazo.getCartes().isEmpty()){
            mazo.reiniciarMazo(pilo);
        }

        UI.mostrarCartesJugador(ordreJugadors);
        ordreJugadors.passarTorn();
    }
}





