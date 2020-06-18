package by.pavka.module3.entity;

import by.pavka.module3.exception.ImpossibleBallException;

public class Ball {
  private static final String WRONG_RADIUS = "Radius must be positive";
  private static final String WRONG_COLOR = "Color can't be null";
  private static final String WRONG_MATERIAL = "Material can't be null";

  private double radius;
  private BallColor ballColor;
  private Material material;

  public Ball(double radius, BallColor ballColor, Material material)
      throws ImpossibleBallException {
    if (radius > 0) {
      this.radius = radius;
    } else {
      throw new ImpossibleBallException(WRONG_RADIUS);
    }
    if (ballColor != null) {
      this.ballColor = ballColor;
    } else {
      throw new ImpossibleBallException(WRONG_COLOR);
    }
    if (material != null) {
      this.material = material;
    } else {
      throw new ImpossibleBallException(WRONG_MATERIAL);
    }
  }

  public Material getMaterial() {
    return material;
  }

  public double getRadius() {
    return radius;
  }

  public BallColor getBallColor() {
    return ballColor;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public void setBallColor(BallColor ballColor) {
    this.ballColor = ballColor;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Ball)) {
      return false;
    }
    Ball ball = (Ball) o;
    return ball.radius == radius && ball.ballColor == ballColor && ball.material == material;
  }

  @Override
  public int hashCode() {
    return (int) (7 * radius + 31 * ballColor.ordinal() + 17 * material.ordinal());
  }

  @Override
  public String toString() {
    return String.format("Ball made of %s, color %s, radius %.2f", material, ballColor, radius);
  }

  public double calculateVolume() {
    return 4 * Math.PI * Math.pow(getRadius(), 3) / 3;
  }

  public double calculateWeight() {
    double density = material.getDensity();
    return calculateVolume() * density;
  }
}
