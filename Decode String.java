class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<String> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                StringBuilder num = new StringBuilder();
                while(i<n && Character.isDigit(s.charAt(i))){
                    num.append(s.charAt(i)); i++;
                } st.push(num.toString()); i--;
            }else if(c=='['){
                st.push("[");
            }else if(c==']'){
                StringBuilder str = new StringBuilder();
                while(!st.peek().equals("[")){
                    str.insert(0,st.pop());
                }
                st.pop();
                int num = Integer.parseInt(st.pop());
                StringBuilder decoded = new StringBuilder();
                while(num-->0) decoded.append(str);
                if(!st.isEmpty() && !st.peek().equals("[")){
                    String cur = st.pop();
                    st.push(cur+decoded.toString());
                }else{
                    st.push(decoded.toString());
                }
            }else{
                StringBuilder str = new StringBuilder();
                while(i<n && Character.isLetter(s.charAt(i))){
                    str.append(s.charAt(i));
                    i++;
                }
                i--;
                st.push(str.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}
