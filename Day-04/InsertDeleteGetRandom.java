
public class InsertDeleteGetRandom {
    List<Integer> list; // {value,......}
    Map<Integer, Integer> mp; // <value, index>
    public RandomizedSet() {
        list = new ArrayList<>();
        mp = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)) {
            return false;
        }
        mp.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!mp.containsKey(val)) {
            return false;
        }
        // swapping curr val to the last val
        // remove last element;
        int ind = mp.get(val);
        int lastInd = list.size() - 1;
        int lastVal = list.get(lastInd);
        list.set(ind, lastVal);
        list.set(lastInd, val);

        list.remove(lastInd);
        mp.put(lastVal, ind);
        mp.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randIndex = (int)(Math.random()*1000000) % list.size();
        // System.out.println(randIndex);
        return list.get(randIndex);
    }
}
