class Solution {
    public long subArrayRanges(int[] nums) {
        int n= nums.length;
        Stack<Integer>st=new Stack<>();
        int PSE[]=new int[n];
        int NSE[]=new int[n];
        int NGE[]=new int[n];
        int PGE[]=new int [n];

        //pse

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]<nums[st.peek()]){
                st.pop();
            }if(st.isEmpty()){
                PSE[i]=i+1;

            }else{
                PSE[i]=i-st.peek();
            }
            st.push(i);
        }
        st.clear();

        //NSE
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                NSE[i]=n-i;
            }
            else{
                NSE[i]=st.peek()-i;
            } 
            st.push(i);
        }
        st.clear();
         long min=0;
        for(int i=0;i<n;i++){
            min+=(long) nums[i]*NSE[i]*PSE[i];
        }
    
    //nge
    for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
        st.pop();
    }
    if(st.isEmpty()){
        NGE[i]=n-i;
    }else{
        NGE[i]=st.peek()-i;
    }
    st.push(i);
    
}
st.clear();

//PGE
for(int i=0;i<n;i++ ){
    while(!st.isEmpty() && nums[i]>nums[st.peek()]){
        st.pop();
    }if(st.isEmpty()){
        PGE[i]=i+1;
    }else{
        PGE[i]=i-st.peek();
    }
    st.push(i);

}
long max=0;
for(int i=0;i<n;i++){
    max+=(long)nums[i]*NGE[i]*PGE[i];

}

long range=0;

return range=max-min;
}}