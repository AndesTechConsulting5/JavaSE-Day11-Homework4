package org.andestech.learning.rfb19.g4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditAccTest {

	static Customer client;
@BeforeClass
 public static void createClient(){
	client = new Customer("Smith","Will","Brooklyn",50);


}

	@Test
	@Category(IPositiveTest.class)
public void createAccountPositiveTest(){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CreditAccount.createAccount(2,1000,client);
}
	static Customer client2;
	@BeforeClass

	public static void createClient2(){
		client2 = new Customer("Smith","Will","Brooklyn",17);}

	@Test()
	@Category(INegativeTest.class)
public void createAccountNegativeTest() throws AccountException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CreditAccount.createAccount(3,500,client2);
		//CreditAccount.createAccount(4,-90,client);
		throw  new AccountException("account error..");


}

	@Test
	@Category({IPositiveTest.class})
public void withdrawalPositiveTest(){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

}

	@Test
	@Category({INegativeTest.class})
public void withdrawalNegativeTest(){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

}

}
