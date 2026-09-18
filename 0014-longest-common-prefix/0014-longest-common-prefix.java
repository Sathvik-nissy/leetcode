// class Solution {
//     public String longestCommonPrefix(String[] s) {
//         if(s.length==0){
//             return "";
//         }
        // String f=s[0];
        // for(int i=1;i<s.length;i++){
        //     while(s[i].indexOf(f)!=0){
        //         f=f.substring(0,f.length()-1);
        //     }
        //     if(f.isEmpty()){
        //         return "";
        //     }
        // }
        // return f;
//     }
// }
class Solution {
    public String longestCommonPrefix(String[] s) {
        if (s.length == 0) return "";

        int min = s[0].length();
        for (int i = 1; i < s.length; i++) {
            min = Math.min(min, s[i].length());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            char c = s[0].charAt(i);

            for (int j = 1; j < s.length; j++) {
                if (s[j].charAt(i) != c) {
                    return sb.toString();
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
