package design.patterns.behavioral.interpreter;

public class BackwardExpression implements Expression {
  private int quantity;

  public BackwardExpression(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public void interpret(RobotContext robotContext) {
    robotContext.setxPosition(robotContext.getxPosition() - this.quantity);
  }
}
