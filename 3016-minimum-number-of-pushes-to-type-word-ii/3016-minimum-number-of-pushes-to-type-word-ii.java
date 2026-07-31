
class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);
        
        int totalPushes = 0;
        // Iterate backwards from highest frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            
            int rank = 25 - i; // 0-indexed rank among non-zero frequencies
            int pushesPerChar = (rank / 8) + 1;
            totalPushes += freq[i] * pushesPerChar;
        }
        
        return totalPushes;
    }
}