class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] r = new long[k];
        int[] dp = new int[k];

        for (int x : nums) {
            x %= k;

            int[] temp = new int[k];
            temp[x] = 1;

            for (int i = 0; i < k; i++) {
                temp[(i * x) % k] += dp[i];
            }

            for (int i = 0; i < k; i++) {
                dp[i] = temp[i];
                r[i] += dp[i];
            }
        }

        return r;
    }
}