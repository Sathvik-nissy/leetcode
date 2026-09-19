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

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer , Integer> map = new HashMap<>();
//         for(int i : nums){
//             map.put(i , map.getOrDefault(i , 0)+1);
//         }

//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
//         for(int i : map.keySet()){
//             pq.offer(i);
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }

//         int[] ans = new int[k];
//         for(int i = 0; i < k  ; i++){
//             ans[i] = pq.poll();
//         }

//         return ans;
//     }
// }