class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum =0;
        int count =0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            //check if have we seen this sum ? 
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);

            }//save the present for fufture 
         map.put(sum,map.getOrDefault(sum,0)+1);
        
        }
        return count ;
        
    }
}