class Solution {
    public int[] decrypt(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        int sum = 0;

        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += nums[i % n];
            }

            ans[0] = sum;

            for (int i = 1; i < n; i++) {
                sum = sum - nums[i % n] + nums[(i + k) % n];
                ans[i] = sum;
            }
        } 
        else {
            k = -k;

            for (int i = 1; i <= k; i++) {
                sum += nums[(n - i) % n];
            }

            ans[0] = sum;

            for (int i = 1; i < n; i++) {
                sum = sum - nums[(i - 1 - k + n) % n] + nums[(i - 1 + n) % n];
                ans[i] = sum;
            }
        }

        return ans;
    }
}