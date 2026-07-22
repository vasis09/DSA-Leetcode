class Solution {
    public String minWindow(String s, String t) {
        int right=0; int left=0; int count=0; int start=-1; 
        int need[]=new int[256];
        int minlen=Integer.MAX_VALUE;
    // count frequeny of what we need like count freq of t and then check it on s 
    for(char ch : t.toCharArray()){
        need[ch]++;
    }
    // now check need of chars in s if we found (char at s )then reduce need(like we dont need now we got )
    // like if s=ABC t=AB need[A]=1 at 0 b=1 c=1,,,,, if(char at(right))means at s need>0 that means we got our char then reduce the need(coz we got it ) freq[ch(left)]--; as we got it and count ++ like 
    // now A=0;,b=1,c=1 we found A in s from t now we dont need A anymore so 

//our window is valid 
    while(right<s.length()){
        char ch = s.charAt(right);
        if(need[ch]>0){
            count ++;
        }
        need[ch]--;

        while(count==t.length()){
            
            // minlen update required 
        if(right-left+1<minlen){
            minlen=right-left+1;
            start=left;
        }
        //after removing left we will be adding freq if(a) is removed then need =1 from 0 then 
        char sh=s.charAt(left);
        need[sh]++;
        
        if(need[sh] > 0){
    count--; 
        } left++;
       
        


    }
    right++;
    }
    if(start==-1){
        return "";
    }
    return s.substring(start,start+minlen);

    





    }
}