package org.andestech.learning.rfb19.g4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreditAccTest {

    private static Customer testCustomer;
    private static CreditAccount testCreditAccount;
    private static final double INIT_BALANCE  = 100;
    private static final double LIM_CRD_REST  = 50;



    @BeforeClass // one time
    public static void initTestCustomer(){
        testCustomer = new Customer("Name", "Surname", 44, "Mohovaya", true);
    }

    @Before // every test
    public void initTestAccount(){
        testCreditAccount = CreditAccount.create(2, INIT_BALANCE, testCustomer );
    }

    @Test
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = INIT_BALANCE + testAmount;
        testCreditAccount.putMoney( testAmount );
        Assert.assertEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    public void withdrawalPositiveTest(){
        double testwithdrawal = 10;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testCreditAccount.withdrawal( testwithdrawal );
        Assert.assertEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    public void withdrawalNegativeTest(){
        double testwithdrawal = LIM_CRD_REST;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testCreditAccount.withdrawal( testwithdrawal );
        Assert.assertNotEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }








}
