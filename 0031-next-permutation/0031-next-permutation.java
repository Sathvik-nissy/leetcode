class Solution {
    public void nextPermutation(int[] nums) {
        int l=-1,r=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                l=i;
                break;
            }
        }

        if(l!=-1){
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[l]){
            int temp=nums[l];
            nums[l]=nums[i];
            nums[i]=temp;
            break;
            }
        }
        }

        reverse(nums,l+1,nums.length-1);

        
    }

    static void reverse(int nums[],int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;

        }
    }
}