
public class TimeBaseKeyValueStore {
    Map<String, TreeMap<Integer, String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)) {
            mp.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> tMap = mp.get(key);
        tMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tMap = mp.get(key);
        // System.out.println(tMap.toString());
        Integer k = tMap.floorKey(timestamp);
        if(k == null) {
            return "";
        }
        return tMap.get(k);
    }
}
