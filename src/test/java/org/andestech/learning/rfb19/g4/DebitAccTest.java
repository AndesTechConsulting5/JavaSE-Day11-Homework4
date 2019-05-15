package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.AccountException;
import org.andestech.learning.rfb19.g4.homework3.Customer;
import org.andestech.learning.rfb19.g4.homework3.CustomerException;
import org.andestech.learning.rfb19.g4.homework3.DebitAccount;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class DebitAccTest {


    private static Customer client;
    private static DebitAccount debit;

    @BeforeClass
    public static void init() {
        debit = new DebitAccount();
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest() throws CustomerException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 20);
        //открываем дебетовый счет с суммой 100 клиенту
        debit.debitAccount(1, 100, client);
    }

    @Test(expected = CustomerException.class)
    @Category(INegativeTest.class)
    public void createAccountNegativeTest() throws CustomerException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 17);
        //открываем дебетовый счет с суммой 100 клиенту
        debit.debitAccount(1, 100, client);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest() throws AccountException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 18);
        //пополняем дебетовый счет клиенту
        debit.putMoney(500);

    }

    @Test(expected = AccountException.class)
    @Category(INegativeTest.class)
    public void putNegativeTest() throws AccountException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 18);
        //пополняем дебетовый счет клиенту
        debit.putMoney(50);

    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest() throws AccountException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 18);
        //пополняем дебетовый счет клиенту
        debit.putMoney(500);
        //снимает деньги с дебетового счета у клиента
        debit.withdrawal(100);

    }

    @Test(expected = AccountException.class)
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest() throws AccountException {
        //задан клиент
        client = new Customer("Иван", "Петров", "ул.Ленина, д.1", 18);
        //пополняем дебетовый счет клиенту
        debit.putMoney(500);
        //снимает деньги с дебетового счета у клиента
        debit.withdrawal(50);
    }

}
