package by.pavka.module3.service;

import by.pavka.module3.console.ConsolePrinter;
import by.pavka.module3.entity.Ball;
import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Basket;

import java.util.List;

public class BasketManager {
  public double obtainWeight(Basket basket) {
    if (basket == null) {
      ConsolePrinter.printNullBasket();
      return -1;
    }
    double weight = basket.calculateLoad();
    ConsolePrinter.printLoad(basket, weight);
    return basket.calculateLoad();
  }

  public int countBalls(Basket basket, BallColor ballColor) {
    int count = -1;
    if (basket != null) {
      count++;
      List<Ball> balls = basket.getBalls();
      for (Ball ball : balls) {
        if (ball.getBallColor() == ballColor) {
          count++;
        }
      }
    }
    ConsolePrinter.printCount(basket, ballColor, count);
    return count;
  }
}
