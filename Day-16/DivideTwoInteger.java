
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        boolean dividendNeg = false, divisorNeg = false;
        long divdend = dividend;
        if(divdend < 0) {
            divdend = -divdend;
            dividendNeg = true;
        }
        long dvisor = divisor;
        if(divisor < 0) {
            dvisor = -dvisor;
            divisorNeg = true;
        }
        long ans = 0;
        while(divdend >= dvisor) {
            long temp = dvisor;
            long count = 1;
            while(temp <= divdend) {
                temp <<= 1;
                count <<= 1;
            }
            ans += (count >> 1); // move 1 step back
            divdend -= (temp >> 1);
        }
        if((!dividendNeg && divisorNeg) || (dividendNeg && !divisorNeg)) {
            ans = -ans;
        }
        return ans>Integer.MAX_VALUE ? Integer.MAX_VALUE: (int)ans;
    }
}
