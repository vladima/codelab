package com.codelab.preorder;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 * <p>
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

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(a);
        ArrayList<Integer> result = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode n = nodes.pop();
            result.add(n.val);
            if (n.right != null) nodes.push(n.right);
            if (n.left != null) nodes.push(n.left);
        }
        return result;
    }
}

