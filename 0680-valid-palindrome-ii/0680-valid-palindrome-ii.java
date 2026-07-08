class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left =0;
        int right =n-1;
        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
               left++;
               right--;
            }else{
            return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
        }}
        return true ;
    }

    boolean isPalindrome(String s,int lft,int right){
        while(lft<right){
        if(s.charAt(lft)!=s.charAt(right)){
            return false;
        }
        lft++;
        right--;}
        return true ;

    }
   
}
