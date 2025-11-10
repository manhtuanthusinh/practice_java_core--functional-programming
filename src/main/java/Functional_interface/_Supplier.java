package Functional_interface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // normal (non-functional) method
        System.out.println(getConnectionURL());
        // Calling Supplier functional interface implementation
        System.out.println(getConnectionURLs_Supplier.get());
    }

    // regular method
    static String getConnectionURL() {
        return "jdbc//normal_testing";
    }

    // Supplier functional interface
    static Supplier<List<String>> getConnectionURLs_Supplier = () ->
            List.of(
                    "jdbc//abc",
                    "jdbc//ceedasf",
                    "jdbc//dadawds"
            );
}
