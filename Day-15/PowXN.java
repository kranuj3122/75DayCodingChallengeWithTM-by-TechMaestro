
public class PowXN {
    public double myPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        double power = Math.pow(x, Math.abs((long)n));
        if(n < 0) {
            power = 1.0 / power;
        }
        power = (long)(power*100000) / 100000.0;
        return power;
    }
}
