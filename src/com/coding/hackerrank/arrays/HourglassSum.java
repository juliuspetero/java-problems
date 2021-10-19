package com.coding.hackerrank.arrays;

import java.util.List;

/**
 * int number = HourglassSum.hourglassSum(Arrays.asList(
 * Arrays.asList(-9, -9, -9, 1, 1, 1),
 * Arrays.asList(0, -9, 0, 4, 3, 2),
 * Arrays.asList(-9, -9, -9, 1, 2, 3),
 * Arrays.asList(0, 0, 8, 6, 6, 0),
 * Arrays.asList(0, 0, 0, -2, 0, 0),
 * Arrays.asList(0, 0, 1, 2, 4, 0)
 * ));
 * System.out.println(number); 28
 */

public class HourglassSum {

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) +
                        arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
