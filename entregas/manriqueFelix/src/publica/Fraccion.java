package publica;

public interface Fraccion {

    public Fraccion clonar();

    public Fraccion dividir(Fraccion fraccion);
    public Fraccion multiplicar(Fraccion fraccion);
    public Fraccion sumar(Fraccion fraccion);

    public void invertir();
    public void oponer();
}