class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int MOD = 1000000007;
        int left[]=new int[n];
        int right[]=new int [n];
        Stack<Integer>st = new Stack<>();
        
        //Previous smaller Element PSE
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();

            }
            if(st.isEmpty()){
                left[i]=i+1;
            }
            else{
                left[i]=i-st.peek();//(current-PSE);
            }
            st.push(i);

        }
        st.clear();

        //Next Smaller element NSE //loop from back to front 
        //right = NSE-current
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();

            }
            if(st.isEmpty()){
                right[i]=n-i;
            }
            else{
                right[i]=st.peek()-i;//NSE-current;

            }
            st.push(i);

        }
        //contribution 
        long ans =0;
        for(int i=0;i<n;i++){
            ans=(ans+(long) arr[i]*left[i]*right[i])%MOD;
        }
        return (int) ans ;

    }
}