class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] words=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character,String> map=new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String val= words[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(val)){
                    return false ;
                }}
                if(map2.containsKey(val)){
                if(!map2.get(val).equals(ch)){
                    return false;
                }}
                {
                    map.put(ch,val);
                    map2.put(val,ch);

                }

                }
                return true ;
                

            }
        }
        