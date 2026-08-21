class Solution {

    long gcd(long x, long y) {
        return y != 0 ? gcd(y, x % y) : x;
    }

    long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }

    void dfs(int[] v, long s, long x, int ind, int num, long[] ans) {
        if (x > s) return;

        if (ind >= v.length) {
            if (num == 0) return;

            if (num % 2 == 1)
                ans[0] += s / x;
            else
                ans[0] -= s / x;

            return;
        }

        dfs(v, s, x, ind + 1, num, ans);
        dfs(v, s, lcm(x, v[ind]), ind + 1, num + 1, ans);
    }

    public long findKthSmallest(int[] coins, int k) {

        long left = k;
        long right = (long) getMax(coins) * k;

        while (left <= right) {
            long mid = (left + right) >> 1;

            long[] count = {0};

            dfs(coins, mid, 1, 0, 0, count);

            if (count[0] >= k)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right + 1;
    }

    int getMax(int[] coins) {
        int max = coins[0];

        for (int x : coins) {
            if (x > max)
                max = x;
        }

        return max;
    }
}