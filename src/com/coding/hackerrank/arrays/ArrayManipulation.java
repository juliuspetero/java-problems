package com.coding.hackerrank.arrays;

import java.util.List;


/**
 * List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 2, 100), Arrays.asList(2, 5, 100), Arrays.asList(3, 4, 100));
 * long result = ArrayManipulation.arrayManipulation(5, queries);
 * <p>
 * <p>
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in the array.
 */
public class ArrayManipulation {

    // Bruteforce approach
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        long maxValue = 0;
        for (List<Integer> query : queries) {
            Integer a = query.get(0);
            Integer b = query.get(1);
            Integer k = query.get(2);
            for (int i = a; i <= b; i++) {
                long temp = arr[i - 1];
                arr[i - 1] = temp + k;
                if (arr[i - 1] > maxValue) {
                    maxValue = arr[i - 1];
                }
            }
        }
        return maxValue;
    }

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        int m = queries.size();
        long[] array = new long[n + 1];

        // m-- while return the previous value of M and decrement the value
        while (m-- > 0) {
            int a = queries.get(m).get(0);
            int b = queries.get(m).get(1);
            int k = queries.get(m).get(2);
            array[a - 1] += k;
            array[b] -= k;
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
