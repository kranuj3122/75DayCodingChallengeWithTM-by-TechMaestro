
public class VerifyingAlienDictionary {
    static int[] priority;
    static int isBigger(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        for(int i=0; i<Math.min(m,n); i++) {
            int p1 = priority[s1.charAt(i)-'a'];
            int p2 = priority[s2.charAt(i)-'a'];
            if(p1 != p2) {
                return p1-p2;
            }
        }
        return m - n;
    }
    public boolean isAlienSorted(String[] words, String order) {
        priority = new int[26];
        for(int i=0; i<order.length(); i++) {
            priority[order.charAt(i)-'a'] = i;
        }
        for(int i=1; i<words.length; i++) {
            if(isBigger(words[i-1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
