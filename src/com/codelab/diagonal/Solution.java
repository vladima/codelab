package com.codelab.diagonal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input:
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * Return the following :
 * <p>
 * [
 * [1],
 * [2, 4],
 * [3, 5, 7],
 * [6, 8],
 * [9]
 * ]
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); ++i) {
            ArrayList<Integer> diagnonal = new ArrayList<>();
            int x = i;
            int y = 0;
            do
            {
                diagnonal.add(a.get(y).get(x));
                x--;
                y++;
            } while (x >= 0);
            result.add(diagnonal);
        }
        for (int i = 1; i < a.size(); ++i) {
            ArrayList<Integer> diagnonal = new ArrayList<>();
            int x = a.size() - 1;
            int y = i;
            do
            {
                diagnonal.add(a.get(y).get(x));
                x--;
                y++;
            } while (y < a.size());
            result.add(diagnonal);
        }

        return result;
    }
}
