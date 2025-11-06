package Functional_interface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
//        int increment = increment(1);
//        System.out.println(increment);
        int increment_func = increment_by_one_function.apply(1);
        System.out.println(increment_func);

        int multiply_func = multiply_by_10.apply(2);
        System.out.println(multiply_func);

        Function<Integer, Integer> add_by_1_then_multiply_by_10 = increment_by_one_function.andThen(multiply_by_10);
        int apply_func = add_by_1_then_multiply_by_10.apply(2);
        System.out.println(apply_func);
    }

    static Function<Integer, Integer> increment_by_one_function = number -> number + 1;

    static Function<Integer, Integer> multiply_by_10 = number -> number * 10;

    static int increment(int num) {
        return num + 1;
    }
}
