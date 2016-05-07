package com.codelab.buildTree;

/**
 * Created by Vladimir on 5/7/2016.
 */

import java.util.List;

/**
 * Reconstruct binary tree given its in-order and post-order traversals
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

        public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
            return reconstruct(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
        }

        private TreeNode reconstruct(List<Integer> inorder, int inOrderStart, int inOrderEnd, List<Integer> postorder, int postOrderStart, int postOrderEnd) {
            if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
                return null;
            }
            Integer rootVal = postorder.get(postOrderEnd);
            int rootInOrderIndex = inorder.indexOf(rootVal);
            TreeNode root = new TreeNode(rootVal);
            // rootInOrderIndex - inOrderStart === length of in left part in in-order sequence
            root.left = reconstruct(inorder,
                    inOrderStart, // start from the current left end of in-order
                    rootInOrderIndex - 1, // up to the position right before the root
                    postorder,
                    postOrderStart, // start from the current left end of in-order
                    postOrderStart + (rootInOrderIndex - inOrderStart) - 1); // up to the end of chunk with length - length of matching in-order part
            root.right = reconstruct(inorder,
                    rootInOrderIndex + 1, // start right after the root
                    inOrderEnd, // up to the end
                    postorder,
                    postOrderStart + (rootInOrderIndex - inOrderStart), // start at left + length of matching in-order part
                    postOrderEnd - 1); // up-to the end excluding the root
            return root;
        }

    }
}
