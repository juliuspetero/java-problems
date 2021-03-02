package com.coding.problems;

public class Recursion {

    public int getTriangularNumber(int number) {
        System.out.println("Method Number = " + number);
        int result;
        if (number == 1 || number == 0) {
            result = 1;
        } else {
            result = number + getTriangularNumber(number - 1);
        }
        System.out.println("Return Value: " + result);
        return result;
    }

    public int getFactorial(int number) {
        System.out.println("Method Number = " + number);
        int result;
        if (number == 1 || number == 0) {
            result = 1;
        } else {
            result = number * getFactorial(number - 1);
        }
        System.out.println("Return Value: " + result);
        return result;
    }

    int[] table;

    public int getNthFibonacciNumber(int number) {
        System.out.println("Method Number = " + number);
        if (table == null) {
            table = new int[number + 1];
        }

        // Return the cached data without heavy computation power
        if (table[number] != 0) {
            return table[number];
        }

        int result;
        if (number < 2) {
            result = number;
        } else {
            int previousFib1 = getNthFibonacciNumber(number - 1);
            int previousFib2 = getNthFibonacciNumber(number - 2);
            result = previousFib1 + previousFib2;
        }
        // Cache the result in a map or table
        table[number] = result;
        System.out.println("Return Value: " + result);
        return result;
    }
}
