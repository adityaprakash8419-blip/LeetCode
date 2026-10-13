class Solution {
    public int fib(int n) {
        if(n==0){
            return n;
        }else if(n==1){
            return 1;
        }else{
             return fib(n-1)+fib(n-2);
        }
    }
    public int fiba(int num){
        return fib(num);
    }
}