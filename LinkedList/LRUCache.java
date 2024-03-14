
/*
 * 146. LRU Cache
 * [https://leetcode.com/problems/lru-cache/description/]
 */

package LinkedList;

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    public int key;
    public int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    LinkedList<Node> list = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node presentNode = map.get(key);
            list.remove(presentNode);
            list.addFirst(presentNode);
            return presentNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.get(key) != null) {
            Node presentNode = map.get(key);
            presentNode.value = value;
            list.remove(presentNode);
            list.addFirst(presentNode);
            // if the key is already present,
            // and place that node in list at first place
        } else {
            if (map.size() < capacity) {
                map.put(key, newNode);
                list.addFirst(newNode);
            } else {
                Node lastNode = list.removeLast();
                map.remove(lastNode.key);
                list.addFirst(newNode);
                map.put(key, newNode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */