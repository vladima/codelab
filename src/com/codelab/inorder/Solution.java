package com.codelab.inorder;

import com.codelab.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 * <p>
 * Example :
 * Given binary tree
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Using recursion is not allowed.
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        public ArrayList<Integer> inorderTraversal(TreeNode a) {
            ArrayList<Integer> result = new ArrayList<>();
            Stack<TreeNode> nodes = new Stack<>();
            TreeNode current = a;
            while (!nodes.empty() || current != null) {
                if (current != null) {
                    nodes.push(current);
                    current = current.left;
                }
                else {
                    TreeNode n = nodes.pop();
                    result.add(n.val);
                    current = n.right;
                }
            }
            return result;
        }
}
