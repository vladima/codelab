package com.codelab.listcycle;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Try solving it using constant additional space.
 * <p>
 * Example :
 * <p>
 * Input :
 * <p>
 * ______
 * |     |
 * \/    |
 * 1 -> 2 -> 3 -> 4
 * <p>
 * Return the node corresponding to node 3.
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while (true) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
            if (fast == null) {
                return null;
            }
            if (fast == slow) {
                break;
            }
        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

