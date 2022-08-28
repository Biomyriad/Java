package javaFund.cafeBusiness;

import java.util.ArrayList;

public class CafeUtil {

  public int getStreakGoal() {
    int total = 0;
    for(int idx = 1; idx <= 10; idx++) {
      total = total + 1;
    }
    return total;
  }

  public double getOrderTotal(double[] prices) {
    double total = 0;
    for(int idx = 0; idx <= prices.length - 1; idx++) {
      total = total + prices[idx];
    }
    return total;
  }

  public void displayMenu(ArrayList<String> menuItems) {
    for(int idx = 0; idx <= menuItems.size() - 1; idx++) {
      System.out.println(idx + " : " + menuItems.get(idx));
    }
  }

  public void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();
    System.out.println("Hello, " + userName);
    System.out.printf("There are " + customers.size() + " people ahead of you.");
    customers.add(userName);
    System.out.println(customers);
  }
}
