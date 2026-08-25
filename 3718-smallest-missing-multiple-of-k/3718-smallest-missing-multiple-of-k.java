class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer>set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        for(int i=1;;i++){
            int p=k*i;
            if(!set.contains(p)){
                return p;
            }
        }
        

        
    }
}