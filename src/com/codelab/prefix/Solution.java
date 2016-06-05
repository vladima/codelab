package com.codelab.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find shortest unique prefix to represent each word in the list.
 * <p>
 * Example:
 * <p>
 * Input: [zebra, dog, duck, dove]
 * Output: {z, dog, du, dov}
 * where we can see that
 * zebra = z
 * dog = dog
 * duck = du
 * dove = dov
 * NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
public class Solution {
    static class Node {
        private char ch;
        private int midCount = 0;
        private Node left;
        private Node mid;
        private Node right;

        public Node(char ch) {
            this.ch = ch;
        }

        public String toString() {
            return this.ch + ":" + this.midCount;
        }

        public static Node insert(Node node, String s, int pos) {
            if (pos == s.length()) {
                return node;
            }
            char c = s.charAt(pos);
            if (node == null) {
                node = new Node(c);
            }
            if (c == node.ch) {
                node.midCount++;
                node.mid = insert(node.mid, s, pos + 1);
            }
            else if (c < node.ch) {
                node.left = insert(node.left, s, pos);
            }
            else {
                node.right = insert(node.right, s, pos);
            }
            return node;
        }

        public static void find(StringBuffer sb, Node node, String s, int pos) {
            if (node == null || pos == s.length()) {
                return;
            }
            char c = s.charAt(pos);
            if (c == node.ch) {
                sb.append(node.ch);
                if (node.midCount > 1) {
                    find(sb, node.mid, s, pos + 1);
                }
            }
            else if (c < node.ch) {
                find(sb, node.left, s, pos);
            }
            else {
                find(sb, node.right, s, pos);
            }
        }
    }

    public ArrayList<String> prefix(List<String> a) {
        Node root = null;
        for (String s : a) {
            root = Node.insert(root, s, 0);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String s : a) {
            StringBuffer b = new StringBuffer();
            Node.find(b, root, s, 0);
            res.add(b.toString());
        }
        return res;
    }
}
