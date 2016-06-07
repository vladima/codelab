package com.codelab.mergeklist;

import com.codelab.ListNode;

import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Example :
 * <p>
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 * <p>
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> a) {
        ListNode r = a.get(0);
        for (int i = 1; i < a.size(); ++i) {
            r = merge(r, a.get(i));
        }
        return r;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode current = null;

        if (a == null) return b;
        if (b == null) return a;

        while (true) {
            if (a == null) {
                current.next = b;
                break;
            }
            if (b == null) {
                current.next = a;
                break;
            }
            ListNode r;
            if (a.val < b.val) {
                r = new ListNode(a.val);
                a = a.next;
            }
            else {
                r = new ListNode(b.val);
                b = b.next;
            }
            if (head == null) {
                head = r;
            }
            if (current != null) {
                current.next = r;
            }
            current = r;
        }
        return head;
    }
}
