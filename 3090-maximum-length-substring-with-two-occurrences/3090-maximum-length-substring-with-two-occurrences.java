class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'a']++;

            // Shrink window if the current character appears more than twice
            while (count[currentChar - 'a'] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}