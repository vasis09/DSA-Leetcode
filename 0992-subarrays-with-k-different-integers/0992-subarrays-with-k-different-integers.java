class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);}



        private int atmost(int[] nums,int k){
        int right =0;int left=0; int ans=0; int diff=0;
        int n=nums.length+1;
        int []freq=new int [n];
        if(nums.length==0||k==0){
            return 0;
        }
        while(right<nums.length){
            if(freq[nums[right]]==0){
            diff++;
        }
         freq[nums[right]]++;
        while(diff>k){
            freq[nums[left]]--;

            if(freq[nums[left]]==0){
                diff--;
            }
            left++;

        }

        ans+=right-left+1;
                right++;

        }
        return ans;
        
    }
}