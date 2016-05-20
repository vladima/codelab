package com.codelab.mice;

import java.util.List;

/**
 * There are N Mice and N holes are placed in a straight line.
 * Each hole can accomodate only 1 mouse.
 * A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1.
 * Any of these moves consumes 1 minute.
 * Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 * <p>
 * Example:
 * <p>
 * positions of mice are:
 * 4 -4 2
 * positions of holes are:
 * 4 0 5
 * <p>
 * Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes
 * Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes
 * Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes
 * After 4 minutes all of the mice are in the holes.
 * <p>
 * Since, there is no combination possible where the last mouse's time is less than 4,
 * answer = 4.
 * Input:
 * <p>
 * A :  list of positions of mice
 * B :  list of positions of holes
 * Output:
 * <p>
 * single integer value
 * NOTE: The final answer will fit in a 32 bit signed integer.
 */
public class Solution {
    public int mice(List<Integer> a, List<Integer> b) {
        // order mices and holes
        a.sort(null);
        b.sort(null);
        int t = 0;
        // try to put every mice in the closest hole to the left of it
        for (int n = 0; n < a.size(); ++n) {
            t = Math.max(t, Math.abs(a.get(n) - b.get(n)));
        }
        return t;
    }
}

