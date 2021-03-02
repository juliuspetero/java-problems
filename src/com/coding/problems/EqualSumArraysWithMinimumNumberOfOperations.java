package com.coding.problems;

import java.util.Arrays;

public class EqualSumArraysWithMinimumNumberOfOperations {

    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1 = 0, sum2 = 0;
        for (int i : nums1) sum1 += i;
        for (int i : nums2) sum2 += i;
        return solve(nums1, sum1, nums2, sum2);
    }

    int solve(int[] a, int s1, int[] b, int s2) {
        if (s1 < s2) return solve(b, s2, a, s1);
        if (s1 == s2) return 0;
        int diff = s1 - s2, m = a.length, n = b.length, i = m - 1, j = 0;
        int res = 0;
        while (i > -1 || j < n) {
            int da = i > -1 ? (a[i] - 1) : 0, db = j < n ? (6 - b[j]) : 0;
            if (da == 0 && db == 0) return -1;
            if (da > db) {
                diff -= da;
                i--;
            } else {
                diff -= db;
                j++;
            }
            res++;
            if (diff <= 0) return res;
        }
        return -1;
    }
}
