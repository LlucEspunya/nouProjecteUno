package uno.logica;

public abstract class Carta {
    public enum Color{
        vermell,
        groc,
        verd,
        blau
    }

    private Color colorCarta;

    public Color getColor(){
        return colorCarta;
    }

    public Carta (Color color){
        colorCarta = color;
    }

    public static boolean sonCompatibles(Carta carta1, Carta carta2){
        if (carta1 instanceof CartesNormals && carta2 instanceof CartesNormals){
            boolean colorsSonIguals = carta1.getColor() == carta2.getColor();
            boolean numerosSonIguals = ((CartesNormals) carta1).getNumero() == ((CartesNormals) carta2).getNumero();
            return colorsSonIguals || numerosSonIguals;
        }
        else if(carta1 instanceof CartesEspecials && carta2 instanceof CartesEspecials){
            boolean colorsSonIguals = carta1.getColor() == carta2.getColor();
            boolean simbolsSonIguals = ((CartesEspecials) carta1).getSimbol() == ((CartesEspecials) carta2).getSimbol();
            return colorsSonIguals || simbolsSonIguals;
        }
        else{
            return carta1.getColor() == carta2.getColor();
        }
    }
}

