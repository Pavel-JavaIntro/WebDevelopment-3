package by.pavka.module3.entity;

public enum Material {
  FELT(0.38),
  RUBBER(0.8),
  IRON(7.0);

  private double density;

  Material(double density) {
    this.density = density;
  }

  public double getDensity() {
    return density;
  }
}
