# Diseño del reto 005

## Objetivo

Simular una carrera de dos caballos en una pista de 40 posiciones. En cada ronda cada caballo avanza de forma aleatoria entre 0 y 2 casillas. La carrera termina cuando ambos han completado la misma ronda y se comprueba si hay ganador o empate.

## Estructura propuesta

### `Juego`

Clase de arranque. Solo contiene el `main` y crea una instancia de `Carrera` para ejecutar la simulación.

### `Carrera`

Controla toda la lógica de la partida.

- Define la longitud de la pista.
- Crea los dos caballos.
- Decide al azar qué caballo empieza primero en cada ronda.
- Hace avanzar a los caballos.
- Muestra el estado de la pista en cada ronda.
- Calcula si gana el caballo 1, gana el caballo 2 o si hay empate.

## Salida por terminal 

La simulacion se ejecuta y se visualiza completamente en terminal.

- No se usa interfaz grafica.
- Cada turno imprime el estado de la pista con caracteres de texto.
- El resultado final tambien se imprime por terminal: gana caballo 1, gana caballo 2 o empate.

### `Caballo`

Representa a un participante de la carrera.

- Guarda su nombre.
- Guarda su posición actual.
- Puede avanzar un número aleatorio de casillas.
- Puede indicar si ya ha llegado al final.

## Flujo de ejecución

1. Se crea la carrera.
2. Se pinta la pista inicial.
3. En cada ronda se decide el orden de salida.
4. Cada caballo avanza entre 0 y 2 casillas.
5. Se vuelve a mostrar la pista.
6. Si ambos llegan al final en la misma ronda, hay empate.
7. Si solo uno llega, ese caballo gana.

## Decisiones de diseño

- Se usa una implementación sencilla y legible, sin herencia ni estructuras innecesarias.
- La pista se representa con texto para que se ejecute directamente en terminal sin dependencias externas.
- Se agrupan las reglas de juego en `Carrera` para que `Juego` sea muy simple.
