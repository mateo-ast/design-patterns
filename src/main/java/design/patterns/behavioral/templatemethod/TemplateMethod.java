package design.patterns.behavioral.templatemethod;

import design.patterns.DesignPattern;

public class TemplateMethod implements DesignPattern {
  @Override
  public void run() {
    Bebida te = new Te();
    te.preparar();

    System.out.println("------");

    Bebida cafe = new Cafe();
    cafe.preparar();
  }
}
