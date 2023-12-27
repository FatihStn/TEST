package test.java;

import main.java.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount bankAccount = new BankAccount();
    static int testNumber = 0;
    @BeforeAll
    static void testStart(){
        System.out.println("-------Test Started!--------");
    }
    @BeforeEach
    void caseStart(){
        testNumber++;
        System.out.println("Number "+testNumber+" test case started");
    }
    @AfterEach
    void caseFinish(){
        System.out.println("Number "+testNumber+" test case finished");
    }
    @AfterAll
    static void testFinish(){
        System.out.println("-------Test Finished!--------");

    }

    @Test
    void depositIntoAccount(){
       bankAccount.deposit(50);
       assertEquals(50,bankAccount.getBalance());
    }
    @Test
    void withdrawFromAccountWithSufficientFunds(){
        bankAccount.deposit(50);
        bankAccount.withdraw(20);
        assertEquals(30,bankAccount.getBalance());
    }
    @Test
    void withdrawFromAccountExceedingBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(120);
        });


    }
    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-1);
        });

    }

    @Test
    void testWithdrawNegativeAmount() {
        bankAccount.deposit(3);
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-1);
        });


    }

    @Test
    void testTransactionHistory() {
        bankAccount.deposit(100);
        assertEquals("Deposited: $100.0", bankAccount.getAccountHistory());
    }

}
