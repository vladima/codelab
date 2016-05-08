package com.codelab.buildTree2;

import java.util.List;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }

    private TreeNode buildTree(List<Integer> preorder, int preorderStart, int preorderEnd, List<Integer> inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = preorder.get(preorderStart);
        int rootInOrderIndex = -1;
        for (int i = inorderStart; i <= inorderEnd; ++i) {
            if (inorder.get(i) == rootVal) {
                rootInOrderIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
                preorder,
                preorderStart + 1,
                preorderStart + (rootInOrderIndex - inorderStart),
                inorder,
                inorderStart, // start from the beginning of inorder subsequence
                rootInOrderIndex - 1 // up to the position right before the root
        );
        root.right = buildTree(
                preorder,
                preorderStart + (rootInOrderIndex - inorderStart) + 1,
                preorderEnd,
                inorder,
                rootInOrderIndex + 1, // start from the position right after the root
                inorderEnd  // up to the end
        );
        return root;
    }
}
