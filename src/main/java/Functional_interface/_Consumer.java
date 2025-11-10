package Functional_interface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Calling the normal (non-functional) method
        greetCustomer(new Customer("Anna", "9999"));

        // Calling the Consumer functional interface implementation
        greetCustomerCust.accept(new Customer("Aatrox", "930192"));
    }

    // Regular method that takes a Customer object and prints a greeting
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.CustName +
                ", thanks for registering with phone number: " + customer.CustPhoneNum);
    }

    // Consumer functional interface implementation (takes a Customer and performs an action)
    static Consumer<Customer> greetCustomerCust = customer ->
            System.out.println("Hello " + customer.CustName +
            ", thanks for registering with phone number: " + customer.CustPhoneNum);
}

