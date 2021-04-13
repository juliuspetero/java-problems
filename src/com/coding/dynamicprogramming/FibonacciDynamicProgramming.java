package com.coding.dynamicprogramming;

public class FibonacciDynamicProgramming {

    public int calculateFibonacciNumber(int n) {
        if (n < 2)
            return n;
        int previousFibo1 = calculateFibonacciNumber(n - 1);
        int previousFibo2 = calculateFibonacciNumber(n - 2);
        int fiboNumber = previousFibo1 + previousFibo2;
        return fiboNumber;
    }


    /**
     * Dynamic programmming - Top-down memorization
     *
     * @param n
     * @return
     */
    public int calculateFibonacciNumberUsingDP1(int n) {
        int[] memory = new int[n + 1];
        int fiboNumber = calculateFibonacciNumberRecursively(memory, n);
        return fiboNumber;
    }

    private int calculateFibonacciNumberRecursively(int[] memory, int n) {
        if (n < 2) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = calculateFibonacciNumberRecursively(memory, n - 1) + calculateFibonacciNumberRecursively(memory, n - 2);
        return memory[n];
    }

    /**
     * Dynamic programming - Bottom-up Tabulation
     */
    public int calculateFibonacciNumberUsingDP2(int n) {
        if (n == 0) return 0;
        int[] array = new int[n + 1];

        // Base case scenarios
        array[0] = 0;
        array[1] = 1;

        // Fill the array up to the nth value
        for(int i = 2; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }

        int fiboNumber = array[n];
        return fiboNumber;
    }


}
