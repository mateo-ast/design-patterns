package design.patterns.behavioral.templatemethod;

public class Te extends Bebida {

  @Override
  protected void prepararIngrediente() {
    System.out.println("Agregando saquito de té");
  }

  @Override
  protected void servir() {
    System.out.println("Sirviendo té en taza");
  }
}
