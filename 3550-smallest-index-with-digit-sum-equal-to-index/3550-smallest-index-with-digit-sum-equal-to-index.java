class Solution {
    public int smallestIndex(int[] nums) {
        int i=0;
        for( i=0;i<nums.length;i++){
            int res=0;
            int n=nums[i];
            while(n>0){
                int r=n%10;
                res+=r;
                n=n/10;
            }
            if(i==res)
            return i;
            
        }
        return -1;
        
    }
}