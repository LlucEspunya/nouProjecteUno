package uno.logica;

public class Regles {
    public static boolean sonCompatibles(Carta carta1, Carta carta2){
        boolean colorsSonIguals = carta1.getColor() == carta2.getColor();
        boolean numerosSonIguals = carta1.getNumero() == carta2.getNumero();

        return colorsSonIguals || numerosSonIguals;
    }
}
