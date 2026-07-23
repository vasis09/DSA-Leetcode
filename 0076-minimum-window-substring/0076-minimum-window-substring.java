class Solution {
    public String minWindow(String s, String t) {
        int right =0; int left =0; int minlen=Integer.MAX_VALUE;
        int count =0; int start =-1;
        int need[]= new int [128];
         // frequency count ;

         for(char ch : t.toCharArray()){
            need[ch]++; // we have succesfully counted the freq of t ; 
         }

         //check if(char is present in s string how will we check that ?  ) by checking the chatAt(s) has freq need[ch]>0; then that means we found char of t in s then we will reduce the need[ch] that we dont need that one in next step as we have already found .... also when we increase count more ++ when we found the char in s ? how 
         // run a while loop  that track right till last \\\
         while (right <s.length()) {
            char ch = s.charAt(right);
            if(need[ch]>0){ // that means char of t exist in s 
            count++;
            
            } 
            need[ch]--;
            // if(windwo is valid then shrink it ) when will be valid ? when all char of t prsent in s 
            // means count ==t.len().  

            while(count==t.length()){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
                char sh=s.charAt(left);
                need[sh]++; 
                //remove count when we have need and not get that char 
                if(need[sh]>0){
                    count --;
                }
                left++;
                
            }
            right++;


         }
         if(start==-1){
            return "";
         }
         return s.substring(start,start+minlen);

    }
}