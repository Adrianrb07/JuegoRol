package rol;

public class Monstruo {
    //Atributos monstruo
    protected String nombre;
    protected int ataque, defensa, velocidad, puntosVida;

    //CONSTRUCTOR
    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
    }

    //MÉTODOS PÚBLICOS
    public boolean estaVivo() {
        return puntosVida >= 0;
    }

    public boolean perderVida(int puntos) {
        puntosVida -= puntos;
        return puntosVida < 0;
    }

    public void atacar(Personaje p) {
        //Condicional para mostrar resultados según el nombre del monstruo
        if (nombre.equals("")) {
            System.out.println(getClass().getSimpleName() + "(" + puntosVida + ") ataca a " +
                    p.nombre + "(" + p.puntosVida + "): ");
        } else {
            System.out.println(nombre + "(" + puntosVida + ") ataca a " +
                    p.nombre + "(" + p.puntosVida + "): ");
        }
        int dadosPj = random100();
        int ataqueM = ataque + dadosPj;
        System.out.print("* Ataque = (ataque + random100) = ");
        System.out.println("(" + ataque + " + " + dadosPj + ") = " + ataqueM);
        int dadosM = random100();
        int defensaM = defensa + dadosM;
        System.out.print("* Defensa = (defensa + random100) = ");
        System.out.println("(" + defensa + " + " + dadosM + ") = " + defensaM);

        System.out.print("* Resultado: ");
        int resultado = ataqueM - defensaM;

        if (resultado > 0) {
            p.sumarExperiencia(resultado);
            System.out.println(p.nombre + " suma " + resultado + " puntos de experiencia.");
            if (p.perderVida(resultado)) {
                if (nombre.equals("")) {
                    System.out.println(getClass().getSimpleName() + " mata a " + p.nombre + "!!! (-" + resultado + " PV)");
                } else {
                    System.out.println(nombre + " mata a " + p.nombre + "!!! (-" + resultado + " PV)");
                }
            } else {
                if (nombre.equals("")) {
                    System.out.println(getClass().getSimpleName() + " hiere a " + p.nombre + " (-" + resultado + " PV)");
                } else {
                    System.out.println(nombre + " hiere a " + p.nombre + " (-" + resultado + " PV)");
                }
            }
        } else {
            System.out.println(p.nombre + " esquiva o para el ataque.");
        }
    }

    public static int random100() {
        return (int) (Math.random() * 100 + 1);
    }

    public static int randomRango(int a, int b) {
        return (int) (Math.random() * ((b + 1) - a) + a);
    }

    public void mostrar() {
        System.out.println("MONSTRUO");
        System.out.println("=========");
        if (nombre.equals("")) {
            System.out.println("Nombre: " + getClass().getSimpleName());
        } else {
            System.out.println("Nombre: " + nombre);
        }
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("puntosVida: " + puntosVida);
        System.out.println();
    }

    //MÉTODOS SOBREESCRITOS
    @Override
    public String toString() {
        if (nombre.equals("")) {
            return getClass().getSimpleName() + " (" +
                    "PV=" + puntosVida + ")";
        } else {
            return "\n" + nombre + "-" + getClass().getSimpleName() + " (" +
                    "PV=" + puntosVida + ")";
        }
    }
}
