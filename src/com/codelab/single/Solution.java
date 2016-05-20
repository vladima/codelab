package com.codelab.single;

import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        Integer c = 0;
        for (Integer i : a) {
            c ^= i;
        }
        return c;
    }
}
