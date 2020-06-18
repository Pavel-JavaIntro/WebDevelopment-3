package by.pavka.module3;

import by.pavka.module3.entity.Ball;
import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Basket;
import by.pavka.module3.entity.Material;
import by.pavka.module3.exception.ImpossibleBallException;
import by.pavka.module3.service.BasketManager;

public class Main {

    public static void main(String[] args) {
      try {
        Ball ball1 = new Ball(2, BallColor.RED, Material.FELT);
        Basket basket = new Basket(48, 629);
        basket.addBall(ball1);
        basket.addBall(ball1);
        basket.addBall(ball1);
        basket.removeBall(2, BallColor.RED, Material.FELT);
        System.out.println((new BasketManager().obtainWeight(basket)));
        System.out.println((new BasketManager()).countBalls(null, BallColor.RED));
      } catch (ImpossibleBallException e) {
        e.printStackTrace();
      }
    }
}
