package design.patterns.behavioral.visitor;
// Esta interfaz la deben implementar todos los productos de la tienda.
// Solo tiene UN método: aceptar a un visitante.
// Es como decir: "yo, producto, acepto que alguien venga a operarme".

public interface Producto {

    // "visitar" recibe un objeto Visitante.
    // Cada producto que implemente esta interfaz deberá
    // llamar al método correspondiente del visitante.
    void aceptar(Visitante visitante);
}