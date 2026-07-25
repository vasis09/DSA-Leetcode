class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);

    }
    private int atmost(int []nums,int k){
         int r=0;int l=0;int count =0;
        int oddcount=0;
        while(r<nums.length){
           oddcount+=nums[r]%2;
            while(oddcount>k){
                oddcount-=nums[l]%2;
                l++;
            }
            count+=(r-l)+1;
            r++;
    
 
    }
     return count;

    }
    }