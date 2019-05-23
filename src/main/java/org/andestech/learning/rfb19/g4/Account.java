package org.andestech.learning.rfb19.g4;

public abstract class Account {

	private int accountId;
	private static double balance;
	private Customer customer = new Customer("Иван", "Петров", "ул.Ленина, д.1", 20);

	private static final double MAX_BALANCE = 1_500_000, MIN_BALANCE = -200_000,
			DELTA_MIN = 1, DELTA_MAX = 100_000;


	public Account() {
	}

	public Account(int accountId, double balance, Customer customer) {
		this.accountId = accountId;
		this.balance = balance;
		this.customer = customer;
	}



	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(!isNewBalanceValid(balance)) {
			return;
		}
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public boolean isNewBalanceValid(double balance) {
		if(balance <= MAX_BALANCE && balance >= MIN_BALANCE) {
			return true;
		} else {
			System.out.println("Неверный баланс! " + balance);
			return false;
		}
	}

	public boolean isDeltaValid(double delta) {
		if(delta>=0 && delta <= DELTA_MAX && delta >= DELTA_MIN) {
			return true;
		} else {
			System.out.println("Неправильная сумма перевода =" + delta);
			return false;
		}

	}

	public abstract void withdrawal(double money);
	public abstract void putMoney(double money);



}
