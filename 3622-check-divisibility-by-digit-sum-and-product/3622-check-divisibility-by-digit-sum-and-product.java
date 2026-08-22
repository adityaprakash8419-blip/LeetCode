class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0, p = 1;

        for (int i = n; i != 0; i /= 10) {
            int x = i % 10;
            p *= x;
            s += x;
        }

        return n % (p + s) == 0;
    }
}