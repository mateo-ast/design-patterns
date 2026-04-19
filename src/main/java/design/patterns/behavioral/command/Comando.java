package design.patterns.behavioral.command;

public interface Comando {
    void ejecutar();
    void deshacer();
    String descripcion();
}
