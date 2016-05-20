package com.codelab.bulbs;

import java.util.List;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with it,
 * however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * <p>
 * Note : 0 represents the bulb is off and 1 represents the bulb is on.
 * <p>
 * Example:
 * <p>
 * Input : [0 1 0 1]
 * Return : 4
 * <p>
 * Explanation :
 * press switch 0 : [1 0 1 0]
 * press switch 1 : [1 1 0 1]
 * press switch 2 : [1 1 1 0]
 * press switch 3 : [1 1 1 1]
 */
public class Solution {
    public int bulbs(List<Integer> a) {
        int n = 0;
        boolean flip = false;
        for (int i = 0; i < a.size(); ++i) {
            int state = a.get(i);
            if ((state == 1) == !flip) {
                continue;
            }
            flip = !flip;
            n++;
        }
        return n;
    }
}
