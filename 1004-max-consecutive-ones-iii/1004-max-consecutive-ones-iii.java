class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int countzero=0;
        int ans=0;
for(int r=0;r<n;r++){
    if(nums[r]==0){
        countzero++;
    
}
    while(countzero>k){
        if(nums[left]==0){
            countzero--;
        }
        left++;

    }
    ans=Math.max(ans,r-left+1);
 
}return ans;
}

    }
