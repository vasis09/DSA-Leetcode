class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
            set.add(num);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = minNum; i <= maxNum; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}