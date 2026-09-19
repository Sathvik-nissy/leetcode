// class Solution {
//     public int strStr(String haystack, String needle) {
//         if(haystack.contains(needle)){
//             return haystack.indexOf(needle);
//         }
//         return -1;
//     }
// }
class Solution {
    public int strStr(String h, String n) {
        if(!h.contains(n))return -1;
        for(int i=0;i<=h.length()-n.length();i++){
            if(h.substring(i, i + n.length()).equals(n))return i;
        }
        return -1;

        
    }
}

