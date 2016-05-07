package com.codelab.maxDepth;

/**
 * Definition for binary tree
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the nearest leaf node.
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int maxDepth(TreeNode a) {
            return a != null ? Math.max(maxDepth(a.left), maxDepth(a.right)) + 1 : 0;
        }
    }
}