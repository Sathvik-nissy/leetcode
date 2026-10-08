class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder s1=new StringBuilder();
        int o=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(o==0){
                    o++;
                }else{
                    s1.append(s.charAt(i));
                    o++;

                }
                
            }else{
                o--;
                if(o>0){
                    s1.append(s.charAt(i));
                }
            }
        }
        return s1.toString();

        
    }
}