package clases;

public class Monstruo {
    protected String nombre;
    protected int ataque, defensa, velocidad, puntosVida;

    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
    }

    public boolean estaVivo(){
        return puntosVida >= 0;
    }

    public boolean perderVida(int puntos){
        puntosVida -= puntos;
        return puntosVida < 0;
    }

    public void atacar(Personaje p){
        //todo buscar la forma de imprimir o nombre de la clase (forma actual)
        System.out.println(getClass().getSimpleName() + "("+ puntosVida +") ataca a " +
                           p.nombre + "(" + p.puntosVida + "): ");
        int dadosPj = random100();
        int ataque = p.fuerza + dadosPj;
        System.out.print("* Ataque = (ataque + random100) = ");
        System.out.println("(" + ataque + " + " + dadosPj + ") = " + ataque);
        int dadosM = random100();
        int defensa = p.agilidad + dadosM;
        System.out.print("* Defensa = (defensa + random100) = ");
        System.out.println("(" + p.agilidad + " + " + dadosM + ") = " + defensa);

        System.out.print("* Resultado: ");
        int resultado = ataque - defensa;

        if (resultado > 0) {
            System.out.println(nombre + " suma " + resultado + " puntos de experiencia.");
            if (p.perderVida(resultado))
                System.out.println(nombre + " mata a " + p.nombre + "!!! (-" + resultado + " PV)");
            else
                System.out.println(nombre + " hiere a " + p.nombre + " (-" + resultado + " PV)");
        } else {
            System.out.println(p.nombre + " esquiva o para el ataque.");
        }
    }

    @Override
    public String toString() {
        if (nombre.equals("")) {
            return  getClass().getSimpleName() +" (" +
                    "PV=" + puntosVida +")";
        } else {
            return  "\n"+nombre + "-" + getClass().getSimpleName() +" (" +
                    "PV=" + puntosVida + ")";
        }
    }

    public void mostrar(){
        System.out.println("PERSONAJE");
        System.out.println("=========");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("puntosVida: " + puntosVida);
        System.out.println("");

    }

    public static int random100(){
        return (int)(Math.random() * 100 + 1);
    }

    public static int randomRango(int a, int b) {
        int aleatorio = (int) (Math.random() * ((b + 1) - a) + a);
        return aleatorio;
    }
}
