import java.util.*;

class LFUCache {
    Map<Integer, Integer> keyVal;
    Map<Integer, Integer> keyCount;
    Map<Integer, LinkedHashSet<Integer>> countList;
    int size;
    int maxCapacity;
    int min;
    
    public LFUCache(int capacity) {
        keyVal = new HashMap<>();
        keyCount = new HashMap<>();
        countList = new HashMap<>();
        maxCapacity = capacity;
        size = 0;
        min = 1;
        countList.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyVal.containsKey(key)) {
            return -1;
        }
        
        int currCount = keyCount.get(key);
        countList.get(currCount).remove(key);
        if(currCount == min && countList.get(currCount).size() == 0) {
            min++;
        }
        
        currCount++;
        if(!countList.containsKey(currCount)) {
            countList.put(currCount, new LinkedHashSet<>());
        }
        countList.get(currCount).add(key);
        keyCount.put(key, currCount);
        
        return keyVal.get(key);
    }
    
    public void put(int key, int value) {
        if(maxCapacity == 0) {
            return;
        }
        
        if(keyVal.containsKey(key)) {
            keyVal.put(key, value);
            get(key);
            return;
        }
        
        if(size == maxCapacity) {
            int deletedKey = countList.get(min).iterator().next();
            keyVal.remove(deletedKey);
            keyCount.remove(deletedKey);
            countList.get(min).remove(deletedKey);
            size--;
        }
        min = 1;
        size++;
        keyVal.put(key, value);
        keyCount.put(key, 1);
        countList.get(1).add(key);
    }
}
