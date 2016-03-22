package com.codelab.sumrootleaf;


public class Solution {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode a) {
        return doSum(a, 0)% 1003;
    }

    private int doSum(TreeNode a, int acc) {
        if (a == null) {
            return 0;
        }
        acc = (acc * 10 + a.val) % 1003;
        if (a.left == null && a.right == null) {
            return acc;
        }
        return (doSum(a.left, acc) + (doSum(a.right, acc))) % 1003;
    }
}
