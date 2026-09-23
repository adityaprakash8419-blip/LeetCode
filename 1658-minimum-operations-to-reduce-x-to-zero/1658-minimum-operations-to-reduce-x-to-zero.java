class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int n : nums) {
            total += n;
        }

        int target = total - x;
        int sum = 0, left = 0, maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}