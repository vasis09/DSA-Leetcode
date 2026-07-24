class Solution {
    public int uniqueXorTriplets(int[] nums) {
    

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }
        
        boolean[] hasPair = new boolean[limit];
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                hasPair[nums[i] ^ nums[j]] = true;
            }
        }
        
        boolean[] hasTriplet = new boolean[limit];
        for (int pairXor = 0; pairXor < limit; pairXor++) {
            if (hasPair[pairXor]) {
                for (int num : nums) {
                    hasTriplet[pairXor ^ num] = true;
                }
            }
        }
        
        int count = 0;
        for (boolean b : hasTriplet) {
            if (b) count++;
        }
        return count;
    }
}