package com.coding.dynamicprogramming;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        return maxSubArrayBruteForce(nums);
    }

    public int maxSubArrayBruteForce(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public int maxSubArrayBigON(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArrayMemoization(int[] nums) {
        return maxSubArrayBruteForce(nums);
    }

    public int maxSubArrayTabulation(int[] nums) {
        return maxSubArrayBruteForce(nums);
    }
}
