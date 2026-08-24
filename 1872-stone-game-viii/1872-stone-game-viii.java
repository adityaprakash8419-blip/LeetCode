class Solution {
    public int stoneGameVIII(int[] stones) {
       int sum =0;
       for(int x: stones){
        sum+= x;
       } 
       int r=sum;
       for(int i=stones.length-2;i>0;i--){
        sum -= stones[i+1];
        r= Math.max(r,sum-r);
       }
       return r;
    }
}