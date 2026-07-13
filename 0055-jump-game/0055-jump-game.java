class Solution {
    public boolean canJump(int[] nums) {
       
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int furthestReachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Edge Case Failure: If our current index is past the furthest we can reach, 
            // it means we've hit a trapped zero and can't move forward.
            if (i > furthestReachable) {
                return false;
            }
            
            // Update the furthest index we can reach from the current position
            furthestReachable = Math.max(furthestReachable, i + nums[i]);
            
            // Optimization: If we can already reach or pass the last index, return true early
            if (furthestReachable >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}