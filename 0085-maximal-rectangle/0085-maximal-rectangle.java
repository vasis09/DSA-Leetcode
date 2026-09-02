class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int maxArea=0;
        int heights[]=new int[cols];
     for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
             if(matrix[i][j]=='1'){
                heights[j]+=1;
             }else{
                heights[j]=0;
             }
        }
         maxArea=Math.max(maxArea,largestRectangleArea(heights));
        
     }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n =heights.length;
        int maxArea=0;
        Stack<Integer> stack =new Stack<>();
        //running for loop till n is coz of the imaginary number 0 at last of the height which is taken 0 coz of next smlller
        for(int j=0;j<=n;j++){
            int h=(j==n) ? 0 : heights[j];
            while (!stack.isEmpty() && h<heights[stack.peek()])
            {
                int height=heights[stack.pop()];
               int width= stack.isEmpty() ? j : j-stack.peek()-1;
               int area= height*width;
               maxArea=Math.max(maxArea,area);

            }
            stack.push(j);

        }
        return maxArea;
        
    }
}