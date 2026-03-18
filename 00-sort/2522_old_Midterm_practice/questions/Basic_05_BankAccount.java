package org.bcit.comp2522.winter2023.midterm_takeup.questions;

/**
 *
 * The Basic_05_BankAccount class is a version of the original
 * Basic_05_Door question. This question tests the ability to create and use
 * exceptions by managing a bank account with withdrawal and deposit operations.
 *
 *  * In the original question, the basic idea was to create a class called Basic_05_Door
 *  * that manages a door with a lock and a key. The door can be opened and closed, and
 *  * the lock can be locked and unlocked. The door can only be opened if the lock is
 *  * unlocked, and the lock can only be unlocked if the key is inserted.
 *
 * In this question, I created two new exceptions called Basic_05_OverdraftException
 * and Basic_05_NegativeDepositException. Basic_05_OverdraftException is thrown
 * when a withdrawal operation results in a negative balance, while Basic_05_NegativeDepositException
 * is thrown when attempting to deposit a negative amount.
 *
 * The Basic_05_BankAccount class manages the account balance and enforces these rules
 * using the custom exceptions.
 *
 */
public class Basic_05_BankAccount {
  double balance;

  public Basic_05_BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    // TODO 1: Create a new exception called Basic_05_NegativeDepositException
    // and throw it if this is called with a negative amount
    // otherwise, add the amount to the balance
  }

  public void withdraw(double amount) {
    // TODO 2: Create a new exception called Basic_05_OverdraftException
    // and throw it if this is called when the withdrawal results in a negative balance
    // otherwise, subtract the amount from the balance
  }

  public static void main(String[] args) {
    // Note that you may need to wrap the below in try/catch blocks
    Basic_05_BankAccount account = new Basic_05_BankAccount(500);
    account.deposit(-100); // should throw an exception since it is a negative deposit
    account.deposit(300); // should be OK
    account.withdraw(900); // should throw an exception since it would result in a negative balance
    account.withdraw(400); // should be OK
  }
}
