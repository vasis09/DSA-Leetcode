class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> map=new HashMap<>();
        for(String word : strs){
            char[] arr =word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
 // check if key already exist in hashmap then add word 
   if(map.containsKey(key)){
    map.get(key).add(word);
   }       
   // else create arraylist key then put words into them into map 
   else{
        List<String> val=new ArrayList<>();
        val.add(word);
        map.put(key,val);
   }
   }
return new ArrayList<>(map.values());

        
    }

    }
