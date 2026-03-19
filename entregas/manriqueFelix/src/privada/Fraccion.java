package privada;

import publica.Fraccion;

public class FraccionImpl implements Fraccion {

    private double numerador;
    private double denominador;

    public FraccionImpl(double numerador, double denominador) {
        assert denominador != 0 : "El denominador no puede ser 0!";
        this.denominador = denominador;
        this.numerador = numerador;
    }

    public FraccionImpl(double racional) {
        this(racional, 1);
    }

    public FraccionImpl(FraccionImpl fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }

    public Fraccion clonar() {
        return new FraccionImpl(numerador, denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        FraccionImpl f = (FraccionImpl) fraccion;
        return new FraccionImpl(
            numerador * f.denominador,
            denominador * f.numerador
        );
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        FraccionImpl f = (FraccionImpl) fraccion;
        return new FraccionImpl(
            numerador * f.numerador,
            denominador * f.denominador
        );
    }

    public Fraccion sumar(Fraccion fraccion) {
        FraccionImpl f = (FraccionImpl) fraccion;
        double denominador = this.denominador * f.denominador;
        double numerador = this.numerador * f.denominador
                         + f.numerador * this.denominador;
        return new FraccionImpl(numerador, denominador);
    }

    private double calcularMCD(double a, double b) {
        while (b != 0) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void invertir() {
        double temp = numerador;
        numerador = denominador;
        denominador = temp;
    }

    public void oponer() {
        numerador = -numerador;
    }
}