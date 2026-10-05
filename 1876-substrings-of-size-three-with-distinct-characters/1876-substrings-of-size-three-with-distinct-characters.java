class Solution {
    public int countGoodSubstrings(String str) {
       int ans = 0;
       for(int i=0;i<=str.length()-3;i++){
        char a = str.charAt(i);
        char b= str.charAt(i+1);
        char c= str.charAt(i+2);
        if(a!=b && b!=c && a!=c){
            ans++;
        }
       }
       return ans;
    }
}