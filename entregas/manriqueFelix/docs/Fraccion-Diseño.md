# Diseño de la Clase Fraccion

## Estructura del Proyecto
```
src
  ├── Fraccion.java
  └── PruebaFraccion.java
```

## Objetivo
Entender **encapsulación**: datos privados (internos) vs interfaz pública (métodos).
---

## Atributos Privados

**Atributos Privados:**
```java
private int numerador;
private int denominador; 
```

**Razón:** Evitar valores inválidos y cambios directos sin validación.

---

## Constructores
```java
public Fraccion(int numerador, int denominador)
public Fraccion(int numero)       // 5 → 5/1
public Fraccion(Fraccion f)       // Copia
public Fraccion()                 // 0/1
```

### Getters
```java
public int getNumerador()
public void setNumerador(int n)
public void setDenominador(int d)  // Valida ≠ 0

### Setters

public Fraccion dividir(Fraccion otra)
```

public double aDecimal()
public Fraccion clonar()
```

### Comparaciones
```java
public boolean esIgual(Fraccion otra)
public boolean esMayor(Fraccion otra)
public boolean esMenor(Fraccion otra)
```

### Object
```java
public String toString()
```

---

## Principios de Encapsulación

| Elemento | Tipo | Razón |
|----------|------|-------|
| numerador | private | Proteger datos |
| denominador | private | Evitar denominador = 0 |
| getNumerador() | public | Lectura segura |
| getDenominador() | public | Lectura segura |
| setters | public | Modificación validada |
| operaciones | public | Interfaz de trabajo |

---

## Principios

- Datos sensibles protegidos con `private`
- Acceso controlado mediante `public` methods
- Validaciones en constructores y setters
- Usuario no accede directamente a datos internos
