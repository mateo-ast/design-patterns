package design.patterns.behavioral.interpreter;

public class AndNonTerminalExpression implements Expression {
  private Expression left;
  private Expression right;

  public AndNonTerminalExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void interpret(RobotContext robotContext) {
    left.interpret(robotContext);
    right.interpret(robotContext);
  }
}
