package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache2 {
    int capacity;
    List<Integer> keys = new ArrayList<>();
    Map<Integer, Integer> keyValues = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keys.contains(key))
            return -1;
        int index = findIndex(keys, key);
        int value = keyValues.get(key);
        // remove found key/value from the List and from the map
        keys.remove(index);
        //keyValues.remove(key, value);
        // add key/value to the end of the List and to the map
        keys.add(key);
        //keyValues.put(key, value);

        return value;
    }

    public void put(int key, int value) {
        if (keys.contains(key)) {
            int index = findIndex(keys, key);
            keyValues.remove(key,keyValues.get(key));
            keys.remove(index);
            keys.add(key);
            keyValues.put(key, value);
            return;
        }
        if (keys.size()==capacity)
        {
            keyValues.remove(keys.get(0));
            keys.remove(0);
        }
        keys.add(key);
        keyValues.put(key, value);

    }

    public int findIndex(List<Integer> list, int key) {
        int index;
        for (index = 0; index < list.size(); index++) {
            if (list.get(index) == key)
                break;
        }
        return index;
    }
}
