package test.pavka.module3.service;

import by.pavka.module3.entity.Ball;
import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Basket;
import by.pavka.module3.entity.Material;
import by.pavka.module3.exception.ImpossibleBallException;
import by.pavka.module3.service.BasketManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class BasketManagerTest {
  private BasketManager basketManager = new BasketManager();

  @Test
  public void countRedBallTest1() {
    Basket basket = new Basket(100, 200);
    Ball ball = null;
    try {
      ball = new Ball(1, BallColor.RED, Material.RUBBER);
    } catch (ImpossibleBallException e) {
      fail("No exception here");
    }
    basket.addBall(ball);
    basket.addBall(ball);
    basket.addBall(ball);
    basket.removeBall(ball);

    int actual = basketManager.countBalls(basket, BallColor.RED);
    int expected = 2;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void countRedBallTest2() {
    int actual = basketManager.countBalls(null, BallColor.RED);
    int expected = -1;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void weightTest1() {
    Basket basket = new Basket(260, 200);
    try {
      basket.addBall(1, BallColor.YELLOW, Material.RUBBER);
      basket.addBall(1.5, BallColor.YELLOW, Material.RUBBER);
      basket.addBall(2, BallColor.YELLOW, Material.RUBBER);
    } catch (ImpossibleBallException e) {
      fail("No exception here");
    }
    double actual = basketManager.obtainWeight(basket);
    double expected = 0.8 * 4 * Math.PI / 3 * (Math.pow(1, 3) + Math.pow(1.5, 3) + Math.pow(2, 3));
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void weightTest2() {
    double actual = basketManager.obtainWeight(null);
    double expected = -1;
    Assert.assertEquals(actual, expected);
  }
}
