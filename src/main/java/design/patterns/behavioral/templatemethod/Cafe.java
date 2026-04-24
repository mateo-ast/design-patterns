package design.patterns.behavioral.templatemethod;

class Cafe extends Bebida {

  @Override
  protected void prepararIngrediente() {
    System.out.println("Agregando café molido");
  }

  @Override
  protected void servir() {
    System.out.println("Sirviendo café en taza");
  }
}
