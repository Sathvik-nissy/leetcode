class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        int link[]=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                link[i]=st.pop();
                link[link[i]]=i;  
            }
        }

        int i=0;
        int direc=1;
        StringBuilder sb=new StringBuilder();

        while(i<n){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }else{
                i=link[i];
                direc=-direc;
            }
            i=i+direc;
        }
        return sb.toString();
        
    }
}