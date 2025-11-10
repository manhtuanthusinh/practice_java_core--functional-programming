package Functional_interface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // normal (non-functional) method
        System.out.println(isPhoneNumValid("09890312809"));
        // Calling the Predicate functional interface implementation
        System.out.println(PhoneNumValidPredicate.test("06"));
        // calling combine 2 Predicates functional interface implementation
        System.out.println(
                PhoneNumValidPredicate.and(isPhoneNumContains_6_and_9).test("09312")
        );
    }

    // regular method
    static boolean isPhoneNumValid (String PhoneNumber) {
        return PhoneNumber.startsWith("09") || PhoneNumber.startsWith("08");
    }

    // Predicate functional interface implementation
    static Predicate<String> PhoneNumValidPredicate = PhoneNumber ->
            PhoneNumber.startsWith("09") || PhoneNumber.startsWith("08");

    static Predicate<String> isPhoneNumContains_6_and_9 = PhoneNumber ->
            PhoneNumber.contains("6") & PhoneNumber.contains("9");
}
