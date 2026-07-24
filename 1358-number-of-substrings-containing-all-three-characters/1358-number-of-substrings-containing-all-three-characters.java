class Solution {
    public int numberOfSubstrings(String s) {
        int ans =0;
        int right =0;
        int left=0;
        int freq[]= new int[3];
        while(right<s.length()){
           char ch = s.charAt(right);
           freq[ch-'a']++;

           while(freq[0]>0 && freq[1]>0 && freq[2]>0){
            freq[s.charAt(left)-'a']--;
            left++;
            

           }
           ans +=left;
           right++;
        }
        return ans ;
    }
}