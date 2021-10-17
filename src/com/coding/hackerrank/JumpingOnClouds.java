package com.coding.hackerrank;

import java.util.List;

/**
 * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.
 * <p>
 * For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.
 * <p>
 * Example
 * <p>
 * Index the array from . The number on each cloud is its index in the list so the player must avoid the clouds at indices  and . They could follow these two paths:  or . The first path takes  jumps while the second takes . Return .
 */
public class JumpingOnClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int jumpNums = 0;
        for (int i = 0; i < c.size(); i++) {
            if (i + 2 < c.size() && c.get(i + 2) == 0) {
                ++jumpNums;
                i++;
            } else if (i + 1 < c.size() && c.get(i + 1) == 0) {
                ++jumpNums;
            }
        }
        return jumpNums;
    }
}
