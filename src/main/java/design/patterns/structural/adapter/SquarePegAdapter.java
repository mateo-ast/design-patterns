package design.patterns.structural.adapter;

public class SquarePegAdapter extends RoundPeg {
  private SquarePeg peg;

  public SquarePegAdapter(SquarePeg peg) {
    super(SquarePegAdapter.getRadius(peg.getWidth()));
    this.peg = peg;
  }

  @Override
  public double getRadius() {
    return SquarePegAdapter.getRadius(peg.getWidth());
  }

  private static double getRadius(double width) {
    return (Math.sqrt(Math.pow((width / 2), 2) * 2));
  }
}
