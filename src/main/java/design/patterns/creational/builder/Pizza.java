package design.patterns.creational.builder;

// Esta clase representa el PRODUCTO FINAL: una Pizza.
// No se construye directamente, sino a través del Builder.
public class Pizza {

    // Atributos de la pizza. Todos son opcionales excepto el tamaño.
    private String tamaño;
    private String masa;
    private String salsa;
    private String queso;
    private boolean pepperoni;
    private boolean champiñones;

    // Constructor PRIVADO: nadie puede crear una Pizza directamente.
    // Solo el Builder puede crearla.
    private Pizza() {}

    // Método para mostrar cómo quedó la pizza
    public String toString() {
        return "Pizza [tamaño=" + tamaño + ", masa=" + masa +
               ", salsa=" + salsa + ", queso=" + queso +
               ", pepperoni=" + pepperoni + ", champiñones=" + champiñones + "]";
    }

    // =========================================================
    // BUILDER: es una clase DENTRO de Pizza (clase anidada)
    // Se encarga de construir la pizza paso a paso
    // =========================================================
    public static class PizzaBuilder {

        // El builder tiene los mismos atributos que Pizza
        // porque va armando la pizza internamente
        private Pizza pizza;

        // Cuando se crea el Builder, se le da el tamaño obligatorio
        // y se crea una pizza vacía lista para armar
        public PizzaBuilder(String tamaño) {
            pizza = new Pizza();         // Crea la pizza vacía
            pizza.tamaño = tamaño;       // El tamaño es obligatorio
        }

        // Cada método de abajo agrega UN ingrediente y devuelve
        // "this" (el mismo builder) para poder encadenar llamadas

        public PizzaBuilder conMasa(String masa) {
            pizza.masa = masa;
            return this; // Devuelve el builder para seguir agregando cosas
        }

        public PizzaBuilder conSalsa(String salsa) {
            pizza.salsa = salsa;
            return this;
        }

        public PizzaBuilder conQueso(String queso) {
            pizza.queso = queso;
            return this;
        }

        public PizzaBuilder conPepperoni() {
            pizza.pepperoni = true;
            return this;
        }

        public PizzaBuilder conChampiñones() {
            pizza.champiñones = true;
            return this;
        }

        // Este es el método FINAL: cuando se termina de agregar
        // ingredientes, llamás build() y te devuelve la pizza lista
        public Pizza build() {
            return pizza;
        }
    }
}
