package clases;

import java.util.Comparator;

public class ComparaPuntoVida implements Comparator<Personaje> {
    @Override
    public int compare(Personaje o1, Personaje o2) {
        return o1.puntosVida - o2.puntosVida;
    }
}
