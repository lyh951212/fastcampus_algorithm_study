package heap;

import java.util.*;

//Runtime
//117 ms
//Memory
//127.8 MB
class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;
    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(linkedHashMap.containsKey(key))
            return linkedHashMap.get(key);

        return -1;
    }

    public void put(int key, int value) {
        if(!linkedHashMap.containsKey(key)) {
            if(linkedHashMap.size() >= this.capacity)
            {
                int leastUsedKey = linkedHashMap.keySet().iterator().next();
                linkedHashMap.remove(leastUsedKey);
            }
        }

        linkedHashMap.put(key, value);
    }
}

/* 시간 초과 난 코드
class LRUCache {

    HashMap<Integer, Integer> hm;
    int capacity;
    ArrayList<Integer> order = new ArrayList<>();
    public LRUCache(int capacity) {
        hm = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hm.containsKey(key))
        {
            order.add(order.remove(order.indexOf(key)));
            return hm.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key))
            order.add(order.remove(order.indexOf(key)));
        else {
            if(hm.size() >= this.capacity)
                hm.remove(order.remove(0));

            order.add(key);
        }

        hm.put(key, value);
    }
}
*/

public class leetcode_146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);                     // cache is {1=1, 2=2}
        lRUCache.put(1, 1);                     // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(2));    // return 3
    }
}
