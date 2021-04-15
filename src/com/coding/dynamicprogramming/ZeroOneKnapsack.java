package com.coding.dynamicprogramming;


/**
 * Return the maximum value can be put in a knapsack of capacity W
 * You can either pick an item or not (0 | 1)
 * <p>
 * int[] val = new int[]{10, 20, 30};
 * int[] wt = new int[]{1, 1, 1};
 * int W = 2;
 * int n = val.length;
 * ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
 * System.out.println(zeroOneKnapsack.knapsack(W, wt, val, n));
 * System.out.println(zeroOneKnapsack.knapsackMemoization(W, wt, val, n));
 * <p>
 * KnapsackProblem knapsackProblem = new KnapsackProblem();
 * System.out.println(Arrays.toString(knapsackProblem.getKnapsackValues(val, wt, W)));
 */
public class ZeroOneKnapsack {

    public int knapsack(int W, int[] wt, int[] val, int n) {
        int maxValue;
        // 0 items or 0 weight
        if (n == 0 || W == 0) {
            maxValue = 0;

            // The nth item has weight greater than the knapsack capacity W
        } else if (wt[n - 1] > W) {
            maxValue = knapsack(W, wt, val, n - 1);

            // Return the maximum value whether to include n or not
        } else {
            int valueWithNIncluded = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1);
            int valueWithNExcluded = knapsack(W, wt, val, n - 1);
            maxValue = Math.max(valueWithNIncluded, valueWithNExcluded);
        }
        return maxValue;
    }

    public int memoizationRec(int W, int[] wt, int[] val, int n, int[][] dp) {
        int maxValue;
        if (n == 0 || W == 0) {
            maxValue = 0;
        } else if (dp[n][W] != -1) {
            maxValue = dp[n][W];
        } else if (wt[n - 1] > W) {
            maxValue = dp[n][W] = memoizationRec(W, wt, val, n - 1, dp);
        } else {
            int valueWithNIncluded = val[n - 1] + memoizationRec(W - wt[n - 1], wt, val, n - 1, dp);
            int valueWithNExcluded = memoizationRec(W, wt, val, n - 1, dp);
            maxValue = dp[n][W] = Math.max(valueWithNIncluded, valueWithNExcluded);
        }
        return maxValue;
    }

    public int knapsackMemoization(int W, int[] wt, int[] val, int N) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return memoizationRec(W, wt, val, N, dp);
    }
}
