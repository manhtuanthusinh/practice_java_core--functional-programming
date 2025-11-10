package Functional_interface;
import java.util.function.BiConsumer;

public class _BiConsumer {
    public static void main(String[] args) {
        Customer Tuan = new Customer("Tuan", "510283903218");
        greetCustomerV2.accept(Tuan, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerV2 = (customer, showPhonenum) ->
            System.out.println("Hello " + customer.CustName
                    + " Thanks for registering with phone num: "
                    + (showPhonenum ? customer.CustPhoneNum : "**********"));
}
