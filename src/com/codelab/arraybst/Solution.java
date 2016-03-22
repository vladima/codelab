package com.codelab.arraybst;

import java.util.List;

public class Solution {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return insert(a, 0, a.size());
    }

    private static TreeNode insert(List<Integer> a, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(a.get(mid));
        n.left = insert(a, start, mid);
        n.right = insert(a, mid + 1, end);
        return n;
    }
}
