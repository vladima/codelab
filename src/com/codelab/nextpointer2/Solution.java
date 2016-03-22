package com.codelab.nextpointer2;


public class Solution {
    public static class TreeLinkNode {
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;
        public int val;

        public TreeLinkNode(int val) {
            this.val = val;
        }
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    private class Queue {
        TreeLinkNode head;
        TreeLinkNode tail;

        public void enqueue(TreeLinkNode n) {
            if (isEmpty()) {
                n.next = null;
                head = n;
                tail = n;
            }
            else {
                tail.next = n;
                tail = n;
                tail.next = null;
            }
        }

        public TreeLinkNode dequeue() {
            TreeLinkNode n = head;
            if (head.next == null) {
                tail = null;
            }
            head = head.next;
            return n;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode marker = new TreeLinkNode(-1);
        Queue queue = new Queue();

        queue.enqueue(root);
        queue.enqueue(marker);

        TreeLinkNode lastNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode n = queue.dequeue();
            if (n == marker && lastNode == marker) {
                break;
            }
            if (n == marker) {
                if (lastNode != null) {
                    assert lastNode.next == marker;
                    lastNode.next = null;
                }
                lastNode = n;
                queue.enqueue(marker);
                continue;
            }
            lastNode = n;
            if (lastNode.left != null) {
                queue.enqueue(lastNode.left);
            }
            if (lastNode.right != null) {
                queue.enqueue(lastNode.right);
            }
        }
    }
}
