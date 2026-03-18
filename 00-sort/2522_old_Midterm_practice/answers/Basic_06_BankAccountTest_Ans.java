package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Basic_06_BankAccountTest_Ans {
  private Basic_05_BankAccount_Ans bankAccount;

  @BeforeEach
  void setUp() {
    bankAccount = new Basic_05_BankAccount_Ans();
  }

  @Test
  void testDepositValidAmount() {
    bankAccount.deposit(100);
    assertEquals(100, bankAccount.getBalance());
  }

  @Test
  void testDepositNegativeAmountThrowsException() {
    assertThrows(Basic_05_NegativeDepositException.class, () -> bankAccount.deposit(-50));
  }

  @Test
  void testWithdrawValidAmount() {
    bankAccount.deposit(100);
    bankAccount.withdraw(50);
    assertEquals(50, bankAccount.getBalance());
  }

  @Test
  void testWithdrawOverdraftThrowsException() {
    bankAccount.deposit(100);
    assertThrows(Basic_05_OverdraftException.class, () -> bankAccount.withdraw(150));
  }
}




}




