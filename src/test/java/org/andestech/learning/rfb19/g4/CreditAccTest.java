package org.andestech.learning.rfb19.g4;

import org.junit.*;
import org.junit.experimental.categories.Category;

public class CreditAccTest {

    private static Customer testTrueCustomer;
    private static Customer testFalseCustomer;
    private static CreditAccount testCreditAccount;

    @BeforeClass
    public static void initTestCustomer(){
        testTrueCustomer = new Customer("Vasyly", "Dulin", 50, "ul. Valovaya");
        testFalseCustomer = new Customer("Vasyly", "Dulin", 13, "ul. Valovaya");
    }
    @Before
    public void initTestAccount(){
        testCreditAccount = CreditAccount.createClearCreditAccount();
    }

    @Test
    @Category(IPositiveTest.class)
    public void createAccountPositiveTest(){
        CreditAccount creditAccount = CreditAccount.createCreditAccount(true, testTrueCustomer.getAge(), testTrueCustomer, 1500, 1);
        Assert.assertNotNull(creditAccount);
    }

    @Test
    @Category(INegativeTest.class)
    public void createAccountNegativeTest(){
        CreditAccount creditAccount = CreditAccount.createCreditAccount(true,testFalseCustomer.getAge(), testFalseCustomer,10,2);
        Assert.assertNull(creditAccount);
    }

    @Test
    @Category(IPositiveTest.class)
    public void putPositiveTest(){
        double testAmount = 10;
        double expectedAmount = 10;
        testCreditAccount.putMoney(testAmount);
        Assert.assertEquals(testCreditAccount.getBalance(), expectedAmount, 1e-4);
    }

    @Test
    @Category(INegativeTest.class)
    public void putNegativeTest(){
        double testAmount = 10;
        double expectedAmount = 5;
        testCreditAccount.putMoney(testAmount);
        Assert.assertNotEquals(testCreditAccount.getBalance(), expectedAmount,1e-4);
    }

    @Test
    @Category(IPositiveTest.class)
    public void withdrawalPositiveTest(){
        double testAmount = 5;
        double expectedAmount = -5;
        testCreditAccount.withdrawal(testAmount);
        Assert.assertEquals(testCreditAccount.getBalance(), expectedAmount,1e-4);
    }

    @Test
    @Category(INegativeTest.class)
    public void withdrawalNegativeTest(){
        double testAmount = 5;
        double expectedAmount = -2;
        testCreditAccount.withdrawal(testAmount);
        Assert.assertNotEquals(testCreditAccount.getBalance(), expectedAmount,1e-4);
    }

}
