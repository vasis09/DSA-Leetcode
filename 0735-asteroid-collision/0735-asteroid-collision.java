class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> stack =new Stack<>();
         for(int a: asteroids){
            while(!stack.isEmpty() && a<0 &&stack.peek()>0 && stack.peek()<-a){
                stack.pop();

            }
            if(!stack.isEmpty() && stack.peek()>0 && a<0){
                if(stack.peek()==-a){
                    stack.pop();
                }
                else{
                    continue;
                }}
                else{
                    stack.push(a);
                }

         }
            int ans[]=new int[stack.size()];
            for(int i=0;i<stack.size();i++){
                ans[i]=stack.get(i);


            }


        return ans; 
    }
    }