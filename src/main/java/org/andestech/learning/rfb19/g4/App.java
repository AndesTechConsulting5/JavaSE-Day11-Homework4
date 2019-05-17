package org.andestech.learning.rfb19.g4;

/**
 * HomeWork 2
 *
 */
public class App
{
    public static void main( String[] args ) {

        Customer customer69 = new Customer("Vasyly", "Dulin", 50, "ul. Valovaya");
        DebitAccount customer69DebitAccount = new DebitAccount(1, customer69, 100);
        CreditAccount customer69CreditAccount = CreditAccount.createCreditAccount(true, customer69.getAge(), customer69, 1500, 1);

        CreditAccount.createCreditAccount(true,13, customer69,10,2);

        System.out.println(customer69DebitAccount.getBalance());
        System.out.println(customer69CreditAccount.getBalance());
        customer69CreditAccount.putMoney(10);
        System.out.println(customer69CreditAccount.getBalance());
        customer69CreditAccount.withdrawal(5);
        System.out.println(customer69CreditAccount.getBalance());
        customer69CreditAccount.withdrawal(1000.01);


        System.out.println(customer69DebitAccount.getBalance());
        customer69DebitAccount.putMoney(100_000.01);
        customer69DebitAccount.withdrawal(400);

    }
}
