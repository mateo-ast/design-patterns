package design.patterns.behavioral.templatemethod;

// clase abstracta que implementa el patron Template Method
public abstract class Bebida {
  // metodos que usa mi clase

  // MÉTODO TEMPLATE → define los pasos
  public final void preparar() {
    calentarAgua();
    prepararIngrediente();
    servir();
  }

  public void calentarAgua() {
    System.out.println("calentando agua");
  }

  // cambia segun bebida
  protected void prepararIngrediente() {
  }

  // protected Permite que las subclases lo usen ;)

  protected void servir() {
  }
}
