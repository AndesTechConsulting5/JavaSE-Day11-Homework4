package org.andestech.learning.rfb19.g4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditAccTest {

    private static Customer testCustomer;
    private static CreditAccount testCreditAccount;
    private static final double INIT_BALANCE  = 100;
    private static final double LIM_CRD_REST  = 50;
    private static final double LIM_CRD_EXC = 50000;
    private static Customer testCustomerYoung;


    @BeforeClass // one time
    public static void initTestCustomer(){
        testCustomer = new Customer("Name", "Surname", 44, "Mohovaya", true);
    }

    @BeforeClass // one time
    public static void initTestCustomerYoung(){
        testCustomerYoung = new Customer("Name", "Surname", 11, "Mohovaya", true);
    }



    @Before // every test
    public void initTestAccount(){
        testCreditAccount = CreditAccount.create(2, INIT_BALANCE, testCustomer );
    }


    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        testCreditAccount = CreditAccount.create(2, INIT_BALANCE, testCustomer );
        Assert.assertNotNull( testCreditAccount );
    }


    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        //testCustomer.setAge( 10 );
        testCreditAccount = CreditAccount.create(2, INIT_BALANCE, testCustomerYoung );
        Assert.assertNull( testCreditAccount );
    }



    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = INIT_BALANCE + testAmount;
        testCreditAccount.putMoney( testAmount );
        Assert.assertEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest(){
        double testAmount = LIM_CRD_EXC;
        double expectedAmount = LIM_CRD_EXC ;
        testCreditAccount.putMoney( testAmount );
        Assert.assertNotEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        double testwithdrawal = 10;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testCreditAccount.withdrawal( testwithdrawal );
        Assert.assertEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }


    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest(){
        double testwithdrawal = INIT_BALANCE;
        double expectedAmount = INIT_BALANCE - testwithdrawal;
        testCreditAccount.withdrawal( testwithdrawal );
        Assert.assertNotEquals( testCreditAccount.getBalance(), expectedAmount,0 );
    }








}
