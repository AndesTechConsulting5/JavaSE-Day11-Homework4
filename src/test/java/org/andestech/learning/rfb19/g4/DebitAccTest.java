package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.CreditAccount;
import org.andestech.learning.rfb19.g4.homework3.DebitAccount;
import org.andestech.learning.rfb19.g4.homework3.exception.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.exception.DebitAccountException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.andestech.learning.rfb19.g4.TestData.*;
import static org.andestech.learning.rfb19.g4.TestData.CUSTOMER_VALID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Homework 4
 */
public class DebitAccTest
{
    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        assertNotNull(debitAccount);
        assertEquals(CUSTOMER_VALID, debitAccount.getCustomer());
    }

    @Test(expected = DebitAccountException.class)
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        DebitAccount debitAccount = new DebitAccount(1, null);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        double delta = 1000.56;
        debitAccount.putMoney(delta);
        assertEquals(INITIAL_DEBIT_BALANCE + delta, debitAccount.getBalance(), 0.000000000000000001);
    }

    @Test(expected = DebitAccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeDeltaTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        double delta = -100.0;
        debitAccount.putMoney(delta);
    }

    @Test(expected = DebitAccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeBalanceTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        debitAccount.putMoney(MAX_DEBIT_BALANCE);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        debitAccount.putMoney(500_000);
        debitAccount.withdrawal(250_000);
        assertEquals(INITIAL_DEBIT_BALANCE + 250_000, debitAccount.getBalance(), 0.000000000000000001);
    }

    @Test(expected = DebitAccountException.class)
    @Category(IPositiveTest.class)
    public void withdrawalNegativeTest(){
        DebitAccount debitAccount = new DebitAccount(1, CUSTOMER_VALID);
        debitAccount.withdrawal(100_000);
    }

}
