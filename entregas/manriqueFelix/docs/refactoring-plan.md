# Plan de Refactorización - ExamenMina.java

## Problemas Identificados

### Errores Críticos (Bugs)
1. **Comparación de String con `==`**: Usa `==` en lugar de `.equals()` para comparar Strings (líneas 45, 75, 77)
2. **Límites aleatorios incorrectos**: La generación de minas usa `Math.random()*2+1` y `Math.random()*4+1`, que no cubren el tablero completo de 5x7
3. **Confusión de coordenadas X/Y**: Las variables `posX` y `posY` están intercambiadas al leer la entrada
4. **Error de cálculo de índices**: Usar `PosXMina+1` y `PosYMina+1` puede causar ArrayIndexOutOfBoundsException
5. **Potencial bucle infinito**: Al verificar posiciones duplicadas de minas, decrementa el contador lo que puede causar bucle infinito
6. **Recurso Scanner sin cerrar**: El Scanner nunca se cierra, causando fuga de recursos
7. **Límites de bucle incorrectos**: `j<=mapaMinasMostrar.length+1` causará ArrayIndexOutOfBoundsException
8. **Validación faltante**: No valida valores mínimos (x<1, y<1) ni celdas ya reveladas
9. **Condición de victoria incorrecta**: El contador debería ser 30 (5*7=35 celdas - 5 minas = 30), no 31

### Problemas de Calidad de Código
10. **Comentarios innecesarios**: Comentarios de índices de arrays que no aportan valor
11. **Nombres de variables en español**: Nombres no ingleses reducen la legibilidad internacional
12. **Números mágicos**: Valores hardcodeados como 5, 7, 2, 3, 31 sin constantes
13. **Banderas enteras en lugar de boolean**: Usa `int` con valores 0/1 en lugar del tipo `boolean`
14. **Formato de código deficiente**: Indentación y espaciado inconsistentes
15. **Bloques else vacíos**: Cláusulas else vacías sin sentido
16. **Método main extenso**: Toda la lógica en main, viola el Principio de Responsabilidad Única
17. **Estado global mutable**: Arrays estáticos dificultan testing y reutilización
18. **Pobre separación de responsabilidades**: UI, lógica de juego y datos mezclados

## Pasos de Refactorización (Baby Steps)

### Fase 1: Corrección de Errores Críticos
1. Corregir comparación de Strings usando .equals()
2. Corregir límites aleatorios para generación de minas
3. Corregir confusión de coordenadas X/Y en manejo de entrada
4. Corregir límites de array en colocación de minas
5. Corregir bucle infinito en generación de minas
6. Corregir límites de bucle en visualización del tablero
7. Agregar validación de entrada para límites mínimos
8. Corregir contador de condición de victoria
9. Cerrar recurso Scanner apropiadamente

### Fase 2: Calidad de Código
10. Eliminar comentarios innecesarios
11. Renombrar variables a inglés
12. Reemplazar banderas enteras con boolean
13. Extraer números mágicos a constantes
14. Mejorar formato e indentación del código
15. Eliminar bloques else vacíos

### Fase 3: Refactorización Estructural
16. Extraer método de visualización del tablero
17. Extraer método de entrada del usuario
18. Extraer método de colocación de minas
19. Extraer método de validación de celdas
20. Extraer método de verificación de estado del juego
21. Considerar encapsulación con clase Game (paso avanzado opcional)

## Orden de Ejecución
Ejecutaremos estos pasos uno a la vez, haciendo commits incrementales para cada cambio para mantener un historial claro y asegurar que el código permanezca funcional en cada paso
