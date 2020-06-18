package by.pavka.module3.entity;

import by.pavka.module3.exception.ImpossibleBallException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {

  // This value shows an approximate volume share of spherical balls in the basket
  private static final double PACKING_RATIO = 0.7;

  private static final double MIN_VOLUME = 1.0;
  private static final double MAX_VOLUME = 100000.0;

  private double effectiveVolume;
  private double loadLimit;
  private List<Ball> balls;
  private boolean isBroken;

  public Basket(double volume, double loadLimit) {
    balls = new ArrayList<>();
    if (volume < MIN_VOLUME) {
      volume = MIN_VOLUME;
    }
    if (volume > MAX_VOLUME) {
      volume = MAX_VOLUME;
    }
    effectiveVolume = volume * PACKING_RATIO;
    this.loadLimit = loadLimit;
  }

  public double getEffectiveVolume() {
    return effectiveVolume;
  }

  public double getLoadLimit() {
    return loadLimit;
  }

  public void setEffectiveVolume(double effectiveVolume) {
    this.effectiveVolume = effectiveVolume;
  }

  public void setLoadLimit(double loadLimit) {
    this.loadLimit = loadLimit;
  }

  public void setBalls(List<Ball> balls) {
    this.balls = balls;
  }

  public void setBroken(boolean broken) {
    isBroken = broken;
  }

  public double calculateOccupiedVolume() {
    double occupiedVolume = 0;
    for (Ball ball : balls) {
      occupiedVolume += ball.calculateVolume();
    }
    return occupiedVolume;
  }

  public double calculateLoad() {
    double load = 0;
    for (Ball ball : balls) {
      load += ball.calculateWeight();
    }
    return load;
  }

  public List<Ball> getBalls() {
    return Collections.unmodifiableList(balls);
  }

  public boolean isBroken() {
    return isBroken;
  }

  public boolean addBall(Ball ball) {
    if (ball == null) {
      return false;
    }
    if (calculateOccupiedVolume() + ball.calculateVolume() > effectiveVolume) {
      return false;
    }
    if (calculateLoad() + ball.calculateWeight() > loadLimit) {
      getBroken();
      return false;
    }
    return balls.add(ball);
  }

  public boolean addBall(double radius, BallColor ballColor, Material material)
      throws ImpossibleBallException {
    Ball ball = new Ball(radius, ballColor, material);
    return addBall(ball);
  }

  private void getBroken() {
    effectiveVolume = 0;
    loadLimit = 0;
    balls = new ArrayList<>();
    isBroken = true;
  }

  public boolean removeBall(Ball ball) {
    if (balls.contains(ball)) {
      return balls.remove(ball);
    } else {
      return false;
    }
  }

  public boolean removeBall(double radius, BallColor ballColor, Material material)
      throws ImpossibleBallException {
    Ball ball = new Ball(radius, ballColor, material);
    return removeBall(ball);
  }

  public void empty() {
    balls = new ArrayList<>();
  }

  @Override
  public String toString() {
    return String.format(
        "Basket with effective volume %.2f and max load %.2f, broken is %b%n",
        effectiveVolume, loadLimit, isBroken);
  }
}
