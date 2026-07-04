class Solution {
    public String toLowerCase(String s) {
        String ans="";
        int n = s.length();
        for (int i=0;i<n;i++){
            char chr=s.charAt(i);
            if(chr>='A' && chr<='Z'){
                chr=(char)(chr+('a'-'A'));
            }
            ans=ans+chr;
        }
return ans;
    }
    
}