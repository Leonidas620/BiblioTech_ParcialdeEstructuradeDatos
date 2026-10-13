# 📚 Sistema de Control de Préstamos - BiblioTech

## 1. Explicación de la Problemática
El sistema **BiblioTech** resuelve la necesidad de gestionar, consultar y administrar los préstamos de libros dentro de una biblioteca. El núcleo del problema radica en procesar de manera eficiente colecciones dinámicas de objetos `Libro` sin hacer uso de las estructuras preconstruidas de la biblioteca estándar de Java (`java.util.*`), implementando lógica propia para resolver requerimientos operativos clave:
* **Identificación de libros vencidos:** Filtrar aquellos libros cuyo tiempo de préstamo excede un límite de días establecido.
* **Análisis estadístico:** Calcular el promedio de días de préstamo agrupados por categoría.
* **Gestión de renovaciones:** Extender el plazo de días de un préstamo específico mediante su código único.
* **Limpieza de catálogo:** Eliminar de forma segura todos los libros pertenecientes a una categoría determinada.
* **Identificación de extremos:** Localizar el libro que acumula la mayor cantidad de días en calidad de préstamo.

---

## 2. Estructura de Datos Empleada
El proyecto fue desarrollado utilizando **JDK 26** y se fundamenta en una implementación orientada a objetos y estructuras de datos hechas desde cero:

* **`ArrayList<T>` (Estructura Genérica Personalizada):** Una implementación propia de una lista dinámica basada en un arreglo interno de tipo `Object[]`. Cuenta con un mecanismo de redimensionamiento automático (`asegurarCapacidad`) que duplica la capacidad del arreglo cuando este se llena, junto con un riguroso control de límites e índices (`validarIndice`).
* **`Libro` (Modelo de Datos):** Clase que encapsula las propiedades fundamentales de cada ejemplar: código único (`cod`), nombre, días de préstamo (`dias`) y categoría.
* **`ControlBiblioTech` (Clase de Lógica de Negocio):** Contiene la colección de préstamos basada en la lista personalizada y los métodos algorítmicos que resuelven cada inciso requerido por el equipo.

---

## 3. Detalle de Casos de Prueba Ejecutados
La clase `main` ejecuta una batería exhaustiva de pruebas divididas en casos positivos y negativos para garantizar la robustez del sistema:

### **Casos Positivos:**
1. **`librosVencidos(10)`:** Filtra correctamente los libros cuyos días de préstamo superan el límite de 10 días ("Java a Fondo" con 15 y "Estructuras de Datos" con 22).
2. **`promedioDiasPorCategoria("Ingeniería")`:** Calcula el promedio de días de la categoría (suma 15 + 22 = 37, dividido entre 2 libros, arrojando un promedio entero de 18 debido a la división entera).
3. **`renovarPrestamo("L02", 5)`:** Actualiza con éxito los días del libro "Cien Años de Soledad" sumando 5 días adicionales a su valor actual.
4. **`buscarLibroConMAsDias()`:** Identifica correctamente el libro con mayor permanencia en préstamo antes y después de realizar modificaciones.
5. **`EliminarLibrosPorCategoria("Historia")`:** Remueve de manera segura los elementos de la categoría especificada, actualizando el tamaño total de la lista.

### **Casos Negativos y Manejo de Excepciones:**
1. **Parámetros inválidos:** Se valida que un límite de días negativo en `librosVencidos(-1)` o una categoría nula en `EliminarLibrosPorCategoria(null)` disparen excepciones del tipo `IllegalArgumentException`.
2. **Búsquedas inexistentes:** Se evalúa el comportamiento al intentar renovar un código de libro inexistente (`"L99"`) o un código nulo, retornando `false` de manera controlada.
3. **Listas vacías:** Se comprueba que operar sobre listas vacías en métodos como `promedioDiasPorCategoria` o `buscarLibroConMAsDias` lance la excepción adecuada (`IllegalStateException`), mientras que `librosVencidos` retorna una lista vacía de forma segura.
4. **Validaciones del `ArrayList` propio:** Se comprueba el lanzamiento de `IndexOutOfBoundsException` ante accesos fuera de rango (`get(0)` en lista vacía, `remove(5)` o `add(C, 5)`).

---

## 4. Declaración sobre el Uso de Inteligencia Artificial
De conformidad con los requerimientos del proyecto, se declara explícitamente que se hizo uso de herramientas de Inteligencia Artificial en las siguientes fases específicas de desarrollo:

* **Depuración de Código (Debugging):** La IA se utilizó para analizar la lógica de los bucles de recorrido y eliminación en `ControlBiblioTech` (específicamente en métodos como la eliminación de elementos por categoría con ajuste de índices) y en la lógica de redimensionamiento del `ArrayList`, ayudando a prevenir desbordamientos de memoria y errores de tipo al realizar castings genéricos.
* **Diseño y Redacción de la Clase Principal (`main`):** La estructura completa de pruebas, incluyendo la definición de los escenarios de prueba positivos, negativos y los bloques de captura de excepciones (`try-catch`), fue generada y estructurada con el apoyo de la IA para garantizar una cobertura de pruebas completa sobre el JDK 26.
