# Guía Paso a Paso: Patrón Flyweight

## 📚 Tabla de Contenidos
1. [Introducción](#introducción)
2. [Conceptos Clave](#conceptos-clave)
3. [Componentes del Patrón](#componentes-del-patrón)
4. [Paso a Paso de Implementación](#paso-a-paso-de-implementación)
5. [Ejemplo Práctico Completo](#ejemplo-práctico-completo)
6. [Ventajas y Desventajas](#ventajas-y-desventajas)

---

## Introducción

El **Patrón Flyweight** es un patrón estructural que se utiliza para **optimizar la memoria** cuando se crean muchos objetos similares. En lugar de crear innumerables objetos independientes, Flyweight reutiliza objetos existentes compartiendo datos comunes entre múltiples instancias.

### ¿Cuándo usar Flyweight?

- Cuando tu aplicación crea **miles o millones de objetos similares**
- Cuando el **costo de memoria es significativo**
- Cuando los objetos tienen muchos datos **intrínsecos** (inmutables, compartidos) y pocos datos **extrínsecos** (mutables, únicos)

**Ejemplo del mundo real:** En un videojuego con millones de árboles del mismo tipo, Flyweight permite compartir el modelo 3D entre todos ellos.

---

## Conceptos Clave

### Estado Intrínseco vs Extrínseco

| Concepto | Descripción | Ejemplo |
|----------|-------------|---------|
| **Estado Intrínseco** | Datos que NO cambian y pueden ser compartidos entre objetos | Tipo de árbol, textura, forma |
| **Estado Extrínseco** | Datos únicos de cada objeto que se pasan desde afuera | Posición (X, Y), rotación, escala |

### Principio Core

```
Memoria ahorrada = (Objetos reutilizados) × (Tamaño del objeto compartido)
```

---

## Componentes del Patrón

### 1. **Flyweight (Interfaz)**
Define el contrato para los objetos compartibles que recibirán estado extrínseco.

### 2. **ConcreteFlyweight (Clase)**
Implementa Flyweight e almacena el estado intrínseco (inmutable).

### 3. **UnsharedConcreteFlyweight (Clase Opcional)**
Objetos que no se pueden o no deben compartirse.

### 4. **FlyweightFactory (Clase)**
Gestiona el pool de objetos Flyweight reutilizables.

### 5. **Client (Clase)**
Usa los Flyweights y mantiene el estado extrínseco.

---

## Paso a Paso de Implementación

### Paso 1: Identificar el Estado Intrínseco

Analiza tus objetos y separa qué datos son intrínsecos (compartibles) y cuáles son extrínsecos (únicos).

```java
// ❌ Mal - Cada objeto almacena todo
class Arbol {
    String tipo;      // Intrínseco (compartible)
    int altura;       // Intrínseco (compartible)
    String textura;   // Intrínseco (compartible)
    int x;           // Extrínseco (único)
    int y;           // Extrínseco (único)
}

// ✅ Bien - Separar estados
// Intrínseco → ConcreteFlyweight
// Extrínseco → Client o Context
```

### Paso 2: Crear la Interfaz Flyweight

Define una interfaz que acepte el estado extrínseco como parámetro.

```java
public interface Flyweight {
    void mostrar(int x, int y); // x, y son estado extrínseco
}
```

### Paso 3: Implementar ConcreteFlyweight

Almacena el estado intrínseco (compartido) de forma inmutable.

```java
public class ArbolConcreteFlyweight implements Flyweight {
    // Estado Intrínseco (compartido)
    private String tipo;
    private int altura;
    private String color;

    public ArbolConcreteFlyweight(String tipo, int altura, String color) {
        this.tipo = tipo;
        this.altura = altura;
        this.color = color;
    }

    @Override
    public void mostrar(int x, int y) {
        // Estado Extrínseco (posición única)
        System.out.println("Árbol " + tipo + " en (" + x + ", " + y + ")");
        System.out.println("Altura: " + altura + ", Color: " + color);
    }
}
```

### Paso 4: Crear la FlyweightFactory

Mantiene un pool de objetos Flyweight y reutiliza los existentes.

```java
import java.util.HashMap;
import java.util.Map;

public class ArbolFlyweightFactory {
    // Pool de Flyweights
    private static final Map<String, Flyweight> arbolPool = new HashMap<>();

    public static Flyweight obtenerArbol(String tipo, int altura, String color) {
        // Crear una clave única basada en los atributos intrínsecos
        String clave = tipo + "-" + altura + "-" + color;

        // Si no existe, crearlo
        if (!arbolPool.containsKey(clave)) {
            System.out.println("📦 Creando nuevo Flyweight: " + clave);
            arbolPool.put(clave, new ArbolConcreteFlyweight(tipo, altura, color));
        } else {
            System.out.println("♻️ Reutilizando Flyweight: " + clave);
        }

        return arbolPool.get(clave);
    }

    public static int getTamañoPool() {
        return arbolPool.size();
    }
}
```

### Paso 5: Implementar el Cliente

Usa la factory para obtener Flyweights y les pasa el estado extrínseco.

```java
public class Cliente {
    public static void main(String[] args) {
        // Simular la creación de 100,000 árboles
        // Sin Flyweight: 100,000 objetos en memoria
        // Con Flyweight: Solo 3 objetos compartidos

        for (int i = 0; i < 10000; i++) {
            String tipo = (i % 3 == 0) ? "Roble" : (i % 3 == 1) ? "Pino" : "Arce";
            int altura = 10 + (i % 5);
            String color = (i % 2 == 0) ? "Verde" : "Oscuro";

            Flyweight arbol = ArbolFlyweightFactory.obtenerArbol(tipo, altura, color);
            
            // Posición única (estado extrínseco)
            int x = i % 100;
            int y = i / 100;
            
            // Solo mostrar algunos para no saturar la consola
            if (i < 5 || i % 3333 == 0) {
                arbol.mostrar(x, y);
            }
        }

        System.out.println("\n📊 Estadísticas:");
        System.out.println("Árboles creados: 10,000");
        System.out.println("Objetos Flyweight en memoria: " + ArbolFlyweightFactory.getTamañoPool());
        System.out.println("Ahorro de memoria: " + ((10000 - ArbolFlyweightFactory.getTamañoPool()) * 100 / 10000) + "%");
    }
}
```

---

## Ejemplo Práctico Completo

### Caso: Sistema de Videojuego con Partículas

#### Paso 1: Interfaz Flyweight

```java
public interface Particula {
    void renderizar(double x, double y, double velocidadX, double velocidadY);
}
```

#### Paso 2: ConcreteFlyweight

```java
public class ParticulaConcreteFlyweight implements Particula {
    // Estado Intrínseco
    private String tipo;        // "Fuego", "Humo", "Agua"
    private String textura;
    private int tamaño;
    private String color;

    public ParticulaConcreteFlyweight(String tipo, String textura, int tamaño, String color) {
        this.tipo = tipo;
        this.textura = textura;
        this.tamaño = tamaño;
        this.color = color;
        System.out.println("🆕 Creada partícula: " + tipo);
    }

    @Override
    public void renderizar(double x, double y, double vx, double vy) {
        // Estado Extrínseco (posición y velocidad)
        System.out.printf("Partícula %s en (%.1f, %.1f) - Velocidad: (%.1f, %.1f)%n", 
                         tipo, x, y, vx, vy);
    }
}
```

#### Paso 3: FlyweightFactory

```java
public class ParticulaFlyweightFactory {
    private static final Map<String, Particula> particulaPool = new HashMap<>();

    public static Particula obtenerParticula(String tipo, String textura, int tamaño, String color) {
        String clave = tipo + ":" + textura + ":" + tamaño + ":" + color;

        particulaPool.putIfAbsent(clave, 
            new ParticulaConcreteFlyweight(tipo, textura, tamaño, color));

        return particulaPool.get(clave);
    }

    public static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de tipos de partículas en pool: " + particulaPool.size());
        particulaPool.forEach((clave, particula) -> 
            System.out.println("  - " + clave)
        );
    }
}
```

#### Paso 4: Sistema de Efectos

```java
public class SistemaEfectos {
    public static void main(String[] args) {
        // Simular explosión con miles de partículas
        System.out.println("💥 Explosión iniciada!\n");
        
        for (int i = 0; i < 5000; i++) {
            String tipo = (i % 3 == 0) ? "Fuego" : (i % 3 == 1) ? "Humo" : "Chispa";
            
            Particula p = ParticulaFlyweightFactory.obtenerParticula(
                tipo, 
                "textura_" + tipo.toLowerCase(), 
                5 + (i % 10), 
                "Naranja"
            );

            // Estado extrínseco: posición y velocidad únicas
            double x = 100 + Math.random() * 50;
            double y = 100 + Math.random() * 50;
            double vx = (Math.random() - 0.5) * 10;
            double vy = (Math.random() - 0.5) * 10;

            if (i < 3) p.renderizar(x, y, vx, vy);
        }

        ParticulaFlyweightFactory.mostrarEstadisticas();
    }
}
```

---

## Ventajas y Desventajas

### ✅ Ventajas

| Ventaja | Descripción |
|---------|-------------|
| **Reduce Memoria** | Ahorra memoria significativa al compartir objetos |
| **Mejora Performance** | Menos objetos = menos recolección de basura |
| **Escalabilidad** | Permite manejar millones de objetos |
| **Transparencia** | Los clientes no notan que se están reutilizando objetos |

### ❌ Desventajas

| Desventaja | Descripción |
|-----------|-------------|
| **Complejidad** | Requiere separar estado intrínseco y extrínseco |
| **CPU vs Memoria** | Puede aumentar uso de CPU para buscar en el pool |
| **Thread-Safety** | Requiere sincronización en entornos multihilo |
| **Debugging Difícil** | Más complejo de depurar por la compartición de objetos |

### 📊 Comparación de Impacto

```
Escenario: 1 millón de árboles

Sin Flyweight:
├─ Memoria: ~1GB (si cada objeto ocupa ~1KB)
└─ Rendimiento: Bajo (muchos objetos)

Con Flyweight:
├─ Memoria: ~3MB (si hay 3000 tipos diferentes)
└─ Rendimiento: Alto (pocos objetos)

AHORRO: ~99.7% de memoria
```

---

## Checklist de Implementación

- [ ] Identificar el estado intrínseco (compartible)
- [ ] Identificar el estado extrínseco (único)
- [ ] Crear la interfaz Flyweight
- [ ] Implementar ConcreteFlyweight con estado intrínseco
- [ ] Crear FlyweightFactory con pool de objetos
- [ ] Implementar método de reutilización con clave única
- [ ] Crear Cliente que use la factory
- [ ] Pasar estado extrínseco en métodos de Flyweight
- [ ] Probar con muchos objetos
- [ ] Medir y documentar el ahorro de memoria

---

## Patrones Relacionados

- **Singleton**: A menudo se usa FlyweightFactory como Singleton
- **Factory Method**: FlyweightFactory es una especialización del Factory Method
- **Object Pool**: Concepto similar pero más genérico

---

## Referencias Útiles

- [GoF Design Patterns - Flyweight](https://en.wikipedia.org/wiki/Flyweight_pattern)
- Libro: "Design Patterns: Elements of Reusable Object-Oriented Software"
- Java Memory Management y optimización de objetos

---

**Última actualización:** 2024  
**Autor:** Guía de Patrones de Diseño
