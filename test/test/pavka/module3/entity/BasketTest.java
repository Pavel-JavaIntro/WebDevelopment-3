package test.pavka.module3.entity;

import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Basket;
import by.pavka.module3.entity.Material;
import by.pavka.module3.exception.ImpossibleBallException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class BasketTest {
  @Test
  public void calculateWeightTest1() {
    Basket basket = new Basket(100, 100);
    try {
      basket.addBall(3, BallColor.BLUE, Material.FELT);
      basket.addBall(1, BallColor.BLUE, Material.RUBBER);
      basket.addBall(0.5, BallColor.YELLOW, Material.IRON);
    } catch (ImpossibleBallException e) {
      fail("No exception allowed");
    }
    double actual = basket.calculateLoad();
    double expected =
        Material.RUBBER.getDensity() * 4 * Math.PI * Math.pow(1, 3) / 3
            + Material.IRON.getDensity() * 4 * Math.PI * Math.pow(0.5, 3) / 3;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void calculateWeightTest2() {
    Basket basket = new Basket(200, 100);
    try {
      basket.addBall(3, BallColor.BLUE, Material.FELT);
      basket.addBall(1, BallColor.BLUE, Material.RUBBER);
      basket.addBall(0.5, BallColor.YELLOW, Material.IRON);
    } catch (ImpossibleBallException e) {
      fail("No exception allowed");
    }
    double actual = basket.calculateLoad();
    double expected =
        Material.FELT.getDensity() * 4 * Math.PI * Math.pow(3, 3) / 3
            + Material.RUBBER.getDensity() * 4 * Math.PI * Math.pow(1, 3) / 3
            + Material.IRON.getDensity() * 4 * Math.PI * Math.pow(0.5, 3) / 3;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void ballListTest() {
    Basket basket = new Basket(200, 100);
    try {
      basket.addBall(3, BallColor.BLUE, Material.FELT);
      basket.addBall(1, BallColor.BLUE, Material.RUBBER);
      basket.removeBall(0.5, BallColor.YELLOW, Material.IRON);
      basket.addBall(null);
      basket.removeBall(3, BallColor.BLUE, Material.FELT);
    } catch (ImpossibleBallException e) {
      fail("No exception allowed");
    }
    int actual = basket.getBalls().size();
    int expected = 1;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void breakTest() {
    Basket basket = new Basket(100, 100);
    try {
      basket.addBall(2, BallColor.RED, Material.IRON);
    } catch (ImpossibleBallException e) {
      fail("No exception allowed");
    }
    boolean actual = basket.isBroken();
    Assert.assertTrue(actual);
  }
}
