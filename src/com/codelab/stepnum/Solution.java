package com.codelab.stepnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N and M find all stepping numbers in range N to M
 * <p>
 * The stepping number:
 * <p>
 * A number is called as a stepping number if the adjacent digits have a difference of 1.
 * e.g 123 is stepping number, but 358 is not a stepping number
 * <p>
 * Example:
 * <p>
 * N = 10, M = 20
 * all stepping numbers are 10 , 12
 * Return the numbers in sorted order.
 */
public class Solution {
    public List<Integer> stepnum(int a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a; i <= b; ++i) {
            if (isStepping(i)) {
                result.add(i);
            }
        }
        return result;
    }

        public static boolean isStepping(int n) {
        int div, rem;
        int prev = -1;
        do {
            div = n / 10;
            rem = n % 10;
            if (prev == -1) {
                prev = rem;
            }
            else {
                if (rem != prev + 1 && rem != prev - 1) {
                    return false;
                }
                prev = rem;
            }
            n = div;
        } while (n != 0);
        return true;
    }
}
