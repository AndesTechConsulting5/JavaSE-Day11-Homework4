package org.andestech.learning.rfb19.g4;

public class CreditAccount extends Account {

	private CreditAccount() {
	}

	private CreditAccount(int accountId, double balance, Customer customer) {
		super(accountId, balance, customer);
	}


	public static CreditAccount create() {return new CreditAccount();}

	//фабричный метод
	public static CreditAccount createAccount(int id, double balance, Customer customer) {
		if(customer.getAge() < 18) {
			System.out.println("Возраст не подходит!");
			return null;
		} else if (balance < 0) {
			System.out.println("Отрицательный баланс!");
			return null;

		} else {
			System.out.println("Создание кредитного счета с балансом:" + balance);
			return new CreditAccount(id, balance, customer);
		}
	}




	@Override
	public void withdrawal(double money) {
		System.out.println("Снимаем деньги с кредитного счета.");
		if(isDeltaValid(money)) {
			double balance = getBalance() - money;
			setBalance(balance);
			System.out.println("На счету " + balance);
		}
	}

	@Override
	public void putMoney(double money) {
		System.out.println("Кладем деньги на кредитный счет.");
		if(isDeltaValid(money)) {
			double balance = getBalance() + money;
			setBalance(balance);
			System.out.println("На счету " + balance);
		}
	}
}
