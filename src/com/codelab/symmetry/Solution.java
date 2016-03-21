package com.codelab.symmetry;

public class Solution {
    /*
    * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    * */
    public int isSymmetric(TreeNode a) {
        return isSymmetric(a.left, a.right) ? 1 : 0;
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}