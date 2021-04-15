package com.coding;

import com.coding.problems.WaterContainer;

public class Main {

    public static void main(String[] args) {
        WaterContainer waterContainer = new WaterContainer();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(waterContainer.maxArea2(height));

    }
}

