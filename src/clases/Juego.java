package clases;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        //Definir variables y constantes
        Personaje[] personajes = new Personaje[6];
        Monstruo[] monstruos = new Monstruo[0];
        Scanner sc = new Scanner(System.in);
        int opcion;

        //Instancia y guardado de personajes en el Array
        personajes[0] = new Personaje("Légolas", Personaje.Raza.ELFO, 60, 90, 70, 90, 90, 50, 3, 100, 100);
        personajes[1] = new Personaje("Gimly", Personaje.Raza.ENANO, 80, 90, 70, 90, 90, 50, 2, 90, 90);
        personajes[2] = new Personaje("", Personaje.Raza.HUMANO, 60, 90, 70, 90, 90, 50, 3, 70, 70);
        personajes[3] = new Personaje("Frodo", Personaje.Raza.HOBBIT, 60, 90, 70, 90, 90, 50, 4, 50, 60);
        personajes[4] = new Personaje("", Personaje.Raza.TROLL, 60, 90, 70, 90, 90, 50, 5, 60, 50);
        personajes[5] = new Personaje("Orco", Personaje.Raza.ORCO, 60, 90, 70, 90, 90, 50, 1, 80, 80);

        //Menú
        System.out.println("PERSONAJES");
        System.out.println("========");
        System.out.println("1. - Mostrar Personajes ordenados por niveL");
        System.out.println("2. - Mostrar Personajes ordenados por PV");
        System.out.println("3. - Mostrar Personajes ordenados por PV descendentemente");
        System.out.println("4. - Generar Monstruo");
        System.out.println("5. - Combate singular");
        opcion = sc.nextInt();

        // Salida de datos
        switch (opcion) {
            case 1:
                Arrays.sort(personajes);
                System.out.println(Arrays.toString(personajes));
                break;

            case 2:
                Arrays.sort(personajes, new ComparaPuntoVida());
                System.out.println(Arrays.toString(personajes));
                break;

            case 3:
                Arrays.sort(personajes, new ComparaPuntoVida().reversed());
                System.out.println(Arrays.toString(personajes));
                break;

            case 4:
                monstruos = Arrays.copyOf(monstruos, monstruos.length + 1);
                monstruos[0] = generarMonstruoAleatorio();
                System.out.println(monstruos[0]);


            case 5:
                monstruos = Arrays.copyOf(monstruos, monstruos.length + 1);
                monstruos[0] = generarMonstruoAleatorio();
                combateSingular(personajes[0], monstruos[0]);
                break;
        }


    }

    public static Monstruo generarMonstruoAleatorio() {
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 10) {
            return new Dragon("");
        } else if (probabilidad <= 20) {
            return new Troll("");
        } else if (probabilidad <= 30) {
            return new Aranha("");
        } else {
            return new Orco("");
        }
    }

    public static void combateSingular(Personaje p, Monstruo m) {

        int i = 0;
        while (p.estaVivo() && m.estaVivo()) {
            i++;
            System.out.println("Ataque " + i + ":");
            if (p.agilidad >= m.velocidad) {
                p.atacar(m);
                if (m.estaVivo()) {
                    m.atacar(p);
                } else {
                    break;
                }
            } else {
                m.atacar(p);
                if (p.estaVivo()) {
                    p.atacar(m);
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}