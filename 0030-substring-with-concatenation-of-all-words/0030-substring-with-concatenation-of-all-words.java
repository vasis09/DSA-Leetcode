class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
       
        List<Integer> res = new ArrayList<>();
        int len = words[0].length(), k = words.length, n = s.length();
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) counts.put(w, counts.getOrDefault(w, 0) + 1);

        for (int i = 0; i < len; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i, count = 0;

            for (int right = i; right + len <= n; right += len) {
                String word = s.substring(right, right + len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (seen.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += len;
                    }
                    if (count == k) res.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = right + len;
                }
            }
        }
        return res;
    }
}