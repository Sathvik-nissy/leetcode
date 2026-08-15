class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int max=0,l=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            while(map.get(s.charAt(i))>1){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
        
    }
}





// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Map<Character,Integer>map=new HashMap<>();
//         StringBuilder sb=new StringBuilder();
//         for(int i=0;i<s.length();i++){
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//             if(map.get(s.charAt(i))==1 && k-i=1){
//             sb.append(s.charAt(i));
//                int k=i;
//             }
//         }
//         String res=sb.toString();
//         return res.length();
        
//     }
// }


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         for(int i = 0; i < s.length(); i++) {
//             HashSet<Character> set = new HashSet<>();
//             for(int j = i; j < s.length(); j++) {
//                 if(set.contains(s.charAt(j))) {
//                     break;
//                 }
//                 set.add(s.charAt(j));
//                 max = Math.max(max, j - i + 1);
//             }
//         }

//         return max;
//     }
// }
