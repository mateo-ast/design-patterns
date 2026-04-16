package design.patterns.behavioral.interpreter;

import design.patterns.DesignPattern;

public class Interpreter implements DesignPattern {
  @Override
  public void run() {
    String i1 = "ATRAS 3 Y ADELANTE 10 Y ATRAS 2";
    String i2 = "ATRAS 24 Y ADELANTE 10 Y ADELANTE 8 Y ATRAS 9 Y ADELANTE 13";

    Expression e1 = buildTree(i1);
    Expression e2 = buildTree(i2);

    RobotContext robotContext1 = new RobotContext();
    RobotContext robotContext2 = new RobotContext();

    e1.interpret(robotContext1);
    e2.interpret(robotContext2);

    System.out.println("Entrada 1: " + i1);
    System.out.println("Posición final: " + robotContext1.getxPosition());

    System.out.println("Entrada 2: " + i2);
    System.out.println("Posición final: " + robotContext2.getxPosition());
  }

  public static Expression buildTree(String text) {
    String[] commands = text.split(" Y ");
    Expression syntaxTree = null;

    for (String cmd : commands) {
      String[] parts = cmd.trim().split(" ");
      String action = parts[0];
      int value = Integer.parseInt(parts[1]);

      Expression currentExpression = null;
      if (action.equals("ADELANTE")) {
        currentExpression = new ForwardExpression(value);
      } else if (action.equals("ATRAS")) {
        currentExpression = new BackwardExpression(value);
      }

      if (syntaxTree == null) {
        syntaxTree = currentExpression;
      } else {
        syntaxTree = new AndNonTerminalExpression(syntaxTree, currentExpression);
      }
    }
    return syntaxTree;
  }
}
