package com.codelab.recover;

import com.codelab.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Tell us the 2 values swapping which the tree will be restored.
 * <p>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Example :
 * <p>
 * <p>
 * Input :
 * 1
 * / \
 * 2   3
 * <p>
 * Output :
 * [1, 2]
 * <p>
 * Explanation : Swapping 1 and 2 will change the BST to be
 * 2
 * / \
 * 1   3
 * which is a valid BST
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    Integer current;
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> recoverTree(TreeNode a) {
        visit(a);
        result.sort(Integer::compareTo);
        return result;
    }

    private void visit(TreeNode n) {
        if (n == null) {
            return;
        }
        visit(n.left);
        if (current == null) {
            current = n.val;
        }
        else {
            // check invariant
            if (n.val < current) {
                if (result.size() == 0) {
                    result.add(current);
                    result.add(n.val);
                }
                else {
                    result.set(1, n.val);
                }
            }
            current = n.val;
        }
        visit(n.right);
    }
}
