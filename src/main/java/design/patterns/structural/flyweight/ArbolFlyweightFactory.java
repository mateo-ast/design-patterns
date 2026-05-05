package design.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory que gestiona y reutiliza objetos Flyweight.
 * Esta clase es responsable de:
 * - Mantener un pool de objetos creados
 * - Reutilizar objetos existentes en lugar de crear nuevos
 * - Crear solo nuevos objetos cuando sea necesario
 */
public class ArbolFlyweightFactory {
    
    // Pool de árboles Flyweight - aquí se almacenan los objetos reutilizables
    private static final Map<String, Arbol> arbolPool = new HashMap<>();
    
    // Estadísticas
    private static int totalCreaciones = 0;
    private static int totalReutilizaciones = 0;
    
    /**
     * Obtiene un árbol del pool. Si no existe, lo crea.
     * La clave se genera combinando el estado intrínseco.
     * 
     * @param tipo tipo de árbol
     * @param altura altura del árbol
     * @param color color del árbol
     * @param textura textura del árbol
     * @return un objeto Arbol (creado o reutilizado)
     */
    public static Arbol obtenerArbol(String tipo, int altura, String color, String textura) {
        // Generar clave única basada en el estado intrínseco
        String clave = generarClave(tipo, altura, color, textura);
        
        // Verificar si el árbol ya existe en el pool
        if (!arbolPool.containsKey(clave)) {
            // ✅ Crear nuevo Flyweight
            System.out.println("📦 Creando nuevo Flyweight: [" + clave + "]");
            arbolPool.put(clave, new ArbolConcreteFlyweight(tipo, altura, color, textura));
            totalCreaciones++;
        } else {
            // ♻️ Reutilizar Flyweight existente
            System.out.println("♻️ Reutilizando Flyweight: [" + clave + "]");
            totalReutilizaciones++;
        }
        
        return arbolPool.get(clave);
    }
    
    /**
     * Genera una clave única para el árbol basada en su estado intrínseco.
     * 
     * @param tipo tipo de árbol
     * @param altura altura del árbol
     * @param color color del árbol
     * @param textura textura del árbol
     * @return clave única
     */
    private static String generarClave(String tipo, int altura, String color, String textura) {
        return tipo + "|" + altura + "|" + color + "|" + textura;
    }
    
    /**
     * @return cantidad de objetos Flyweight en el pool
     */
    public static int obtenerTamañoPool() {
        return arbolPool.size();
    }
    
    /**
     * @return cantidad total de creaciones de nuevos Flyweights
     */
    public static int obtenerTotalCreaciones() {
        return totalCreaciones;
    }
    
    /**
     * @return cantidad total de reutilizaciones de Flyweights
     */
    public static int obtenerTotalReutilizaciones() {
        return totalReutilizaciones;
    }
    
    /**
     * Muestra estadísticas del pool de Flyweights.
     */
    public static void mostrarEstadisticas() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ESTADÍSTICAS DEL FLYWEIGHT FACTORY");
        System.out.println("=".repeat(60));
        System.out.println("Objetos únicos en el pool: " + obtenerTamañoPool());
        System.out.println("Total de creaciones: " + obtenerTotalCreaciones());
        System.out.println("Total de reutilizaciones: " + obtenerTotalReutilizaciones());
        System.out.println("Total de accesos: " + (obtenerTotalCreaciones() + obtenerTotalReutilizaciones()));
        
        if (obtenerTotalCreaciones() + obtenerTotalReutilizaciones() > 0) {
            double porcentajeReutilizacion = (double) obtenerTotalReutilizaciones() 
                / (obtenerTotalCreaciones() + obtenerTotalReutilizaciones()) * 100;
            System.out.println("Porcentaje de reutilización: " + String.format("%.2f%%", porcentajeReutilizacion));
        }
        
        System.out.println("\nTipos de árboles en el pool:");
        arbolPool.forEach((clave, arbol) -> 
            System.out.println("  ├─ " + clave)
        );
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Limpia el pool de Flyweights y reinicia las estadísticas.
     */
    public static void limpiarPool() {
        arbolPool.clear();
        totalCreaciones = 0;
        totalReutilizaciones = 0;
        System.out.println("🗑️ Pool de Flyweights limpiado.");
    }
}
