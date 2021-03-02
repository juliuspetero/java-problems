package com.coding.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * <p>
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * <p>
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 * <p>
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 */
public class MaximumScoreFromMultiplication {
    int n, m;
    int[] nums, multipliers;
    Integer[][] memo;

    public int maximumScoreDPApproach(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new Integer[m][m];
        return dp(0, 0);
    }

    // Bottom up tabulation
    private int dp(int l, int i) {
        if (i == m) return 0; // Picked enough m elements

        if (memo[l][i] != null) return memo[l][i];

        int prevLeft = dp(l + 1, i + 1);
        int pickLeft = prevLeft + nums[l] * multipliers[i]; // Pick the left side
        int prevRight = dp(l, i + 1);
        int pickRight = prevRight + nums[n - (i - l) - 1] * multipliers[i]; // Pick the right side
        memo[l][i] = Math.max(pickLeft, pickRight);
        return memo[l][i];
    }

    public int maximumScoreBruteForce(int[] nums, int[] multipliers) {
        int maxScore = 0;

        // Convert int[] to List<Integer>
        List<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int multiplier : multipliers) {
            // Which value should I pick
            int size = result.size();

            int pickedValue;
            // Pick the last value
            if (multiplier * result.get(0) < multiplier * result.get(size - 1)) {
                pickedValue = result.get(size - 1);
                result.remove(size - 1);

                // Pick the first value
            } else {
                pickedValue = result.get(0);
                result.remove(0);
            }
            int score = multiplier * pickedValue;
            maxScore = maxScore + score;

        }

        return maxScore;
    }

    public int maximumScoreBruteForce2(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int z = m - 1; z >= 0; --z) { // z = operations
            for (int i = 0; i <= z; ++i) {
                int y = z - i; // number of rights removed
                int j = n - y - 1; // Index of the remaining right value
                dp[i][y] = Math.max(dp[i + 1][y] + nums[i] * multipliers[z], dp[i][y + 1] + nums[j] * multipliers[z]);
            }
        }
        return dp[0][0];
    }


    public int solve(int[] nums, int[] multipliers) {
        if (multipliers.length > 30)
            throw new IllegalArgumentException("Too many multipliers (max 30): " + multipliers.length);
        final int end = 1 << multipliers.length;
        int maxSum = Integer.MIN_VALUE;
        for (int bits = 0; bits < end; bits++) {
            int sum = 0, idx0 = 0, idx1 = nums.length;
            for (int i = 0; i < multipliers.length; i++)
                sum += multipliers[i] * ((bits & (1 << i)) == 0 ? nums[idx0++] : nums[--idx1]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


}
