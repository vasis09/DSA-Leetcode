class Solution {
    public String reverseWords(String s) {
        char[] arr =s.toCharArray();
        int n=arr.length;
        int left =0;
        
        for(int i=0;i<n;i++){
            if(arr[i]==' ' || i==n-1){
                int right;
                if(arr[i]==' '){
                    right=i-1;}
                    else{
                        right=i;
                    }
                    int l=left;
                    int r= right;
                    while(l< r){
                        char temp =arr[l];
                        arr[l]=arr[r];
                        arr[r]=temp;
                        l++;
                        r--;
                          }
                          left=i+1;
                    }
                    }
                    return new String(arr);
        
    }
}