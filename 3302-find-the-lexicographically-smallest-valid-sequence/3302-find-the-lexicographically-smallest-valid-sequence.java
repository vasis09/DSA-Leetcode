

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // lastIndex[j] stores the maximum index in word1 from which 
        // the suffix word2[j...m-1] can be matched exact (0 modifications)
        int[] lastIndex = new int[m + 1];
        Arrays.fill(lastIndex, -1);
        lastIndex[m] = n; // Base case: empty suffix can be matched past end of word1

        int p2 = m - 1;
        for (int p1 = n - 1; p1 >= 0 && p2 >= 0; p1--) {
            if (word1.charAt(p1) == word2.charAt(p2)) {
                lastIndex[p2] = p1;
                p2--;
            }
        }

        int[] result = new int[m];
        boolean usedModification = false;
        int j = 0; // Index in word2

        for (int i = 0; i < n && j < m; i++) {
            boolean isMatch = (word1.charAt(i) == word2.charAt(j));

            if (isMatch) {
                result[j] = i;
                j++;
            } else if (!usedModification) {
                // Check if remaining suffix word2[j+1...] can fit after index i
                if (lastIndex[j + 1] > i) {
                    result[j] = i;
                    usedModification = true;
                    j++;
                }
            }
        }

        // If we couldn't match all m characters, no valid sequence exists
        return (j == m) ? result : new int[0];
    }
}