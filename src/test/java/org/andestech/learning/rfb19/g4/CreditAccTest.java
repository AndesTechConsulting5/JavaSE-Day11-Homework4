package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditAccTest {
    static Customer customerGood;
    static Customer customerBad;
    CreditAccount account;

    @BeforeClass
    public static void init() {
        customerGood = new Customer("Иван", "Иванов", "ул. Ленина, 32", 32, true);
        customerBad = new Customer("Петр", "Петров", "ул. Коммунистическая, 8", 48, false);
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest() throws AccountException {
        account = CreditAccount.createAccount(1, customerGood, 10_000);
        Assert.assertNotNull(account);
    }

    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest() {
        try {
            account = CreditAccount.createAccount(1, customerBad, 10_000);
        }
        catch (AccountException e) {}
        Assert.assertNull(account);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest() throws AccountException {
        account = CreditAccount.createAccount(1, customerGood, 10_000);
        account.putMoney(1_000);
        Assert.assertEquals("", account.getBalance(), 11_000, 0);
    }

    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest() {
        try {
            account = CreditAccount.createAccount(1, customerGood, 10_000);
            account.putMoney(100_000_000);
        }
        catch (AccountException e) {}
        Assert.assertEquals("", account.getBalance(), 10_000, 0);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest() throws AccountException {
        account = CreditAccount.createAccount(1, customerGood, 10_000);
        account.withdrawal(1_000);
        Assert.assertEquals("", account.getBalance(), 9_000, 0);
    }

    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest() {
        try {
            account = CreditAccount.createAccount(1, customerGood, 10_000);
            account.withdrawal(100_000);
        }
        catch (AccountException e) {}
        Assert.assertEquals("", account.getBalance(), 10_000, 0);
    }
}
