package com.codelab.lru;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

 Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor.
 Example :

 Input :
 capacity = 2
 set(1, 10)
 set(5, 12)
 get(5)        returns 12
 get(1)        returns 10
 get(10)       returns -1
 set(6, 14)    this pushes out key = 5 as LRU is full.
 get(5)        returns -1
 */
public class Solution {

    static class Node {
        public int value;
        public int key;
        public Node prev;
        public Node next;

        public String toString() {
            return key + " : " + value;
        }
    }

    private final int capacity;

    Map<Integer, Node> keyMap = new HashMap<>();
    Node start, end;

    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = this.keyMap.getOrDefault(key, null);
        if (n != null) {
            deleteAndMakeFirst(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node n = this.keyMap.getOrDefault(key, null);
        if (n != null) {
            n.value = value;
            deleteAndMakeFirst(n);
            return;
        }
        if (this.keyMap.size() == this.capacity) {
            this.keyMap.remove(end.key);
            end = end.prev;
            if (end != null) {
                end.next = null;
            }
        }
        n = new Node();
        n.key = key;
        n.value = value;
        this.keyMap.put(key, n);
        deleteAndMakeFirst(n);

    }

    private void deleteAndMakeFirst(Node n) {
        if (n == start) {
            return;
        }

        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        if (end == n) {
            end = n.prev;
        }
        n.prev = null;
        n.next = start;
        if (start != null) {
            start.prev = n;
        }
        start = n;
        if (end == null) {
            end = n;
        }
    }
}
