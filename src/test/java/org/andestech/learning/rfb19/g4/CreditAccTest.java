package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.CreditAccount;
import org.andestech.learning.rfb19.g4.homework3.exception.CreditAccountException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.andestech.learning.rfb19.g4.TestData.*;
import static org.junit.Assert.*;

public class CreditAccTest {

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        assertNotNull(createdCreditAccount);
        assertEquals(CUSTOMER_VALID, createdCreditAccount.getCustomer());
    }

    @Test(expected = CreditAccountException.class)
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        CreditAccount.createCreditAccount(2, CUSTOMER_INVALID_AGE);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        double delta = 1000.56;
        createdCreditAccount.putMoney(delta);
        assertEquals(INITIAL_CREDIT_BALANCE + delta, createdCreditAccount.getBalance(), 0.000000000000000001);
    }

    @Test(expected = CreditAccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeDeltaTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        double delta = -100.0;
        createdCreditAccount.putMoney(delta);
    }

    @Test(expected = CreditAccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeBalanceTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        createdCreditAccount.putMoney(MAX_CREDIT_BALANCE);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        createdCreditAccount.putMoney(500_000);
        createdCreditAccount.withdrawal(250_000);
        assertEquals(INITIAL_CREDIT_BALANCE + 250_000, createdCreditAccount.getBalance(), 0.000000000000000001);
    }

    @Test(expected = CreditAccountException.class)
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest(){
        CreditAccount createdCreditAccount = CreditAccount.createCreditAccount(1, CUSTOMER_VALID);
        createdCreditAccount.withdrawal(100_000);
    }
}
