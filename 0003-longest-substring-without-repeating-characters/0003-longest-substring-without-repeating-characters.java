class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right=0; int left=0;
        int maxlen=0;
        HashSet<Character> set= new HashSet<>();
        while(right<s.length()){
            char ch =s.charAt(right);
            // we found char of s already in set then we remove the leftmost and move forward left++ then right++ 
            if(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            

            if(!set.contains(ch)){
                set.add(ch);

            maxlen=Math.max(maxlen,right-left+1);
             right++;
            }

        }
        return maxlen;


    }
}