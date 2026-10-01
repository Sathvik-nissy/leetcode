class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();

        char c[]=s.toCharArray();
        for(char ch:c){
        if(ch =='('||ch =='['||ch =='{'){
            st.push(ch);
        }else{
            if(st.isEmpty()){
                return false;
            }
            if(st.peek()=='('&& ch==')'||
               st.peek()=='['&& ch==']'||
               st.peek()=='{'&& ch=='}'){
                 st.pop();
            }else{
                return false;
            }

        }
        }

        return st.isEmpty();
        
    }

}
