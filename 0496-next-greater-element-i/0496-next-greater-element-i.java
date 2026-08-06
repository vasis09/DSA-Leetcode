class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        //we have to track the next greater element of nums2[] and store thier value in map !(like next greater 2 question)
        // backtrack ]
    for(int i=nums2.length-1;i>=0;i--){
        int curr=nums2[i];
        //if we found next greater elemnet. then remove top 
        while(!st.isEmpty() && curr>=st.peek()){
            st.pop();
        }
        //if stack is empty then store - 1 in current value 
        if(st.isEmpty()){ 
            map.put(curr,-1);
        }
        else{
            map.put(curr,st.peek());
        }

        st.push(curr);
    }
        //now call for nums1 elements present in map 
// create ans array;
    int ans[]=new int[nums1.length];

        for(int j=0;j<nums1.length;j++){
            ans[j]=map.get(nums1[j]);
        }
        

    return ans;


    }
}