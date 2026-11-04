class Solution {
    public int fib(int n) {
        int prev0 =0;
        int prev1=1;

        if(n<=1){
            return n;
        }

        for(int i=2;i<=n;i++){
            int temp = prev0+ prev1;
            prev0=prev1;
            prev1=temp;
        }
        return prev1;
        
    }
}