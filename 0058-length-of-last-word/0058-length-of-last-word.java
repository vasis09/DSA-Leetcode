class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int l = n-1;
        while(l>=0 && s.charAt(l)==' '){
            l--;
        }
        int count =0;
        while(l>=0 && s.charAt(l)!=' '){
            count++;
            l--;
        }
        return count ;

        
    }
}