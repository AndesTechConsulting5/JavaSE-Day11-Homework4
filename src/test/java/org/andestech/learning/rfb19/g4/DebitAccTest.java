package org.andestech.learning.rfb19.g4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DebitAccTest {

    private static Customer testCustomer;
    private static DebitAccount testDebitAccount;

    @BeforeClass
    public static void initTestCustomer(){
        testCustomer = new Customer("Vasyly", "Dulin", 50, "ul. Valovaya");
    }
    @Before
    public void initTestAccount(){
        testDebitAccount = new DebitAccount(1, testCustomer, 100);
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        DebitAccount debitAccount = new DebitAccount(1, testCustomer, 100);
        Assert.assertNotNull(debitAccount);
    }

    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        DebitAccount debitAccount = null;
        Assert.assertNull(debitAccount);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = 110;
        testDebitAccount.putMoney(testAmount);
        Assert.assertEquals(testDebitAccount.getBalance(), expectedAmount, 1e-4);
    }

    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest(){
        double testAmount = 10;
        double expectedAmount = 105;
        testDebitAccount.putMoney(testAmount);
        Assert.assertNotEquals(testDebitAccount.getBalance(), expectedAmount,1e-4);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        double testAmount = 5;
        double expectedAmount = 95;
        testDebitAccount.withdrawal(testAmount);
        Assert.assertEquals(testDebitAccount.getBalance(), expectedAmount,1e-4);
    }

    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest(){
        double testAmount = 5;
        double expectedAmount = 100;
        testDebitAccount.withdrawal(testAmount);
        Assert.assertNotEquals(testDebitAccount.getBalance(), expectedAmount,1e-4);
    }

}
