class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        // count frequency 
        for(int num :nums){
            //either num or 0 will be selected then count freq properly
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //create list 
        List<Integer>[] bucket=new ArrayList[n+1];

        //fill bucket 
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num =entry.getKey();

            int freq= entry.getValue();
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        //bucket[3]-------->>>>>>1 means 1 having 3 freq 

        //add ans in list 

        List<Integer> ans= new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
           if(bucket[i]!=null){
            for(int num: bucket[i]){
                ans.add(num); 
            
            if(ans.size()==k){
                int result[]=new int[k];
                for(int j=0;j<k;j++){
                    result[j]=ans.get(j);
                }
                return result;
            }
        

            }
           }
        }
        return new int[0];
     
    }} 