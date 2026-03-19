# Diseño de la Clase Fraccion

## Estructura del Proyecto
```
src
  ├── publica/Fraccion.java        (INTERFAZ)
  └── privada/FraccionImpl.java    (IMPLEMENTACIÓN)
```

---

## Objetivo
Entender **encapsulación** separando:

- **Interfaz pública** → lo que el usuario puede usar
- **Implementación privada** → cómo funciona internamente

---

## Interfaz Pública (`publica/Fraccion.java`)

Define SOLO los métodos accesibles:

```java
package publica;

public interface Fraccion {

    public Fraccion clonar();

    public Fraccion dividir(Fraccion fraccion);
    public Fraccion multiplicar(Fraccion fraccion);
    public Fraccion sumar(Fraccion fraccion);

    public void invertir();
    public void oponer();
}
```

---

## Implementación (`privada/FraccionImpl.java`)

Aquí está la lógica real.

### Atributos privados
```java
private double numerador;
private double denominador;
```

**Razón:** proteger los datos internos

---

### Constructores
```java
public FraccionImpl(double numerador, double denominador)
public FraccionImpl(double racional)
public FraccionImpl(FraccionImpl fraccion)
```

---

### Métodos públicos (interfaz)
```java
public Fraccion clonar()
public Fraccion dividir(Fraccion fraccion)
public Fraccion multiplicar(Fraccion fraccion)
public Fraccion sumar(Fraccion fraccion)
public void invertir()
public void oponer()
```

---

### Método privado
```java
private double calcularMCD(double a, double b)
```

Uso interno, no accesible desde fuera

---

## Principios de Encapsulación

| Elemento | Tipo | Razón |
|----------|------|-------|
| numerador | private | Proteger datos |
| denominador | private | Evitar errores |
| métodos | public | Interfaz de uso |
| lógica interna | private | Ocultar implementación |

---

## Principios

- Separación entre **interfaz** y **implementación**
- Datos protegidos con `private`
- Métodos públicos como única forma de acceso
- El usuario trabaja con `Fraccion`, no con `FraccionImpl`