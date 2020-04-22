package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache3 {
    int capacity;
    LinkedList<Integer> keys = new LinkedList<>();
    Map<Integer, Integer> keyValues = new HashMap<>();

    public LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keys.isEmpty() || !keys.contains(key))
            return -1;
        //remove the key from the current position in the linked list
        keys.remove(keys.indexOf(key));
        keys.add(key);
        return keyValues.get(key);
    }

    public void put(int key, int value) {

        if (keys.contains(key)) {
            keyValues.remove(key);
            keys.remove(keys.indexOf(key));
            keys.add(key);
            keyValues.put(key, value);
            return;
        }

        if (keys.size() == capacity) {
            keyValues.remove(keys.get(0));
            keys.remove(0);
        }

        keys.add(key);
        keyValues.put(key, value);
    }

    /*public int findIndex(LinkedList<Integer> list, int key) {
        int index;
        for (index = 0; index < list.size(); index++) {
            if (list.get(index) == key)
                break;
        }
        return index;
    }*/
}
