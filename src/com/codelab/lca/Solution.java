package com.codelab.lca;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 * <p>
 * Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree
 * or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 * Definition for binary tree
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
    }

    boolean sawVal1;
    boolean sawVal2;
    public int lca(TreeNode a, int val1, int val2) {
        TreeNode n = findLca(a, val1, val2);
        return n != null && sawVal1 && sawVal2 ? n.val : -1;
    }

    private TreeNode findLca(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val == val1) {
            sawVal1 = true;
        }
        if (root.val == val2) {
            sawVal2 = true;
        }
        
        TreeNode leftLca = findLca(root.left, val1, val2);
        TreeNode rightLca = findLca(root.right, val1, val2);
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        if (leftLca != null && rightLca != null) {
            return root;
        }
        return leftLca != null ? leftLca : rightLca;
    }
}
