package com.coding.learnings;

/**
 * MultiplyFunctional multiplier = (a, b) -> {
 * int c = a * b;
 * return c;
 * };
 * <p>
 * System.out.println(multiplier.multiplyNumbers(3, 6));
 */

@FunctionalInterface
public interface MultiplyFunctional {

    int multiplyNumbers(int a, int b);
}
