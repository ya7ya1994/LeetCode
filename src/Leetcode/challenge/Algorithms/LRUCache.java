package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.List;

class LRUCache {
    int capacity;
    List<Cache> listCache = new ArrayList<>();

    class Cache {
        int key;
        int value;

        public Cache() {

        }

        public Cache(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        int i = 0;
        for (; i < listCache.size(); i++) {
            if (listCache.get(i).key == key) {
                value = listCache.get(i).value;
                break;
            }
        }
        if (value != -1) {
            Cache tempCache = new Cache(listCache.get(i).key, value);
            listCache.remove(listCache.get(i));
            listCache.add(tempCache);
        }
        return value;
    }

    public void put(int key, int value) {
        for (int i=0; i < listCache.size(); i++) {
            if (listCache.get(i).key == key) {
                listCache.add(new Cache(key,value));
                listCache.remove(i);
                return;
            }
        }
        if (listCache.size() == capacity)
            listCache.remove(0);
        Cache newCache = new Cache(key, value);
        listCache.add(newCache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * <p>
 * List<Cache> items; // 1 O(n) put and get
 * <p>
 * List<Integer> keys;
 * Map<Integer, Integer> keyValues; // 2 O(n) put and get
 * <p>
 * DoubleLinkedList<Integer> keys;
 * Map<Integer, Integer> keyValues; // 3 O(1) put and get
 */

/*
LRUCache cache = new LRUCache( 2 )

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */