package design.patterns.structural.composite;

// Esta es la INTERFAZ que tanto los archivos como las carpetas
// deben cumplir. Es el "contrato" que dice:
// "todo lo que forme parte del sistema debe poder mostrarse"
public interface Componente {

    // Método que todos deben implementar.
    // 'nivel' indica qué tan adentro estamos en el árbol,
    // lo usamos para agregar espacios y que se vea bonito
    void mostrar(int nivel);
}