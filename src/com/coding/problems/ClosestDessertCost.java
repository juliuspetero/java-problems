package com.coding.problems;

import java.util.Arrays;

/**
 * You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:
 * <p>
 * There must be exactly one ice cream base.
 * You can add one or more types of topping or have no toppings at all.
 * There are at most two of each type of topping.
 * You are given three inputs:
 * <p>
 * baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
 * toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
 * target, an integer representing your target price for dessert.
 * You want to make a dessert with a total cost as close to target as possible.
 * <p>
 * Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.
 * <p>
 * Input: baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * Output: 10
 * Explanation: Consider the following combination (all 0-indexed):
 * - Choose base 1: cost 7
 * - Take 1 of topping 0: cost 1 x 3 = 3
 * - Take 0 of topping 1: cost 0 x 4 = 0
 * Total: 7 + 3 + 0 = 10.
 */
public class ClosestDessertCost {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int b = baseCosts.length;
        int t = toppingCosts.length;
        int minCostDiff = Integer.MAX_VALUE;
        int closestCost = 0;

        // No topping
        for (int i = 0; i < b; i++) {
            int cost = baseCosts[i];
            if (Math.abs(target - cost) < minCostDiff) {
                minCostDiff = Math.abs(target - cost);
                closestCost = cost;
            }

            // Topping = 1
            for (int j = 0; j < t; j++) {
                cost = cost + toppingCosts[j];
                if (Math.abs(target - cost) < minCostDiff) {
                    minCostDiff = Math.abs(target - cost);
                    closestCost = cost;
                }

                cost = cost + 2 * toppingCosts[j];
                if (Math.abs(target - cost) < minCostDiff) {
                    minCostDiff = Math.abs(target - cost);
                    closestCost = cost;

                    for (int k = 2; k <= t; k++) {
                        cost = cost + toppingCosts[k];
                        if (Math.abs(target - cost) < minCostDiff) {
                            minCostDiff = Math.abs(target - cost);
                            closestCost = cost;
                        }
                    }
                }
            }
        }

        return closestCost;
    }


    int minDis = Integer.MAX_VALUE;
    int res = 0;
    public int closestCost2(int[] baseCosts, int[] toppingCosts, int target) {
        if (baseCosts == null) return res;
        Arrays.sort(toppingCosts);
        for (int base : baseCosts) {
            dfs(base, toppingCosts, 0, target);
        }
        return res;
    }

    private void dfs(int sum, int[] topping, int idx, int target) {
        int dis = Math.abs(target - sum);
        if (dis < minDis) {
            minDis = dis;
            res = sum;
        } else if (dis == minDis) {
            res = Math.min(res, sum);
        }
        if (idx == topping.length) return;
        if (sum > target) return;
        dfs(sum, topping, idx + 1, target);
        dfs(sum + topping[idx], topping, idx + 1, target);
        dfs(sum + topping[idx] * 2, topping, idx + 1, target);
    }

    public int closestCost3(int[] baseCosts, int[] toppingCosts, int target) {
        int max = (int)(2e4+10);

        boolean[] dp = new boolean[max];
        for (int i=0; i<baseCosts.length; i++) {
            dp[baseCosts[i]] =true;
        }

        for (int i=0; i<toppingCosts.length; i++) {
            for (int j=max-1; j>=toppingCosts[i]; j--) {
//        		if (i == 0 && j == 10) {
//        			System.out.println("here");
//        		}
                if (j >= 2*toppingCosts[i]) {
                    if (dp[j - 2*toppingCosts[i]]) {
                        dp[j] = true;
                    }
                }

                if (dp[j - toppingCosts[i]]) {
                    dp[j] = true;
                }
            }
        }

        int min=2*max;
        int val=0;
        for (int i=0; i<max; i++) {
            if (dp[i]) {
                if (Math.abs(i - target) < min) {
                    val = i;
                    min = Math.abs(i - target);
                }
            }
        }

        return val;
    }
}
