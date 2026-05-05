package design.patterns.structural.flyweight;

import design.patterns.DesignPattern;

/**
 * Implementación del Patrón Flyweight.
 * 
 * Este patrón se utiliza para optimizar la memoria cuando se crean muchos
 * objetos similares. Permite compartir datos comunes (estado intrínseco)
 * entre múltiples instancias, mientras que datos únicos (estado extrínseco)
 * se mantienen separados.
 * 
 * Componentes:
 * - Flyweight (Interfaz): Define el contrato de los objetos compartibles
 * - ConcreteFlyweight: Implementa Flyweight con estado intrínseco
 * - FlyweightFactory: Gestiona el pool de objetos compartibles
 * - Context: Utiliza los Flyweights manteniendo estado extrínseco
 */
public class Flyweight implements DesignPattern {
    
    @Override
    public void run() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("🎨 PATRÓN FLYWEIGHT - Optimización de Memoria");
        System.out.println("=".repeat(70) + "\n");
        
        Bosque bosque = new Bosque();
        
        System.out.println("📍 Plantando 10 árboles...\n");
        
        // Plantar 10 árboles (algunos repetirán sus características)
        bosque.plantarArbol("Roble", 15, "Verde", "Áspera", 10, 20);
        bosque.plantarArbol("Pino", 20, "Verde Oscuro", "Lisa", 30, 40);
        bosque.plantarArbol("Arce", 12, "Rojo", "Media", 50, 60);
        bosque.plantarArbol("Roble", 15, "Verde", "Áspera", 70, 80);      // ♻️ Reutiliza
        bosque.plantarArbol("Pino", 20, "Verde Oscuro", "Lisa", 90, 100); // ♻️ Reutiliza
        bosque.plantarArbol("Abedul", 18, "Blanco", "Lisa", 110, 120);
        bosque.plantarArbol("Roble", 15, "Verde", "Áspera", 130, 140);    // ♻️ Reutiliza
        bosque.plantarArbol("Arce", 12, "Rojo", "Media", 150, 160);       // ♻️ Reutiliza
        bosque.plantarArbol("Pino", 20, "Verde Oscuro", "Lisa", 170, 180);// ♻️ Reutiliza
        bosque.plantarArbol("Sauce", 16, "Amarillo", "Rugosa", 190, 200);
        
        // Mostrar bosque
        bosque.mostrarBosque();
        
        // Mostrar estadísticas
        ArbolFlyweightFactory.mostrarEstadisticas();
        
        // Análisis
        System.out.println("Análisis:");
        System.out.println("├─ Árboles plantados: " + bosque.obtenerCantidadArboles());
        System.out.println("├─ Objetos únicos en memoria: " + ArbolFlyweightFactory.obtenerTamañoPool());
        System.out.println("├─ Ahorro de memoria: " + 
            ((bosque.obtenerCantidadArboles() - ArbolFlyweightFactory.obtenerTamañoPool()) * 100 / bosque.obtenerCantidadArboles()) + "%");
        System.out.println("└─ Patrón aplicado exitosamente\n");
    }
    
    /**
     * Método main para ejecutar directamente desde IDE
     */
    public static void main(String[] args) {
        Flyweight flyweight = new Flyweight();
        flyweight.run();
    }
}

