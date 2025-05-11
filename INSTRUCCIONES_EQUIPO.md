# Instrucciones para el Equipo

## Metodología de Trabajo con TDD

Este documento proporciona instrucciones detalladas sobre cómo trabajar en el proyecto de Tres en Raya siguiendo la metodología TDD (Test-Driven Development).

### Ciclo de Desarrollo TDD

1. **Red (Rojo)**: Escribir una prueba que falle

   - Identificar una funcionalidad pequeña y específica para implementar
   - Escribir una prueba unitaria que verifique esta funcionalidad
   - Ejecutar la prueba y verificar que falle (ya que la funcionalidad aún no existe)

2. **Green (Verde)**: Implementar el código mínimo necesario

   - Escribir el código más simple posible que haga que la prueba pase
   - No preocuparse por la elegancia o eficiencia en este punto
   - Ejecutar la prueba y verificar que pase

3. **Refactor**: Mejorar el código
   - Mejorar el diseño, eliminar duplicación, optimizar
   - Asegurarse de que todas las pruebas sigan pasando

### División de Tareas

Cada miembro del equipo debe seguir estos pasos para su parte asignada:

1. **Crear una rama para tu tarea**

   ```bash
   git checkout -b feature/nombre-de-tu-tarea
   ```

2. **Implementar las pruebas primero**

   - Crear archivos de prueba en `src/test/java/com/tictactoe/...`
   - Ejecutar las pruebas para verificar que fallen

3. **Implementar la funcionalidad**

   - Crear las clases necesarias en `src/main/java/com/tictactoe/...`
   - Implementar el código mínimo para que las pruebas pasen

4. **Refactorizar y mejorar**

   - Mejorar el código manteniendo las pruebas en verde

5. **Hacer commits frecuentes**

   - Hacer commits pequeños y frecuentes que muestren el proceso TDD

6. **Subir cambios y crear Pull Request**
   ```bash
   git push origin feature/nombre-de-tu-tarea
   ```
   - Crear un Pull Request en GitHub
   - Esperar la revisión de otro miembro del equipo
