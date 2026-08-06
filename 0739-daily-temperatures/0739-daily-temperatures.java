class Solution {
    public int[] dailyTemperatures(int[] temp) {
        //create stack (monotonic stack)
        Stack <Integer> st= new Stack<>();
        int ans[]=new int[temp.length];
    
    //track the temp from back to front if current is > stack top then pop and curr becomes top

for(int i=temp.length-1;i>=0;i--){
    while(!st.isEmpty() && temp[i]>=temp[st.peek()]){
        st.pop();
    }
    if(!st.isEmpty()){
        ans[i]=st.peek()-i;
    }
    st.push(i);

}
        return ans;
    }
}