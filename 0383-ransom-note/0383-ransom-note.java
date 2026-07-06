class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freq[]=new int[26];
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        for(int i=0;i<magazine.length();i++){
            char ch= magazine.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            freq[ch-'a']--;

        }
        for(int i=0;i<26;i++){
            if(freq[i]<0){
                return false;
            }

        }
        return true ;
    }
}