package org.andestech.learning.rfb19.g4;

import org.andestech.learning.rfb19.g4.homework3.Customer;

public class TestData {

    public static final Customer CUSTOMER_VALID = new Customer("firstName", "secondName", 35, "address");

    public static final Customer CUSTOMER_INVALID_AGE = new Customer("firstName", "secondName", 10, "address");

    public static final double INITIAL_CREDIT_BALANCE = 10.0;
    public static final double INITIAL_DEBIT_BALANCE = 10.0;

    public static final double MAX_CREDIT_BALANCE = 1_000_000_000.0;
    public static final double MAX_DEBIT_BALANCE = 1_000_000_000.0;
}
