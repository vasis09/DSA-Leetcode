class Solution {
    public double myPow(double x, int n) {
        long ex=n;
        
        if(ex<0){
        return 1.0/func(x,-ex);
        
        }
        return func(x,ex);
    }
    double func(double x,long n){
        if(n==0){
            return 1.0;
        }
        if(n%2!=0){
            return x* func(x*x,n/2);
        }
        else{
            return func(x*x,n/2);
        }

    }
}