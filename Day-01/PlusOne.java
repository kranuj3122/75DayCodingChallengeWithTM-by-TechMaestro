
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        int i = n-1;
        while(i>=0 && carry != 0) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
            i--;
        }
        if(carry == 0) {
            return digits;
        }
        int[] newDigits = new int[n+1];
        newDigits[0] = carry;
        for(i=1; i<=n; i++) {
            newDigits[i] = digits[i-1];
        }
        return newDigits;
    }
}
