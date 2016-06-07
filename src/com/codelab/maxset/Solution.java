package com.codelab.maxset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * <p>
 * Example:
 * <p>
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class Solution {
    public ArrayList<Integer> maxset(List<Integer> a) {
        int maxStart = -1, maxEnd = -1;
        long maxSum = -1;
        int start = -1, end = -1;
        long sum = -1;
        for (int i = 0; i < a.size(); ++i) {
            int curr = a.get(i);
            if (curr < 0) {
                if (sum >= 0) {
                    end = i;
                    if (maxStart == -1 || sum > maxSum || sum == maxSum && (end - start) > (maxEnd - maxStart)) {
                        maxStart = start;
                        maxEnd = end;
                        maxSum = sum;
                    }
                }
                start = end = -1;
                sum = -1;
            } else {
                if (sum < 0) {
                    start = i;
                    sum = 0;
                }
                sum += curr;
            }
        }
        end = a.size();
        if (maxStart == -1 || sum > maxSum || sum == maxSum && (end - start) > (maxEnd - maxStart)) {
            maxStart = start;
            maxEnd = end;
        }
        return maxStart >= 0 ? new ArrayList<>( a.subList(maxStart, maxEnd) ) : new ArrayList<>();
    }
}
