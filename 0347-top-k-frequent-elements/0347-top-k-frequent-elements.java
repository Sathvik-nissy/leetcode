class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int f=Integer.MIN_VALUE,s=Integer.MIN_VALUE;
        Map<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        List<Integer>li=new ArrayList<>(map.keySet());
        li.sort((a,b)->map.get(b)-map.get(a));
        int idx=0;
        int arr[]=new int[k];

        for(int i=0;i<k;i++){
            arr[idx++]=li.get(i);

        }
        return arr;
        
    }
}