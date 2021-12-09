package com.coding.hackerrank.arrays;

import java.util.List;

public class MinimumBribes {


    public static void minimumBribes(List<Integer> q) {
        int size = q.size();
        int bribes = 0;
        for (int i = 1; i <= size; i++) {
            int diff = i - q.indexOf(i) - 1;
            if (diff == 1 || diff == 2) {
                bribes = bribes + diff;
            } else if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);
    }


    public static void minimumBribes2(List<Integer> q) {
        int size = q.size();
        int bribes = 0;
        for (int i = 0; i < size; i++) {
            int diff = i - q.indexOf(i + 1);
            if (diff > 0 && diff <= 2) {
                bribes = bribes + diff;
            } else if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);
    }

    public static void minimumBribes3(List<Integer> q) {
        int size = q.size();
        int ans = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) ans++;
            }
        }
        System.out.println(ans);
    }

}
