import java.util.*;

public class LetterCombinationOfPhoneNumber {
    static String[] keys = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        
        char firstChar = digits.charAt(0);
        String str = keys[firstChar - '2'];
        
        if(digits.length() == 1) {
            for(int i=0; i<str.length(); i++) {
                res.add(String.valueOf(str.charAt(i)));
            }
            return res;
        }
        
        res = letterCombinations(digits.substring(1));
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<str.length(); i++) {
            for(String s: res) {
                ans.add(str.charAt(i)+s);
            }
        }
        
        return ans;
    }
}
