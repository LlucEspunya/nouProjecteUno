package uno.logica;

public class Carta {
    public enum Color{
        vermell,
        groc,
        verd,
        blau
    }

    private int numeroCarta;
    private Color colorCarta;

    public Color getColor(){
        return colorCarta;
    }
    public int getNumero(){
        return numeroCarta;
    }

    public Carta (int numero, Color color){
        numeroCarta = numero;
        colorCarta = color;
    }
}

