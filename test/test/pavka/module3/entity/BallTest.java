package test.pavka.module3.entity;

import by.pavka.module3.entity.Ball;
import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Material;
import by.pavka.module3.exception.ImpossibleBallException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class BallTest {
  @Test (expectedExceptions = ImpossibleBallException.class, expectedExceptionsMessageRegExp =
          "Radius must be positive")
  public void ConstructorTest1() throws ImpossibleBallException {
    Ball ball = new Ball(-1, BallColor.BLUE, Material.RUBBER);
  }

  @Test
  public void ConstructorTest2() {
    try {
      Ball ball = new Ball(1, null, Material.FELT);
      fail("Exception should be thrown");
    } catch (ImpossibleBallException e) {
      Assert.assertEquals(e.getMessage(), "Color can't be null");
    }
  }

  @Test
  public void ConstructorTest3() {
    try {
      Ball ball = new Ball(1, BallColor.BLUE, null);
      fail("Exception should be thrown");
    } catch (ImpossibleBallException e) {
      Assert.assertEquals(e.getMessage(), "Material can't be null");
    }
  }

  @Test
  public void ConstructorTest4() {
    try {
      Ball ball = new Ball(4.1, BallColor.BLUE, Material.IRON);
      double expectedVolume = 4.0 / 3.0 * Math.PI * Math.pow(4.1, 3);
      Assert.assertEquals(ball.calculateVolume(), expectedVolume);
    } catch (ImpossibleBallException e) {
      fail("The data are valid, no exception");
    }
  }

}
