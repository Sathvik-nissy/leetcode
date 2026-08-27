// class Solution {
//     static String ans = "";
//     static String tar;

//     public String lexGreaterPermutation(String s, String target) {
//         ans = "";
//         tar = target;
//         per(s.toCharArray(), 0);
//         return ans;
//     }


//     static void per(char[]arr,int idx){
//         if(idx==arr.length){
//             String res=new String(arr);
//             if (res.compareTo(tar)>0 && (ans.isEmpty() || res.compareTo(ans) < 0) ) {
//                 ans = res;
//             }
//             return ;
//         }

//         for(int i=idx;i<arr.length;i++){
//             swap(i,idx,arr);
//             per(arr,idx+1);
//             swap(i,idx,arr);
//         }
        
//     }

//     static void swap(int i,int j,char[]arr){
//         char temp=arr[i];
//         arr[i]=arr[j];
//         arr[j]=temp;
//     }
// }
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            cnt[ch - 'a']--;
        }

        for (int i = target.length() - 1; i >= 0; i--) {
            int cur = target.charAt(i) - 'a';
            cnt[cur]++;

            boolean ok = true;
            for (int x : cnt) {
                if (x < 0) {
                    ok = false;
                    break;
                }
            }

            if (!ok) continue;

            int next = -1;
            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) continue;

            cnt[next]--;

            StringBuilder ans = new StringBuilder(target.substring(0, i));
            ans.append((char) ('a' + next));

            for (int c = 0; c < 26; c++) {
                while (cnt[c]-- > 0) {
                    ans.append((char) ('a' + c));
                }
            }

            return ans.toString();
        }

        return "";
    }
}
