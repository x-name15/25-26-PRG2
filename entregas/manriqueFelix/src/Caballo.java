import java.util.Random;

public class Caballo {
    private final String nombre;
    private final String marcaVisual;
    private int posicion;

    public Caballo(String nombre, String marcaVisual) {
        this.nombre = nombre;
        this.marcaVisual = marcaVisual;
        this.posicion = 0;
    }

    public void avanzar(Random random) {
        posicion += random.nextInt(3);
    }

    public boolean haLlegado(int longitudPista) {
        return posicion >= longitudPista - 1;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarcaVisual() {
        return marcaVisual;
    }

    public int getPosicion() {
        return posicion;
    }
}
