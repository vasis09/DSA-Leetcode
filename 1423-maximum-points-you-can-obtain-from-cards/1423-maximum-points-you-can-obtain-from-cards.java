class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum =0; int rightsum=0;
        int right=cardPoints.length-1;
        for(int i=0;i<k;i++){
            leftsum+=cardPoints[i];
            
        }
        int maxsum=leftsum;
        for(int i=k-1;i>=0;i--){
            leftsum-=cardPoints[i];
            rightsum+=cardPoints[right];
            right--;
            maxsum=Math.max(maxsum,leftsum+rightsum);
        }
        return maxsum;

        
    }
}