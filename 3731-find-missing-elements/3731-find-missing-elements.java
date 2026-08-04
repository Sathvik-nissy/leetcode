class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>l=new ArrayList<>();
        for(int x:nums){
            l.add(x);
        }
        List<Integer>li=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        for(int i=min;i<=max;i++){
            if(!l.contains(i)){
                li.add(i);
            }
        }
        return li;

        


        
    }
}