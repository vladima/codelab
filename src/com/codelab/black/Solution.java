package com.codelab.black;

import java.util.List;

/**
 * Given N * M field of O's and X's, where O=white, X=black
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 * <p>
 * Example:
 * <p>
 * OOOXOOO
 * OOXXOXO
 * OXOOOXO
 * <p>
 * answer is 3 shapes are  :
 * (i)    X
 * X X
 * (ii)
 * X
 * (iii)
 * X
 * X
 * Note that we are looking for connected shapes here.
 * <p>
 * For example,
 * <p>
 * XXX
 * XXX
 * XXX
 * is just one single connected black shape.
 */
public class Solution {
    public int black(List<String> a) {
        if (a.isEmpty()) {
            return 0;
        }
        boolean[][] visited = new boolean[a.size()][a.get(0).length()];
        int n = 0;
        for (int i = 0; i < visited.length; ++i) {
            for (int j = 0; j < visited[i].length; ++j) {
                if (a.get(i).charAt(j) == 'X' && !visited[i][j]) {
                    n++;
                    markVisited(a, visited, i, j);
                }
            }
        }
        return n;
    }
    private void markVisited(List<String> a, boolean[][] visited, int i, int j) {
        if (visited[i][j] || a.get(i).charAt(j) != 'X') {
            return;
        }
        visited[i][j] = true;
        if (i != 0) markVisited(a, visited, i - 1, j);
        if (i != visited.length - 1) markVisited(a, visited, i + 1, j);
        if (j != 0) markVisited(a, visited, i, j - 1);
        if (j != visited[i].length - 1) markVisited(a, visited, i, j + 1);
    }
}
