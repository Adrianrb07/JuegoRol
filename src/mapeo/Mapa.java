package mapeo;

import javax.swing.*;

public class Mapa extends JFrame {
    public JTextField caja;

    public int[][] mapa = {
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public void mostrarVentana() {
        this.setVisible(true); // hacer visible la ventana
        this.setTitle("Mapa"); // titulo a la ventana
        this.setSize(1200, 700); // tamaño a la ventana (ancho, alto)
        this.setLocationRelativeTo(null); // centramos la ventana en la pantalla
        this.setLayout(null); // no usamos ningún layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(true); // hacemos que la ventana no sea redimensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // hacemos que cuando se cierre la ventana termine el proceso

    }

    public void inicializarComponentes() {

    }

    //Mostrar mapa en consola
    public void mostrarMapaConsola() {
        for (int i = 1; i < mapa.length; i++) {
            for (int j = 1; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        //Definir variables y constantes
        Mapa mapa = new Mapa();
        mapa.mostrarMapaConsola();
        mapa.mostrarVentana();
    }
}
