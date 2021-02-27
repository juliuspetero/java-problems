package com.coding.problems;

import java.util.ArrayList;
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
}
