class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int odd = 0, even = 0;
        int m = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((nums1[i] & 1) == 1) {
                odd++;
            } else {
                even++;
            }

            m = Math.min(m, nums1[i]);
        }

        return odd == n || even == n || (m & 1) == 1;
    }
}