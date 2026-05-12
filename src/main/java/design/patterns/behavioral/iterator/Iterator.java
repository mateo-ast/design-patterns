package design.patterns.behavioral.iterator;

import design.patterns.DesignPattern;

/**
 * Demostración del patrón Iterator con Pokémon
 * Muestra el uso de múltiples iteradores sobre una colección de Pokémon
 */
public class Iterator implements DesignPattern {
    @Override
    public void run() {
        // Crear la colección de Pokémon
        ColeccionPokemonEspecializada pokedex = new ColeccionPokemonEspecializada();
        
        // Agregar Pokémon con tipos elementales correctos y número de Pokédex
        pokedex.agregar(new Pokemon("Bulbasaur", "Planta", "Veneno", 1));
        pokedex.agregar(new Pokemon("Charmander", "Fuego", null, 4));
        pokedex.agregar(new Pokemon("Squirtle", "Agua", null, 7));
        pokedex.agregar(new Pokemon("Pikachu", "Eléctrico", null, 25));
        pokedex.agregar(new Pokemon("Meowth", "Normal", null, 52));
        pokedex.agregar(new Pokemon("Psyduck", "Agua", null, 54));
        pokedex.agregar(new Pokemon("Growlithe", "Fuego", null, 58));
        pokedex.agregar(new Pokemon("Jigglypuff", "Normal", "Hada", 39));
        pokedex.agregar(new Pokemon("Zubat", "Veneno", "Volador", 41));
        pokedex.agregar(new Pokemon("Oddish", "Planta", "Veneno", 69));

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     DEMOSTRACIÓN DEL PATRÓN ITERATOR      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // 1. Iterador Normal (de principio a fin)
        System.out.println("ITERADOR NORMAL (de principio a fin):");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorNormal = pokedex.crearIterador();
        while (iteradorNormal.hasNext()) {
            System.out.println("   " + iteradorNormal.next());
        }
        System.out.println();

        // 2. Iterador Inverso (de fin a principio)
        System.out.println("ITERADOR INVERSO (de fin a principio):");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorInverso = pokedex.crearIteradorInverso();
        while (iteradorInverso.hasNext()) {
            System.out.println("   " + iteradorInverso.next());
        }
        System.out.println();

        // 3. Iterador Ordenado por Pokédex
        System.out.println("ITERADOR ORDENADO POR POKÉDEX:");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorOrdenado = pokedex.crearIteradorOrdenado();
        while (iteradorOrdenado.hasNext()) {
            System.out.println("   " + iteradorOrdenado.next());
        }
        System.out.println();

        // 4. Iterador por Tipo: Fuego
        System.out.println("ITERADOR POR TIPO - FUEGO:");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorFuego = pokedex.crearIteradorPorTipo("Fuego");
        while (iteradorFuego.hasNext()) {
            System.out.println("   " + iteradorFuego.next());
        }
        System.out.println();

        // 5. Iterador por Tipo: Agua
        System.out.println("ITERADOR POR TIPO - AGUA:");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorAgua = pokedex.crearIteradorPorTipo("Agua");
        while (iteradorAgua.hasNext()) {
            System.out.println("   " + iteradorAgua.next());
        }
        System.out.println();

        // 6. Iterador por Tipo: Veneno
        System.out.println("ITERADOR POR TIPO - VENENO:");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorVeneno = pokedex.crearIteradorPorTipo("Veneno");
        while (iteradorVeneno.hasNext()) {
            System.out.println("   " + iteradorVeneno.next());
        }
        System.out.println();

        // 7. Demostración de reset
        System.out.println("DEMOSTRACIÓN DE RESET:");
        System.out.println("───────────────────────────────────────────");
        Iterador<Pokemon> iteradorReset = pokedex.crearIterador();
        System.out.println("   Primera pasada (primeros 3):");
        for (int i = 0; i < 3 && iteradorReset.hasNext(); i++) {
            System.out.println("      " + iteradorReset.next());
        }
        iteradorReset.reset();
        System.out.println("   Después de reset (primeros 2):");
        for (int i = 0; i < 2 && iteradorReset.hasNext(); i++) {
            System.out.println("      " + iteradorReset.next());
        }
    }

    /**
     * Método main para ejecutar directamente desde esta clase
     */
    public static void main(String[] args) {
        new Iterator().run();
    }
}
