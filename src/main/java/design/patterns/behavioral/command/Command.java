package design.patterns.behavioral.command;

public interface Command {
    void ejecutar();
    void deshacer();
    String descripcion();
}
