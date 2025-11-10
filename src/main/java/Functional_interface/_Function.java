package Functional_interface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // normal (non-functional) method
        int increment = increment(1);
        System.out.println(increment);

        // Calling the Function<> functional interface implementation
        int increment_func = increment_by_one_function.apply(1);
        System.out.println(increment_func);

        // Calling the Function<> functional interface implementation
        int multiply_func = multiply_by_10.apply(2);
        System.out.println(multiply_func);

        // andThen to combine
        Function<Integer, Integer> add_by_1_then_multiply_by_10 = increment_by_one_function.andThen(multiply_by_10);
        int apply_func = add_by_1_then_multiply_by_10.apply(2);
        System.out.println(apply_func);
    }

    // Function<> functional interface implementation
    static Function<Integer, Integer> increment_by_one_function = number -> number + 1;

    // Function<> functional interface implementation
    static Function<Integer, Integer> multiply_by_10 = number -> number * 10;

    static int increment(int num) {
        return num + 1;
    }
}
