package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class CreditAccTest {

    private static Customer client;

    @BeforeClass
    public static void init() {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 20);
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest() throws CreditAccountException, CustomerException {
        //открываем кредитный счет с суммой 90 клиенту
        CreditAccount.createAccount(2, 90, client);
    }

    @Test(expected = CreditAccountException.class)
    @Category(INegativeTest.class)
    public void createAccountNegativeTest() throws CreditAccountException, CustomerException {
        //открываем кредитный счет с суммой -90 клиенту
        CreditAccount.createAccount(2, -90, client);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest() throws CreditAccountException, CustomerException, AccountException {
        //открываем кредитный счет с суммой 1000 клиенту
        CreditAccount.createAccount(2, 1000, client);
        //пополняем кредитный счет у клиента
        CreditAccount createAccount = CreditAccount.create();
        createAccount.putMoney(100);
    }

    @Test(expected = AccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeTest() throws AccountException, CreditAccountException, CustomerException {
        //открываем кредитный счет с суммой 1000 клиенту
        CreditAccount.createAccount(2, 1000, client);
        //пополняем кредитный счет у клиента
        CreditAccount createAccount = CreditAccount.create();
        createAccount.putMoney(10);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest() throws CreditAccountException, CustomerException, AccountException {
        //открываем кредитный счет с суммой 1000 клиенту
        CreditAccount.createAccount(2, 1000, client);
        //снимаем деньги с кредитного счета у клиента
        CreditAccount createAccount = CreditAccount.create();
        createAccount.withdrawal(100);
    }

    @Test(expected = AccountException.class)
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest() throws CreditAccountException, CustomerException, AccountException {
        //открываем кредитный счет с суммой 1000 клиенту
        CreditAccount.createAccount(2, 1000, client);
        //снимаем деньги с кредитного счета у клиента
        CreditAccount createAccount = CreditAccount.create();
        createAccount.withdrawal(10);
    }

}
