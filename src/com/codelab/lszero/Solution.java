package com.codelab.lszero;

import java.util.*;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 * <p>
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class Solution {
    public ArrayList<Integer> lszero(List<Integer> a) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int left = 0, right = 0, maxLen = 0, sum = 0;
        for (int i = 0; i < a.size(); ++i) {
            sum += a.get(i);
            if (sums.containsKey(sum)) {
                int start = sums.get(sum);
                int l = i - start + 1;
                if (l > maxLen) {
                    left = start + 1;
                    right = i;
                    maxLen = l;
                }
            }
            else {
                sums.put(sum, i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (maxLen != 0) {
            for (int i = left; i <= right; ++i) {
                result.add(a.get(i));
            }
        }
        return result;
    }
}
