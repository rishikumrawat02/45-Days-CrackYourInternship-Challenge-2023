class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String str)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c=str.charAt(i);
            if(Character.isDigit(c)){
                st.push(Character.getNumericValue(c));
            }else{
                int dig1=st.pop(); int dig2=st.pop();
                if(c=='+'){
                    st.push(dig1+dig2);
                }else if(c=='-'){
                    st.push(dig2-dig1);
                }else if(c=='*'){
                    st.push(dig2*dig1);
                }else{
                    st.push(dig2/dig1);
                }
            }
        }
        return st.pop();
    }
}
