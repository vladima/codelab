package com.codelab.maxp3;

import java.util.List;
import java.util.jar.Pack200;

/**
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
 * <p>
 * Input:
 * <p>
 * array of integers e.g {1, 2, 3}
 * NOTE: Solution will fit in a 32-bit signed integer
 * Example:
 * <p>
 * [0, -1, 3, 100, 70, 50]
 * <p>
 * => 70*50*100 = 350000
 */
public class Solution {
    public int maxp3(List<Integer> a) {
        if (a.size() < 3) {
            return 0;
        }
        else {
            a.sort(null);
            int i = a.size() - 1;
            int v1 = a.get(a.size() - 1) * a.get(a.size() - 2) * a.get(a.size() - 3);
            int v2 = a.get(a.size() - 1) * a.get(0) * a.get(1);
            return Math.max(v1, v2);
        }
    }
}
