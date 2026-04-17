package design.patterns.behavioral.interpreter;

public class ForwardExpression implements Expression {
  private int quantity;

  public ForwardExpression(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public void interpret(RobotContext robotContext) {
    robotContext.setxPosition(robotContext.getxPosition() + this.quantity);
  }
}
