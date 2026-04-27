import java.util.Random;

public class Carrera {
    private static final int LONGITUD_PISTA = 40;

    private final Caballo caballo1;
    private final Caballo caballo2;
    private final Random random;

    public Carrera() {
        this.caballo1 = new Caballo("Caballo 1", ";-;'");
        this.caballo2 = new Caballo("Caballo 2", ";-;'");
        this.random = new Random();
    }

    public void jugar() {
        System.out.println("Carrera de caballos");
        System.out.println();
        mostrarPista();

        boolean empiezaCaballo1 = random.nextBoolean();

        while (true) {
            if (empiezaCaballo1) {
                caballo1.avanzar(random);
                caballo2.avanzar(random);
            } else {
                caballo2.avanzar(random);
                caballo1.avanzar(random);
            }

            mostrarPista();

            boolean caballo1HaLlegado = caballo1.haLlegado(LONGITUD_PISTA);
            boolean caballo2HaLlegado = caballo2.haLlegado(LONGITUD_PISTA);

            if (caballo1HaLlegado && caballo2HaLlegado) {
                System.out.println("Empate");
                break;
            }

            if (caballo1HaLlegado) {
                System.out.println("Ganó el " + caballo1.getNombre());
                break;
            }

            if (caballo2HaLlegado) {
                System.out.println("Ganó el " + caballo2.getNombre());
                break;
            }
        }
    }

    private void mostrarPista() {
        String lineaCaballo1 = construirLinea(caballo1);
        String lineaCaballo2 = construirLinea(caballo2);

        System.out.println(repetir('-', LONGITUD_PISTA + 2));
        System.out.println(lineaCaballo1);
        System.out.println(lineaCaballo2);
        System.out.println(repetir('-', LONGITUD_PISTA + 2));
        System.out.println();
    }

    private String construirLinea(Caballo caballo) {
        int posicionVisible = Math.min(caballo.getPosicion(), LONGITUD_PISTA - 1);
        char[] carril = new char[LONGITUD_PISTA];

        for (int i = 0; i < LONGITUD_PISTA; i++) {
            carril[i] = ' ';
        }

        String marca = caballo.getMarcaVisual();
        for (int i = 0; i < marca.length(); i++) {
            int indice = posicionVisible + i;
            if (indice >= LONGITUD_PISTA) {
                break;
            }
            carril[indice] = marca.charAt(i);
        }

        return "|" + new String(carril) + "|";
    }

    private String repetir(char caracter, int veces) {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            texto.append(caracter);
        }
        return texto.toString();
    }
}