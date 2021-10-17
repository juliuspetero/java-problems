package com.coding.hackerrank;


/**
 * An avid
 * <p>
 * <p>
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
 * <p>
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 */
public class CountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int prevPosition = 0;
        int curPosition = 0;
        int valleyNums = 0;
        int mountNums = 0;
        for (char c : path.toCharArray()) {
            if (c == 'U') {
                ++curPosition;
            } else {
                --curPosition;
            }

            if (prevPosition == 0 && curPosition < 0) {
                ++valleyNums;
            } else if (prevPosition == 0 && curPosition > 0) {
                ++mountNums;
            }
            prevPosition = curPosition;
        }
        return valleyNums;
    }


}
