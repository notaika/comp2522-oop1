package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Basic_05_BankAccount_Ans {
  double balance;

  public Basic_05_BankAccount_Ans() {
    this.balance = 0;
  }

  public void deposit(double amount) throws Basic_05_NegativeDepositException {
    if (amount < 0) {
      throw new Basic_05_NegativeDepositException("Cannot deposit a negative amount.");
    }
    balance += amount;
  }

  public void withdraw(double amount) throws Basic_05_OverdraftException {
    if (amount > balance) {
      throw new Basic_05_OverdraftException("Cannot withdraw more than the available balance.");
    }
    balance -= amount;
  }

  public static void main(String[] args) {
    Basic_05_BankAccount_Ans bankAccount = new Basic_05_BankAccount_Ans();

    try {
      bankAccount.deposit(1000);
      System.out.println("Deposit successful. New balance: " + bankAccount.balance);

      bankAccount.withdraw(500);
      System.out.println("Withdrawal successful. New balance: " + bankAccount.balance);

      bankAccount.withdraw(600);
      System.out.println("Withdrawal successful. New balance: " + bankAccount.balance);
    } catch (Basic_05_OverdraftException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (Basic_05_NegativeDepositException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}

