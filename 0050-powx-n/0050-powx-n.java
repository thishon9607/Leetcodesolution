class Solution {

    public double myPow(double x, int n) {

        // long handles Integer.MIN_VALUE safely
        long N = Math.abs((long) n);

        double ans = recursion(x, N);

        // x^-n = 1 / x^n
        return n < 0 ? 1 / ans : ans;
    }

    public double recursion(double x, long n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        // Reduce problem size by half
        double temp = recursion(x, n / 2);

        if (n % 2 == 0) {

            // x^n = x^(n/2) × x^(n/2)
            return temp * temp;

        } else {

            // x^n = x × x^(n/2) × x^(n/2)
            return x * temp * temp;
        }
    }
}