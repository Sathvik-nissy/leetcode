class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String>map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
                map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuilder resd=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                StringBuilder sb=new StringBuilder();
                for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)==')'){
                    String res=sb.toString();
                    if(map.containsKey(res)){
                    resd.append(map.get(res));
                    }else{
                        resd.append('?');
                    }
                    i=j;
                    break;
                }else{
                    sb.append(s.charAt(j));
                }
            }
            }else{
                resd.append(s.charAt(i));
            }
        }

        return resd.toString();       
    }
}