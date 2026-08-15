class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double max=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        max=sum;
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i]-nums[i-k];
            max=Math.max(max,sum);
        }
        return max/k;
        
        
    }
}



// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<=nums.length-k;i++){
//             int sum=0;
//             for(int j=i;j<i+k;j++){
//                 sum=sum+nums[j];
//             }         
//             max=Math.max(max,sum);
//         }

        
//         return max*1.00000/k;


//     }
// }