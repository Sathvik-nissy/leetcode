class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s){
            sb.append(ch);
        }
        int idx=0;
        for(int i=sb.length()-1;i>=0;i--){
            s[idx++]=sb.charAt(i);

        }
        
    }
}