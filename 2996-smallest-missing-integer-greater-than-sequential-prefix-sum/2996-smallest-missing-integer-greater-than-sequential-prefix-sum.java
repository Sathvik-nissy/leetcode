class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int y:nums){
            set.add(y);

        }
        int sum=0;
        sum=miss(nums,0,sum);
        int sum1=sum;
        return miss2(sum1,set);
        
    }

static int miss(int[] nums, int i, int sum) {
    sum += nums[i];

    if (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
        return miss(nums, i + 1, sum);
    }

    return sum;
}

    static int miss2(int y,Set<Integer>set){
        if(!set.contains(y)){
            return y;
        }else{
            return miss2(y+1,set);
        }
    }
}