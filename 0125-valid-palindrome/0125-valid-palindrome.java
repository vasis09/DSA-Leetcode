class Solution {
    public boolean isPalindrome(String s) {
        int r =s.length()-1;
        int l =0;
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
           else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else{
            char left=Character.toLowerCase(s.charAt(l));
            char right=Character.toLowerCase(s.charAt(r));
        if(left!=right){
            return false;
        }
        l++;
        r--;}
        } return true;

        }
    }
