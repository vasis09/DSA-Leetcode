class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int leftmax=0;
        int rightmax=0;
    int left=0;
    int right =n-1;
    int water =0;

while(left<right){
    if(height[left]<=height[right]){
        leftmax=Math.max(leftmax,height[left]);
        water+=leftmax-height[left];
        left++;
    }
    else{
        rightmax=Math.max(rightmax,height[right]);
        water+=rightmax-height[right];
        right--;

    }

}
return water;

    }
}