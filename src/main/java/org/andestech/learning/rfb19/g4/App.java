package org.andestech.learning.rfb19.g4;


public class App {
	public static void main(String[] args) {
		{

			Customer client1 = new Customer("Андрей", "Андреев", "ул.Комарова, д.9", 15);
			Customer client2 = new Customer("Михаил", "Федоров", "ул.Колпакова, д.3", 30);
			//дебетовый счет


			//открываем дебетовый счет с суммой 100 клиенту 1
			DebitAccount debit1 = new DebitAccount();
			debit1.debitAccount(1, 100, client1);

			//пополняем дебетовый счет клиенту 1
			debit1.putMoney(500);

			//снимает деньги с дебетового счета у клиента 1
			debit1.withdrawal(1000);

			//----------------------------------------------------------------------
			//открываем кредитный счет с суммой 90 клиенту 2
			CreditAccount.createAccount(2, 90, client2);

			CreditAccount createAccount = CreditAccount.create();

			//снимаем деньги с кредитного счета у клиента 2
			createAccount.withdrawal(10000);

			//пополняем кредитный счет у клиента 2
			createAccount.putMoney(100);
		}
	}
}

