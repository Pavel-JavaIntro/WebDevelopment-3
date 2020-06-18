package by.pavka.module3.console;

import by.pavka.module3.entity.BallColor;
import by.pavka.module3.entity.Basket;

public class ConsolePrinter {
  public static void printLoad(Basket basket, double weight) {
    System.out.printf("Weight of balls in %s is %.2f%n", basket, weight);
  }

  public static void printCount(Basket basket, BallColor ballColor, int count) {
    System.out.printf("The basket %s contains %d balls of color %s%n", basket, count, ballColor);
  }

  public static void printNullBasket() {
    System.out.println("Basket can't be null");
  }
}
