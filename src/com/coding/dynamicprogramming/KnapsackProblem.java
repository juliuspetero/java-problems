package com.coding.dynamicprogramming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KnapsackProblem {

    static String arrayToString(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i);
        }
        return builder.toString();
    }

    private void solveRecursively(int i) {
        int length = intArr.length;
        if (i == length) {
            String binaryString = arrayToString(intArr);
            stringList.add(binaryString);
            return;
        }

        // First assign "0" at ith position
        // and try for all other permutations
        // for remaining positions
        intArr[i] = 0;
        solveRecursively(i + 1);

        // And then assign "1" at ith position
        // and try for all other permutations
        // for remaining positions
        intArr[i] = 1;
        solveRecursively(i + 1);
    }

    private void generatePermutations(int i) {
        int length = intArr.length;
        if (i == length) {
            permutations.add(Arrays.stream(intArr).boxed().collect(Collectors.toList()));
            return;
        }
        intArr[i] = 0;
        generatePermutations(i + 1);
        intArr[i] = 1;
        generatePermutations(i + 1);
    }

    private final List<String> stringList = new ArrayList<>();
    private int[] intArr;

    public String[] generateAllBinaryStrings(int n) {
        intArr = new int[n];
        solveRecursively(0);
        return stringList.toArray(new String[0]);
    }


    private List<List<Integer>> permutations = new ArrayList<>();

    public int[] getKnapsackValues(int[] p, int[] w, int m) {
        int length = p.length;
        intArr = new int[p.length];
        generatePermutations(0);

        int maxTotalProfit = 0;
        List<Integer> optimalSolution = new ArrayList<>();

        for (List<Integer> permutation : permutations) {
            int totalWeight = 0;
            int totalProfit = 0;

            for (int j = 0; j < length; j++) {
                totalWeight += w[j] * permutation.get(j);
                totalProfit += p[j] * permutation.get(j);
            }

            if (totalWeight <= m && totalProfit > maxTotalProfit) {
                maxTotalProfit = totalProfit;
                optimalSolution = permutation;
            }
        }

        return optimalSolution.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] greedySolution(int[] p, int[] w, int m) {
        int n = p.length;
        List<BigDecimal> profitWeightRatios = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            profitWeightRatios.add(BigDecimal.valueOf(p[i]).divide(BigDecimal.valueOf(w[i])));
        }
        Collections.sort(profitWeightRatios);

        int totalWeight = 0;
        for (BigDecimal weighRation : profitWeightRatios) {

        }


        return new int[]{};
    }
}
