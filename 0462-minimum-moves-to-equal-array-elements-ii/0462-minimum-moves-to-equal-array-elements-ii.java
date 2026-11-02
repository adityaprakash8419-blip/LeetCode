class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length/2];
        int moves = 0;
        for(int num:nums){
        moves = moves + Math.abs(num - a);        }
        return moves;
        
    }
}