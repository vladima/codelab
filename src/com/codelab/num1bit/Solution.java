package com.codelab.num1bit;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 * <p>
 * Example:
 * <p>
 * The 32-bit integer 11 has binary representation
 * <p>
 * 00000000000000000000000000001011
 * so the function should return 3.
 * <p>
 * Note that since Java does not have unsigned int, use long for Java
 */
public class Solution {
    public int numSetBits(long a) {
        int n = 0;
        for (int i = 0; i < 32; ++i) {
            if ((a & (1 << i)) != 0) {
                n++;
            }
        }
        return n;
    }
}
