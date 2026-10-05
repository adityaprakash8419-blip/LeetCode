class Solution {
    public int searchInsert(int[] nums, int target) {
        
       /* int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>= target) return i;

        }
        return n;*/
        int n= nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                //System.out.println(mid);
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        //System.out.println(left);
        return left;
    }
}