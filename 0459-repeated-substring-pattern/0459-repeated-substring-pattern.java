class Solution {
    public boolean repeatedSubstringPattern(String s) { 
    for(int len =1;len<=s.length()/2;len++){
        if(s.length()%len!=0){
            continue;
        }
        String sub=s.substring(0,len);
        String temp="";
        int time=s.length()/len;
        for(int i=0; i< time;i++){
            temp+=sub;
        }
        if(temp.equals(s)){
            return true;
        }
        
    }
        return false;
        
    }
}