package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import java.util.ArrayList;
import java.util.List;

public class Basic_07_PizzaDelivery_Ans {

  // Idea: tests your ability to trace code

  public static void main(String[] args) {
    Basic_07_PizzaDelivery_Ans pizzaDelivery = new Basic_07_PizzaDelivery_Ans();
    Kitchen kitchen = new Kitchen();
    Delivery delivery = new Delivery();
    Payment payment = new Payment();
    Order order = new Order();
    order.addPizza("Pepperoni");
    order.addPizza("Margarita");

    // TODO 1: Trace the code from the next line and write down in a comment
    // directly below this TODO the exact sequence of method calls that
    // kitchen.prepareOrder(order) and payment.receivePayment(order.getTotalCost())
    // initiates in the correct order.
    /*
// 1. kitchen.prepareOrder(order) -> Kitchen.prepareOrder(Order order)
// 2. order.getPizzas() -> Order.getPizzas()
// 3. delivery.deliverOrder(order) -> Delivery.deliverOrder(Order order)
// 4. order.setDelivered(true) -> Order.setDelivered(boolean delivered)
// 5. payment.receivePayment(order.getTotalCost()) -> Payment.receivePayment(double amount)
*/

    kitchen.prepareOrder(order);
    delivery.deliverOrder(order);
    payment.receivePayment(order.getTotalCost());
  }

  private static class Kitchen {
    public void prepareOrder(Order order) {
      for (String pizza : order.getPizzas()) {
        System.out.println("Preparing " + pizza + " pizza");
      }
    }
  }

  private static class Delivery {
    public void deliverOrder(Order order) {
      System.out.println("Delivering order...");
      order.setDelivered(true);
    }
  }

  private static class Payment {
    public void receivePayment(double amount) {
      System.out.println("Received payment: $" + amount);
    }
  }

  private static class Order {
    private List<String> pizzas;
    private boolean delivered;

    public Order() {
      pizzas = new ArrayList<>();
      delivered = false;
    }

    public void addPizza(String pizza) {
      pizzas.add(pizza);
    }

    public List<String> getPizzas() {
      return pizzas;
    }

    public double getTotalCost() {
      return pizzas.size() * 10.0;
    }

    public void setDelivered(boolean delivered) {
      this.delivered = delivered;
    }
  }
}
