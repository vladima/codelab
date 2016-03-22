package com.codelab.balanced;

/**
 * Created by Vladimir on 3/20/2016.
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int isBalanced(TreeNode a) {
        return checkDepth(a) != NON_BALANCED ? 1 : 0;
    }

    private final int NON_BALANCED = -1;

    private int checkDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        int left = checkDepth(a.left);
        if (left == NON_BALANCED) return NON_BALANCED;
        int right = checkDepth(a.right);
        if (right == NON_BALANCED) return NON_BALANCED;
        return Math.abs(left - right) > 1 ? NON_BALANCED : Math.max(left, right) + 1;
    }

}
