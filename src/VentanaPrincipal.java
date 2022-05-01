import seres.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VentanaPrincipal {
    Personaje pj;
    Monstruo[] monstruos = new Monstruo[0];
    private JButton btnGenerarPersonaje;
    private JPanel panel1;
    private JButton generarMostruosButton;
    private JButton jugarButton;
    private JLabel lblInfoPersonaje;
    private JLabel lblInfoMonstruo;

    public VentanaPrincipal() {
        JFrame ventana = new JFrame("Juego de rol (version 0.4)");
        ventana.setBounds(300, 100, 600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel1);
        ventana.setResizable(false);
        ventana.setVisible(true);
        jugarButton.setEnabled(false);

        //Funcionalidad botón Generar Personaje
        btnGenerarPersonaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pj = generarPersonajeAleatorio();
                lblInfoPersonaje.setText(pj.mostrarHTML());
            }
        });

        //Funcionalidad botón Generar Monstruo
        generarMostruosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monstruos = new Monstruo[0];
                int numero = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Cuántos monstruos quieres crear?",
                        "Número de monstruos",
                        JOptionPane.INFORMATION_MESSAGE));

                monstruos = Arrays.copyOf(monstruos, monstruos.length + numero);

                for (int i = 0; i < numero; i++) {
                    monstruos[i] = generarMonstruoAleatorio();
                }

                for (int i = 0; i < monstruos.length; i++) {
                    lblInfoMonstruo.setText(monstruos[i].toString());

                }

                jugarButton.setEnabled(true);
            }
        });

        //Funcionalidad botón Jugar
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Que empiece el combate...");
            }
        });
    }

    public static Monstruo generarMonstruoAleatorio() {
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 10) {
            return new Dragon();
        } else if (probabilidad <= 20) {
            return new Troll();
        } else if (probabilidad <= 30) {
            return new Aranha();
        } else {
            return new Orco();
        }
    }

    public static Personaje generarPersonajeAleatorio() {
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 10) {
            return new Personaje("Légolas", Personaje.Raza.ELFO);
        } else if (probabilidad <= 20) {
            return new Personaje("Aragorn", Personaje.Raza.HUMANO);
        } else if (probabilidad <= 30) {
            return new Personaje("Frodo", Personaje.Raza.HOBBIT);
        } else {
            return new Personaje("Gimly", Personaje.Raza.ENANO);
        }
    }

    public static void main(String[] args) {
        //Definir variables y constantes
        VentanaPrincipal ventana = new VentanaPrincipal();


    }


}
