import java.util.*;

public class InsrtDelGetRndmO1DupliAllow {
    Map<Integer, Set<Integer>> mp;
    List<Integer> list;
    public InsrtDelGetRndmO1DupliAllow() {
        mp = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean flag = false;
        if(!mp.containsKey(val)) {
            mp.put(val, new HashSet<>());
        }
        Set<Integer> s = mp.get(val);
        if(s.size() == 0) {
            flag = true;
        }
        s.add(list.size());
        list.add(val);
        return flag;
    }
    
    public boolean remove(int val) {
        if(!mp.containsKey(val) || mp.get(val).size() == 0) {
            return false;
        }
        
        Set<Integer> s = mp.get(val);
        int ind = -1;
        for(int i: s) {
            ind = i;
            break;
        }
        s.remove(ind);
        
        int n = list.size();
        int lastVal = list.get(n-1);
        list.set(ind, lastVal);
        list.remove(n-1);
    
        if(ind != n-1) {
            mp.get(lastVal).remove(n-1);
            mp.get(lastVal).add(ind);
        }
        return true;
    }
    
    public int getRandom() {
        int randVal = ((int)(Math.random()*1000000));
        int randIndex = randVal % list.size();
        return list.get(randIndex);
    }
}
