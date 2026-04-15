package design.patterns.structural.adapter;

import design.patterns.DesignPattern;

public class Adapter implements DesignPattern {
  @Override
  public void run() {
    System.out.println("Executing pattern: Adapter");
    RoundHole hole = new RoundHole(5);
    RoundPeg rpeg = new RoundPeg(5);
    if (hole.fits(rpeg)) {
      System.out.println("La pieza redonda con radio 5 encaja en el agujero redondo con radio 5.");
    }

    SquarePeg smallSqPeg = new SquarePeg(2);
    SquarePeg largeSqPeg = new SquarePeg(20);
    // hole.fits(smallSqPeg); // No compila

    SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
    SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);

    if (hole.fits(smallSqPegAdapter)) {
      System.out.println("La pieza cuadrada con ancho 2 encaja en el agujero redondo con radio 5.");
    }
    if (!hole.fits(largeSqPegAdapter)) {
      System.out.println("La pieza cuadrada con ancho 20 no encaja en el agujero redondo con radio 5.");
    }
  }
}
