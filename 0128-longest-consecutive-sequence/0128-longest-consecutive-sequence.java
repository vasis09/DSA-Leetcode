class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length==0){
            return 0;
        }
        int ans=1;
        for(int num : nums){
            set.add(num);}
        for(int num : set){
            if (num == Integer.MIN_VALUE || !set.contains(num - 1)){  
                              int current =num;
                int len=1;
                while(current != Integer.MAX_VALUE && set.contains(current + 1)){
                    len++;
                    current++;

                }
                 ans = Math.max(ans,len);
            }
        }
        return ans;
        
    }
}