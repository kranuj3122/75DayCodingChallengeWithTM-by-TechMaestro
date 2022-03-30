import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        
        if(numRows == 1) {
            return ans;
        }
        for(int i=1; i<numRows; i++) {
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(1);
            for(int j=1; j <= i-1; j++) {
                temp2.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            temp2.add(1);
            ans.add(temp2);
        }
        return ans;
    }
}
