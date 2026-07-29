
        class Solution {
    private static final long LIMIT = 1000001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        int totalHalfLen = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            totalHalfLen += half[i];
            if (freq[i] % 2 != 0) {
                mid = (char) ('a' + i);
            }
        }

        // Total possible distinct palindromes
        if (countPermutations(half, totalHalfLen) < k) {
            return "";
        }

        // Build the left half character by character
        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < totalHalfLen; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (half[ch] == 0) continue;

                half[ch]--; // Try placing 'a' + ch
                long ways = countPermutations(half, totalHalfLen - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    half[ch]++; // Backtrack and try next character
                }
            }
        }

        // Construct final palindrome
        StringBuilder ans = new StringBuilder(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    // Helper method to compute permutations of remaining half characters
    private long countPermutations(int[] cnt, int total) {
        long res = 1;
        int rem = total;
        for (int i = 0; i < 26; i++) {
            int c = cnt[i];
            for (int j = 1; j <= c; j++) {
                res = res * (rem - c + j) / j;
                if (res > LIMIT) return LIMIT;
            }
            rem -= c;
        }
        return Math.min(res, LIMIT);
    }
}
    