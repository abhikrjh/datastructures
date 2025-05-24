package common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<k,v> extends LinkedHashMap<k,v> {

    private final int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75f, true); // LinkedHashMap constructor call (true enable access order)
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k,v> eldestEntry){
        return size() > capacity;
    }


    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.get(1); // accessing 1 to making it most recently used
        cache.put(3, "three");

        System.out.println(cache.entrySet());
    }
}
