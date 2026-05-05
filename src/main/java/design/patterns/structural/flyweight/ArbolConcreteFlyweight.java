package design.patterns.structural.flyweight;

/**
 * ConcreteFlyweight que almacena el estado intrínseco (compartible).
 * Esta clase representa un tipo específico de árbol con sus características
 * inmutables que se comparten entre múltiples instancias.
 */
public class ArbolConcreteFlyweight implements Arbol {
    
    // Estado Intrínseco - Estos datos se comparten entre múltiples objetos
    private final String tipo;
    private final int altura;
    private final String color;
    private final String textura;
    
    /**
     * Constructor que inicializa el estado intrínseco del árbol.
     * 
     * @param tipo tipo de árbol (Ej: "Roble", "Pino", "Arce")
     * @param altura altura del árbol en metros
     * @param color color del árbol
     * @param textura tipo de textura del árbol
     */
    public ArbolConcreteFlyweight(String tipo, int altura, String color, String textura) {
        this.tipo = tipo;
        this.altura = altura;
        this.color = color;
        this.textura = textura;
    }
    
    @Override
    public void mostrar(int x, int y) {
        // Estado Extrínseco - La posición (x, y) es única para cada instancia
        System.out.println("🌳 [" + tipo + "] en posición (" + x + ", " + y + 
                          ") | Altura: " + altura + "m | Color: " + color + 
                          " | Textura: " + textura);
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
    // Getters para el estado intrínseco
    public int getAltura() {
        return altura;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getTextura() {
        return textura;
    }
}
