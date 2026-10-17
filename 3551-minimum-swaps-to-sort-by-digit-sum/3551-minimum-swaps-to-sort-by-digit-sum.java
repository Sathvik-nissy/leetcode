// class Solution {
//     public int minSwaps(int[] nums) {
//         int arr[]=new int[nums.length];
//         Map<Integer,Integer>map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             arr[i]=dids(nums[i]);
//             map.put(arr[i],nums[i]);
//         }
//         Arrays.sort(arr);
        
//         int res[]=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             res[i]=map.get(arr[i]);
//         }
//         int c=0;
//         for(int i=0;i<nums.length;i++){
//             if(res[i]!=nums[i]){
//                 c++;
//             }
//         }
//         return c/2;
        
//     }

//     static int dids(int num){
//         int sum=0;
//         while(num>0){
//         int r=num%10;
//         sum+=r;
//         num=num/10;
//         }
//         return sum;
//     }
// }

// import java.util.*;

// class Solution {
//     public int minSwaps(int[] nums) {
//         int arr[] = new int[nums.length];

//         // Store multiple numbers for the same digit sum
//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             arr[i] = dids(nums[i]);

//             map.putIfAbsent(arr[i], new ArrayList<>());
//             map.get(arr[i]).add(nums[i]);
//         }

//         Arrays.sort(arr);

//         int res[] = new int[nums.length];

//         // Track which number to take for each digit sum
//         Map<Integer, Integer> index = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             int sum = arr[i];
//             int pos = index.getOrDefault(sum, 0);

//             res[i] = map.get(sum).get(pos);
//             index.put(sum, pos + 1);
//         }

//         int c = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (res[i] != nums[i]) {
//                 c++;
//             }
//         }

//         return c / 2;
//     }

//     static int dids(int num) {
//         int sum = 0;

//         while (num > 0) {
//             int r = num % 10;
//             sum += r;
//             num /= 10;
//         }

//         return sum;
//     }
// }
// import java.util.*;

// class Solution {
//     public int minSwaps(int[] nums) {
//         int n = nums.length;

//         int[][] arr = new int[n][2];

//         for (int i = 0; i < n; i++) {
//             arr[i][0] = dids(nums[i]); // Digit sum
//             arr[i][1] = nums[i];       // Original number
//         }

//         Arrays.sort(arr, (a, b) -> {

//             if (a[0] != b[0]) {
//                 return Integer.compare(a[0], b[0]);
//             }
//             return Integer.compare(a[1], b[1]);
            
//             }
            
//             );

//         int[] res = new int[n];

//         for (int i = 0; i < n; i++) {
//             res[i] = arr[i][1];
//         }

//         int c = 0;
//         for (int i = 0; i < n; i++) {
//             if (res[i] != nums[i]) {
//                 c++;
//             }
//         }
//         return c / 2;
//     }

//     static int dids(int num) {
//         int sum = 0;

//         while (num > 0) {
//             int r = num % 10;
//             sum += r;
//             num = num / 10;
//         }

//         return sum;
//     }
// }


import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Store digit sum, number, and original index
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = dids(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        boolean[] visited = new boolean[n];
        int c = 0;

        // Find cycles to calculate minimum swaps
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int size = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                size++;
            }

            c += size - 1;
        }

        return c;
    }

    static int dids(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}