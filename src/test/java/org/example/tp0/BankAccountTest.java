package org.example.tp0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit_ShouldIncreaseBalance_WhenAmountIsPositive() {
        BankAccount account = new BankAccount(1000, 0.05);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void deposit_ShouldThrowException_WhenAmountIsNegative() {
        BankAccount account = new BankAccount(1000, 0.05);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-500);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void withdraw_ShouldDecreaseBalance_WhenAmountIsPositiveAndSufficient() {
        BankAccount account = new BankAccount(1000, 0.05);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdraw_ShouldThrowException_WhenAmountIsNegative() {
        BankAccount account = new BankAccount(1000, 0.05);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-500);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void withdraw_ShouldThrowException_WhenAmountIsGreaterThanBalance() {
        BankAccount account = new BankAccount(1000, 0.05);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void transfer_ShouldTransferMoneyBetweenAccounts_WhenSufficientBalance() {
        BankAccount account1 = new BankAccount(1000, 0.05);
        BankAccount account2 = new BankAccount(500, 0.05);

        account1.transfer(300, account2);
        assertEquals(700, account1.getBalance()); // Account 1 balance after transfer
        assertEquals(800, account2.getBalance()); // Account 2 balance after transfer
    }

    @Test
    void transfer_ShouldThrowException_WhenAmountIsGreaterThanBalance() {
        BankAccount account1 = new BankAccount(1000, 0.05);
        BankAccount account2 = new BankAccount(500, 0.05);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            account1.transfer(1500, account2);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void transfer_ShouldThrowException_WhenOtherAccountIsNull() {
        BankAccount account = new BankAccount(1000, 0.05);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            account.transfer(500, null);
        });
        assertEquals("Other account must not be null", exception.getMessage());
    }

    @Test
    void addInterest_ShouldIncreaseBalance_WhenInterestIsAdded() {
        BankAccount account = new BankAccount(1000, 0.05);
        account.addInterest();
        assertEquals(1050, account.getBalance()); // Balance after 5% interest
    }

    @Test
    void getBalance_ShouldReturnCorrectBalance() {
        BankAccount account = new BankAccount(1000, 0.05);
        assertEquals(1000, account.getBalance());
    }
}
