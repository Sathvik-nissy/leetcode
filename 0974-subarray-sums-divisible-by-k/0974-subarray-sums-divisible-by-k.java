class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0,count=0;
        map.put(0,1);
        for(int x:nums){
            sum+=x;
            int r=sum%k;
            if(r<0){
                r+=k;
            }

            if(map.containsKey(r)){
                count=count+map.get(r);
            }

            

            map.put(r,map.getOrDefault(r,0)+1);


        }

        return count;
        
    }
}