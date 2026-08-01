
        class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        // O(1) Short-circuit: Player 1 can always guarantee a win/tie if N is even
        if (n % 2 == 0) {
            return true;
        }
        
        // 1D DP array to track max net difference for subarray nums[i...j]
        int[] dp = nums.clone();
        
        // Process subarrays from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
    }
}