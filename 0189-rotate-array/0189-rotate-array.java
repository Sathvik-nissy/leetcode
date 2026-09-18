class Solution {
    public void rotate(int[] nums, int k) {

        // int index=0;
        // k = k % nums.length;
        // int p[]=new int[nums.length];
        // for(int i=nums.length-k;i<nums.length;i++){
        //     p[index++]=nums[i];
        // }
        // for(int i=0;i<nums.length-k;i++){
        //     p[index++]=nums[i];
        // }

        // for(int i=0;i<nums.length;i++){
        //     nums[i]=p[i];
        // }
        int n=nums.length;
        k=k%n;
        reversed(nums,0,n-1);
        reversed(nums,0,k-1);
        reversed(nums,k,n-1);   
    }
    static void reversed(int nums[],int i,int j){
        while(j>i){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}