// class Solution {
//     public int[] lexicographicallySmallestArray(int[] arr, int limit) {
//         for(int j=1;j<arr.length;j++){
//             int i=j-1;
//             if((arr[i]>arr[j]) && (Math.abs(arr[j]-arr[i])<=limit)){
//                 swap(arr, i, j);
//             }

//         }
//         return arr;
        
//     }

// static void swap(int[] arr, int i, int j){
//     int temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;
// }

// }
class Solution {
    public int[] lexicographicallySmallestArray(int[] A, int limit) {
        int[] srt = A.clone();
        Arrays.sort(srt);
        List<List<Integer>> grps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = -1;

        for (int i = 0; i < srt.length; i++) {
            if (i == 0 || srt[i] - srt[i - 1] > limit) {
                grps.add(new ArrayList<>());
                id++;
            }
            
            grps.get(id).add(srt[i]);
            map.put(srt[i], id);
        }

        int[] idx = new int[grps.size()];

        for (int i = 0; i < A.length; i++) {
            int cur = map.get(A[i]);
            A[i] = grps.get(cur).get(idx[cur]);
            idx[cur]++;
        }

        return A;
    }
}