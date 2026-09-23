class Solution {
    public int minOperations(int[] nums, int x) {
        //Arrays.sort(nums);
        int l=0,sum=0;
        int res=-1;
        int t=0,tar=0;
        for(int k:nums){
            t=t+k;
        }
        tar=t-x;
        if(tar<0)return -1;
        if(tar==0)return nums.length;
        for(int r=0;r<nums.length;r++){
            sum=sum+nums[r];
            while(sum>tar){
                sum-=nums[l];
                l++;
            }
            if(sum==tar){
                if (res == -1) {
                    res = r - l + 1;
                } else {
                        res = Math.max(res, r - l + 1);
                }
            }
        }
if (res == -1) return -1;
return nums.length - res;
        
    }
}