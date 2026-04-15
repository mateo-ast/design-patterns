package design.patterns.creational.prototype;

import design.patterns.DesignPattern;

public class Prototype implements DesignPattern {
    @Override
    public void run() {
        // Se crea una tarea base (prototipo)
        Tarea tareaBase = new Tarea("Estudiar", "Repasar patrones de diseño");

        // Se clona la tarea
        Tarea tarea1 = (Tarea) tareaBase.clonar();

        // Se modifica la copia
        tarea1.setNombre("Estudiar Java");

        // Se clona otra vez
        Tarea tarea2 = (Tarea) tareaBase.clonar();

        // Se modifica la segunda copia
        tarea2.setNombre("Estudiar Cálculo");

        // Se muestran todas
        tareaBase.mostrar();
        tarea1.mostrar();
        tarea2.mostrar();
    }
}
