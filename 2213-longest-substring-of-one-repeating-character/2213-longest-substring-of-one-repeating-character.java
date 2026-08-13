// class Solution {
//     public int[] longestRepeating(String s, String q, int[] qi) {
//         StringBuilder sb=new StringBuilder();
//         for(char ch:s.toCharArray()){
//             sb.append(ch);
//         }

//         int idx=0;
//         int []arr=new int[q.length()];

//         for(int  i=0;i<q.length();i++){
//             sb.setCharAt(qi[i],q.charAt(i));
//             if(idx==0){
//             arr[idx++]=lg(sb.toString());



//         }
//         return arr;
//     }

//         static int lg(String x){
//             int dp[]=new int[x.length()];
//             dp[0]=1;
//             for(int i=1;i<x.length();i++){
//                 dp[i]=(x.charAt(i-1)==x.charAt(i))?dp[i-1]+1:1;
//             }
//             int max=1;
//             for(int k:dp){
//                 max=Math.max(max,k);
//             }

//             return max;


//         }
// }



import java.util.TreeSet;

class Solution {
    // Class-level variables to mimic the C++ lambda captures
    TreeSet<Integer> boundaries;
    TreeSet<Integer> lengths;
    int[] count;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        
        // Initialize the data structures
        boundaries = new TreeSet<>();
        lengths = new TreeSet<>();
        count = new int[n + 1];

        // 1. Initial Setup of boundaries and lengths
        boundaries.add(0);
        boundaries.add(n);
        int prev = 0;
        
        for (int i = 1; i < n; ++i) {
            if (sArr[i - 1] != sArr[i]) {
                boundaries.add(i);
                addLen(i - prev);
                prev = i;
            }
        }
        addLen(n - prev);

        int[] result = new int[queryIndices.length];

        // 2. Process each query
        for (int i = 0; i < queryIndices.length; ++i) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);

            // Check the boundary to the LEFT of the changed character
            if (idx > 0) {
                boolean oldState = (sArr[idx - 1] != sArr[idx]);
                boolean newState = (sArr[idx - 1] != c);
                if (oldState != newState) {
                    update(idx, newState);
                }
            }
            
            // Check the boundary to the RIGHT of the changed character
            if (idx + 1 < n) {
                boolean oldState = (sArr[idx] != sArr[idx + 1]);
                boolean newState = (c != sArr[idx + 1]);
                if (oldState != newState) {
                    update(idx + 1, newState);
                }
            }

            // Apply the change
            sArr[idx] = c;
            
            // .last() gets the maximum length in the TreeSet
            result[i] = lengths.last();
        }

        return result;
    }

    // Helper: Adds a length to our tracking sets
    private void addLen(int len) {
        count[len]++;
        if (count[len] == 1) {
            lengths.add(len);
        }
    }

    // Helper: Removes a length from our tracking sets
    private void removeLen(int len) {
        count[len]--;
        if (count[len] == 0) {
            lengths.remove(len);
        }
    }

    // Helper: Adds or removes a boundary and updates affected chunk lengths
    private void update(int i, boolean set) {
        if (set) {
            // A new boundary is formed (character difference introduced)
            int next = boundaries.higher(i);
            int prev = boundaries.lower(i);

            removeLen(next - prev);
            addLen(i - prev);
            addLen(next - i);

            boundaries.add(i);
        } else {
            // An old boundary is removed (characters fused together)
            int next = boundaries.higher(i);
            int prev = boundaries.lower(i);

            removeLen(i - prev);
            removeLen(next - i);
            addLen(next - prev);

            boundaries.remove(i);
        }
    }
}


