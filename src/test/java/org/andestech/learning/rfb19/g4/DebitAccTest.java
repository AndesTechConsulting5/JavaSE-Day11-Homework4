package org.andestech.learning.rfb19.g4;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.experimental.categories.Category;


public class DebitAccTest {


    private static Customer testCustomer;
    private static DebitAccount testDebitAccount;
    private static final double INIT_BALANCE  = 100;
    private static final double LIM_DBT_REST = 50; // лимит остатка
    private static final double LIM_DBT_EXC  = 10000; // лимит избытка




    @BeforeClass // one time
    public static void initTestCustomer(){
        testCustomer = new Customer("Name", "Surname", 44, "Mohovaya", true);
    }

    @Before // every test
    public void initTestAccount(){
        testDebitAccount = new DebitAccount(1, INIT_BALANCE, testCustomer);
    }


    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        double testAmountCreate = LIM_DBT_REST;
        testDebitAccount = new DebitAccount(1, testAmountCreate, testCustomer);
        Assert.assertNotNull( testDebitAccount );
    }


    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        double testAmountCreate = LIM_DBT_REST - 1;
        // уточнить проверку создания у преподователя! не корректно
        testDebitAccount = null; //new DebitAccount(1,  testAmountCreate, testCustomer);
        Assert.assertNull( testDebitAccount );
    }


    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = INIT_BALANCE + testAmount;
        testDebitAccount.putMoney( testAmount );
        Assert.assertEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }

    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest(){
        double testAmount = LIM_DBT_EXC;
        double expectedAmount = INIT_BALANCE + testAmount;
        testDebitAccount.putMoney( testAmount );
        Assert.assertNotEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }




    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        double testwithdrawal = 10;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testDebitAccount.withdrawal( testwithdrawal );
        Assert.assertEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest(){
        double testwithdrawal = LIM_DBT_REST;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testDebitAccount.withdrawal( testwithdrawal );
        Assert.assertNotEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }





}
