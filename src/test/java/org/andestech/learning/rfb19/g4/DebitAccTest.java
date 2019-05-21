package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DebitAccTest {

    static Customer customer;
    DebitAccount account;

    @BeforeClass
    public static void init() {
        customer = new Customer("Иван", "Иванов", "ул. Ленина, 32", 32, true);
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest() throws DebitAccountException {
        account = new DebitAccount(1, customer);
        Assert.assertNotNull(account);
    }

    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest() throws DebitAccountException {
        try {
            account = new DebitAccount(1, customer, 100_000_000);
        }
        catch (DebitAccountException e) {}
        Assert.assertNull(account);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest() throws DebitAccountException {
        account = new DebitAccount(1, customer);
        account.putMoney(100);
        Assert.assertEquals("", account.getBalance(), 100, 0);
    }

    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest() throws DebitAccountException {
        try {
            account = new DebitAccount(1, customer);
            account.putMoney(100_000_000);
        }
        catch (DebitAccountException e) {}
        Assert.assertNotEquals("", account.getBalance(), 100_000_000, 0);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest() throws DebitAccountException {
        account = new DebitAccount(1, customer);
        account.putMoney(1000);
        account.withdrawal(100);
        Assert.assertEquals("", account.getBalance(), 900, 0);
    }

    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest() throws DebitAccountException {
        try {
            account = new DebitAccount(1, customer);
            account.putMoney(1000);
            account.withdrawal(10000);
        }
        catch (DebitAccountException e) {}
        Assert.assertEquals("", account.getBalance(), 1000, 0);
    }
}
