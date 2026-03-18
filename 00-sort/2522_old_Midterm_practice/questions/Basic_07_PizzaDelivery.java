package org.bcit.comp2522.winter2023.midterm_takeup.questions;

import java.util.ArrayList;
import java.util.List;


/**
 * The Basic_07_PizzaDelivery class is a version of the original Basic_07_GitHubManager question.
 * This question tests the ability to trace code by simulating a pizza delivery process, including
 * order preparation, delivery, and receiving payment.
 *
 * In the original question, the basic idea was to create a class called Basic_07_GitHubManager
 * that manages a local repository and a remote repository, adding and pushing files between them.
 * The task was to trace the code and find the sequence of method calls.
 * In this question, we simulate a pizza delivery process by creating three classes:
 * Kitchen, Delivery, and Payment. The Kitchen class is responsible for preparing the order,
 * the Delivery class is responsible for delivering the order, and the Payment class is responsible
 * for receiving payment.
 *
 * The main task is to trace the code and find the sequence of method calls
 * initiated by the execution of pizzaOrder.processOrder() and payment.receivePayment(order.getTotalCost()).
 * By tracing the code, the student learns to understand the flow of execution and the interactions
 * between different classes and methods in a program.
 * */
 */
public class Basic_07_PizzaDelivery {

  // Idea: tests your ability to trace code

  public static void main(String[] args) {
    Basic_07_PizzaDelivery pizzaDelivery = new Basic_07_PizzaDelivery();
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
