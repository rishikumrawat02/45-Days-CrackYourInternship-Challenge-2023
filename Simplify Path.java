class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i)=='.'){
                StringBuilder str = new StringBuilder(); boolean isDotOnly=true;
                while(i<path.length() && path.charAt(i)!='/'){
                    if(path.charAt(i)!='.') isDotOnly=false;
                    str.append(path.charAt(i)); i++;
                }
                if(str.length()==2 && isDotOnly){
                    if(!st.isEmpty()) st.pop();
                }else if(str.length()!=1) st.push(str.toString());
            }else if(path.charAt(i)!='/'){
                StringBuilder str = new StringBuilder();
                while(i<path.length() && path.charAt(i)!='/'){
                    str.append(path.charAt(i)); i++;
                }
                System.out.println(str);
                st.push(str.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,st.pop());
            res.insert(0,'/');
        }
        if(res.length()==0 && path.length()!=0) return "/";
        return res.toString();
    }
}
