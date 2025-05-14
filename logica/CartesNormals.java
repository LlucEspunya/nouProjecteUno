package uno.logica;

public class CartesNormals extends Carta{
    private int numeroCarta;


    public CartesNormals(int numeroCarta, Color color) {
        super(color);
        this.numeroCarta = numeroCarta;
    }

    public int getNumero(){
        return numeroCarta;
    }
}
