package org.andestech.learning.rfb19.g4;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;



public class DebitAccTest {


    private static Customer testCustomer;
    private static DebitAccount testDebitAccount;
    private static final double INIT_BALANCE  = 100;
    private static final double LIM_DBT_REST = 50; // лимит остатка




    @BeforeClass // one time
    public static void initTestCustomer(){
        testCustomer = new Customer("Name", "Surname", 44, "Mohovaya", true);
    }

    @Before // every test
    public void initTestAccount(){
        testDebitAccount = new DebitAccount(1, INIT_BALANCE, testCustomer);
    }


    @Test
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = INIT_BALANCE + testAmount;
        testDebitAccount.putMoney( testAmount );
        Assert.assertEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    public void withdrawalPositiveTest(){
        double testwithdrawal = 10;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testDebitAccount.withdrawal( testwithdrawal );
        Assert.assertEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    public void withdrawalNegativeTest(){
        double testwithdrawal = LIM_DBT_REST;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testDebitAccount.withdrawal( testwithdrawal );
        Assert.assertNotEquals( testDebitAccount.getBalance(), expectedAmount,0 );
    }





}
