package com.coding.problems;


/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Input: x = 120
 * Output: 21
 */
public class ReverseSignedInteger {
    public int reverse(int x) {
        String stringX = String.valueOf(x);
        if(x < 0){
            stringX = stringX.substring(1);
        }

        StringBuilder builder = new StringBuilder(stringX).reverse();

        try{
            int reversedX = Integer.parseInt(builder.toString());
            if(x < 0){
                reversedX = -reversedX;
            }
            return reversedX;
        }catch (Exception ex){
            return 0;
        }

    }
}
