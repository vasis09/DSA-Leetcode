class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;int right=0; int maxlen=0; int maxfreq=0;
        int freq[]=new int[26];
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[ch-'A']++;
            maxfreq=Math.max(maxfreq,freq[ch-'A']);
        
    
        while((right-left+1)-maxfreq>k){
            freq[s.charAt(left)-'A']--;
            left++;
        }
        maxlen=Math.max(maxlen,right-left+1);
    right++;
    }
    return maxlen;
    }
    
}