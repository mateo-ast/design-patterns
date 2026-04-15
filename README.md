# Repositorio de Patrones de Diseño

Este proyecto contiene la implementación de 23 patrones de diseño de software (GoF) en Java. Está configurado con Apache Maven para estandarizar la compilación y ejecución en entornos multiplataforma (Linux, Windows y macOS).

[Guía para trabajar con git y github](GITHUB.md)

## Requisitos del Sistema

* Java Development Kit (JDK) 17 o superior.
* Apache Maven 3.x.

## Compilación

Para compilar el proyecto y generar el archivo binario ejecutable, abra una terminal en el directorio raíz del proyecto y ejecute el siguiente comando:

```bash
mvn clean package
```

Este proceso compilará el código fuente y generará un archivo empaquetado en la ruta `target/design-patterns-1.0.jar`. Todo miembro del equipo debe ejecutar este comando localmente tras sincronizar cambios del repositorio.

## Ejecución

El proyecto utiliza un sistema de resolución dinámica (*Reflection*) para identificar y ejecutar el código. El programa principal (`App.class`) recibe el nombre del patrón como argumento de consola y ejecuta la implementación correspondiente.

La sintaxis general de ejecución es la siguiente:

```bash
java -jar target/design-patterns-1.0.jar <nombre-del-patron>
```

**Ejemplos de uso:**
```bash
java -jar target/design-patterns-1.0.jar singleton
java -jar target/design-patterns-1.0.jar chain-of-responsibility
```

## Patrones Soportados

El argumento proporcionado en la línea de comandos debe coincidir exactamente con el formato `kebab-case` (minúsculas separadas por guiones).

### Patrones Creacionales
* `abstract-factory`
* `builder`
* `factory-method`
* `prototype`
* `singleton`

### Patrones Estructurales
* `adapter`
* `bridge`
* `composite`
* `decorator`
* `facade`
* `flyweight`
* `proxy`

### Patrones de Comportamiento
* `chain-of-responsibility`
* `command`
* `interpreter`
* `iterator`
* `mediator`
* `memento`
* `observer`
* `state`
* `strategy`
* `template-method`
* `visitor`
* `interpreter`

## Directrices de Desarrollo

Para garantizar que el sistema de ejecución dinámica detecte nuevos aportes, el código fuente debe respetar las siguientes convenciones:

1. **Implementación de Interfaz:** La clase de entrada de cada patrón debe implementar la interfaz `design.patterns.DesignPattern` y definir su lógica de demostración dentro del método `run()`.
2. **Nomenclatura de Clases:** El nombre de la clase debe escribirse utilizando formato `PascalCase` (por ejemplo, `AbstractFactory`).
3. **Estructura de Paquetes:** La declaración del paquete debe seguir la jerarquía `design.patterns.<categoria>.<nombrepatronsinguiones>`.
   * *Ejemplo válido:* `package design.patterns.creational.abstractfactory;`
