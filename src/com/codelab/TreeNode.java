package com.codelab;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by Vladimir on 5/9/2016.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public String asDot() {
        StringBuffer buf = new StringBuffer();
        buf.append("digraph G {\r\n");
        toDot(buf);
        buf.append("}");
        return buf.toString();
    }

    private void toDot(StringBuffer buf) {
        if (left != null) {
            buf.append(this.val + " -> " + left.val + "\r\n");
            left.toDot(buf);
        }
        if (right != null) {
            buf.append(this.val + " -> " + right.val + "\r\n");
            right.toDot(buf);
        }
    }

    public String toString() {
        return String.valueOf(this.val);
    }

    public static TreeNode fromString(String s) {
        String[] parts = s.split("\\s+");
        Integer size = Integer.valueOf(parts[0]);
        TreeNode[] root = new TreeNode[] { parseNode(parts, 1) };
        int total = 2;
        TreeNode[] current = root;
        while (total < size) {
            current = parseLevel(parts, current, total);
            total += current.length;
        }
        return root[0];
    }

    private static TreeNode parseNode(String[] parts, int i) {
        int n = Integer.valueOf(parts[i]);
        return n != -1 ? new TreeNode(n) : null;
    }

    private static TreeNode[] parseLevel(String[] parts, TreeNode[] previousLevel, int start) {
        ArrayList<TreeNode> result = new ArrayList<>();
        int i = start;
        for (TreeNode n: previousLevel) {
            if (n == null) {
                continue;
            }
            n.left = parseNode(parts, i);
            result.add(n.left);
            i++;
            n.right = parseNode(parts, i);
            result.add(n.right);
            i++;
        }
        return result.toArray(new TreeNode[0]);
    }
}

