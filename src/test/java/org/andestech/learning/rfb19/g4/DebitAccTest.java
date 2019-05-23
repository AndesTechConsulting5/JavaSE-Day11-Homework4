package org.andestech.learning.rfb19.g4;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DebitAccTest {


	@Test
	@Category(IPositiveTest.class)
	public void putPositiveTest(){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	@Test
	@Category(INegativeTest.class)
	public void putNegativeTest(){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

}

