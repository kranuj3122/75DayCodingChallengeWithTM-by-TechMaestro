import java.util.*;

public class InvalidTransaction {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];
        int i = 0;
        for(String s: transactions) {
            String[] t = s.split(",");
            name[i] = t[0];
            time[i] = Integer.parseInt(t[1]);
            amount[i] = Integer.parseInt(t[2]);
            city[i] = t[3];
            i++;
        }
        boolean[] notValid = new boolean[n];
        for(i=0; i<n; i++) {
            if(amount[i] > 1000) {
                notValid[i] = true;
            }
            for(int j=i+1; j<n; j++) {
                if(name[i].equals(name[j]) && Math.abs(time[i]-time[j])<=60 && !city[i].equals(city[j])) {
                    notValid[i] = true;
                    notValid[j] = true;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(i=0; i<n; i++) {
            if(notValid[i]) {
                ans.add(transactions[i]);
            }
        }
        return ans;
    }
}
