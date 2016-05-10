package com.codelab.cartesian;

import java.util.List;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 * <p>
 * Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 * Note: You may assume that duplicates do not exist in the tree.
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(List<Integer> a) {
        return buildTree(a, 0, a.size() - 1);
    }

    public TreeNode buildTree(List<Integer> a, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start + 1; i <= end; ++i) {
            if (a.get(i) > a.get(maxIndex)) {
                maxIndex = i;
            }
        }
        TreeNode n = new TreeNode(a.get(maxIndex));
        n.left = buildTree(a, start, maxIndex - 1);
        n.right = buildTree(a, maxIndex + 1, end);
        return  n;
    }
}

