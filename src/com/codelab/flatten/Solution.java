package com.codelab.flatten;

/**
 * Given a binary tree, flatten it to a linked list in-place.
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

    public TreeNode flatten(TreeNode a) {

        TreeNode flattenedLeft = null;
        TreeNode flattenedRight = null;

        if (a.left != null) {
            flattenedLeft = flatten(a.left);
            a.left = null;
        }
        if (a.right != null) {
            flattenedRight = flatten(a.right);
            a.right = null;
        }

        if (flattenedLeft != null) {
            a.right = flattenedLeft;
            TreeNode c = a.right;
            while (c.right != null) {
                c = c.right;
            }
            c.right = flattenedRight;
        }
        else {
            a.right = flattenedRight;
        }

        return a;
    }
}